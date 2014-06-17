/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.rivetlogic.geo.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.rivetlogic.geo.model.GeoBlocks;
import com.rivetlogic.geo.model.GeoLocations;
import com.rivetlogic.geo.model.impl.GeoBlocksImpl;
import com.rivetlogic.geo.model.impl.GeoLocationsImpl;
import com.rivetlogic.geo.portlet.GeoServicesPortletConstants;
import com.rivetlogic.geo.service.GeoBlocksLocalServiceUtil;
import com.rivetlogic.geo.service.GeoLocationsLocalServiceUtil;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

public class GeoMessageListener implements MessageListener {
    private static final Log LOG =
            LogFactoryUtil.getLog(GeoMessageListener.class);

    public void receive(Message message) {
        try {
            if (message.getDestinationName().equals(
                    GeoServicesPortletConstants.MESSAGE_DESTINATION)) {
                doReceive(message);
            } else if (message.getDestinationName().equals(
                    GeoServicesPortletConstants.MESSAGE_RESPONSE)) {
                doReceiveResponse(message);
            }
        } catch (IOException e) {
            LOG.error(GeoServicesPortletConstants.ERROR_PROCESSING_MESSAGE, e);
        }
    }

    protected void doReceive(Message message) throws IOException {
        InputStream locations =
                (InputStream) message.get(
                        GeoServicesPortletConstants.ATTR_GEO_LOCATIONS_CSV);
        InputStream blocks =
                (InputStream) message.get(
                        GeoServicesPortletConstants.ATTR_GEO_BLOCKS_CSV);

        getLocationFields(locations);
        getBlockFields(blocks);

		String responseDestination =
		        message.getString(
		                GeoServicesPortletConstants.RESPONSE_RECEIVER);
		String userId = message.getString(GeoServicesPortletConstants.USER_ID);

		Message responseMessage = new Message();
		responseMessage.put(
		        GeoServicesPortletConstants.RESPONSE_MESSAGE,
		        GeoServicesPortletConstants.SUCCESS_PROCESSING_CSV_FILES);
		responseMessage.put(GeoServicesPortletConstants.USER_ID, userId);

	    MessageBusUtil.sendMessage(responseDestination, responseMessage);
	}

    public void doReceiveResponse(Message message) throws IOException {
        Long userId = message.getLong(GeoServicesPortletConstants.USER_ID);
        String type = GeoServicesPortletConstants.PORTLET_ID;
        Calendar cal = Calendar.getInstance();

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put(GeoServicesPortletConstants.NOTIFICATION_MESSAGE,
                message.getString(GeoServicesPortletConstants.RESPONSE_MESSAGE));

        NotificationEvent notificationEvent =
                new NotificationEvent(cal.getTimeInMillis(), type, jsonObject);
        try {
            UserNotificationEventLocalServiceUtil
                    .addUserNotificationEvent(userId, notificationEvent);
        } catch (PortalException e) {
            LOG.error(e);
        } catch (SystemException e) {
            LOG.error(e);
        }
	}

    /**
     * @param inputStream
     * @throws IOException
     */
    private void getLocationFields(InputStream inputStream) throws IOException {
        String strLine = null;
        DataInputStream in = new DataInputStream(inputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        GeoLocationsLocalServiceUtil.truncateTable();

        GeoLocations location = null;
        String[] values;

        br.readLine(); //read the first line and throw it away
        while (((strLine = br.readLine()) != null) && !strLine.isEmpty()) {
            location = new GeoLocationsImpl();
            values = strLine.split(GeoServicesPortletConstants.SEPARATOR);
            
            //In some weird cases there is a geonameId without country ISO
            if(values.length > GeoServicesPortletConstants.LOCATIONS_FILE_INDEX_COUNTRYISOCODE) {
                location.setGeonameId(Long.parseLong(values[
                        GeoServicesPortletConstants.LOCATIONS_FILE_INDEX_GEONAMEID]));
                location.setCountryIsoCode(values[
                         GeoServicesPortletConstants.LOCATIONS_FILE_INDEX_COUNTRYISOCODE]
                                .trim());
                try {
                    GeoLocationsLocalServiceUtil.addGeoLocations(location);
                } catch (SystemException e) {
                    LOG.error(e);
                }
            }
        }
    }

    private void getBlockFields(InputStream inputStream) throws IOException {
        String strLine = null;
        DataInputStream in = new DataInputStream(inputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        GeoBlocksLocalServiceUtil.truncateTable();

        GeoBlocks block = null;
        String[] values;
        String networkStartIP;

        br.readLine(); //read the first line and throw it away
        while (((strLine = br.readLine()) != null) && !strLine.isEmpty()) {
            block = new GeoBlocksImpl();
            values = strLine.split(GeoServicesPortletConstants.SEPARATOR);

            networkStartIP = GeoUtility.getNetworkStartIP(values[
                    GeoServicesPortletConstants.BLOCKS_FILE_INDEX_NETWORKSTARTIP]);

            //IP can be translated to IPv4 format
            if (!networkStartIP.equals(StringPool.BLANK)) {
                int maskLenght = Integer.parseInt(values[
                        GeoServicesPortletConstants.BLOCKS_FILE_INDEX_NETWORKMASK]);
                
                if(maskLenght - GeoServicesPortletConstants.BIT_DIFFERENCE 
                        > GeoServicesPortletConstants.LOWER_VALID_NETMASK_LENGHT){
                    IPv4 ip = new IPv4(
                            GeoUtility.getIP_CIDR(
                                    networkStartIP, maskLenght));

                    long geonameId = GeoServicesPortletConstants.DEFAULT_ID;;
                    if (!values[GeoServicesPortletConstants.BLOCKS_FILE_INDEX_GEONAMEID].equals(StringPool.BLANK)) {
                        geonameId = Long.parseLong(values[
                                GeoServicesPortletConstants.BLOCKS_FILE_INDEX_GEONAMEID]);
                    } else {
                        if (!values[GeoServicesPortletConstants.BLOCKS_FILE_INDEX_REGISTERDCOUNTRY_GEONAMEID].equals(StringPool.BLANK)) {
                            geonameId = Long.parseLong(values[
                                    GeoServicesPortletConstants.BLOCKS_FILE_INDEX_REGISTERDCOUNTRY_GEONAMEID]);
                        }
                    }

                    //There was a geonameId associated to the ip
                    if (geonameId != GeoServicesPortletConstants.DEFAULT_ID) {
                        block.setGeonameId(geonameId);

                        String addressRange = ip.getHostAddressRange();

                        //firstIP + " - " + lastIP
                        String[] startEnd = 
                                addressRange.split(GeoServicesPortletConstants.RANGE_SEPARATOR);
                        block.setStartIp(
                                GeoUtility.ipToLong(startEnd[0]));
                        block.setEndIp(GeoUtility.ipToLong(startEnd[1]));
                        try {
                            GeoBlocksLocalServiceUtil.addGeoBlocks(block);
                        } catch (SystemException e) {
                            LOG.error(e);
                        }
                    }
                }
            }
        }
    }
}
