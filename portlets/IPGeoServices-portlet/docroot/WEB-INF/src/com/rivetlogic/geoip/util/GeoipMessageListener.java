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

package com.rivetlogic.geoip.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

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
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.rivetlogic.geoip.model.GeoipBlocks;
import com.rivetlogic.geoip.model.GeoipLocations;
import com.rivetlogic.geoip.model.impl.GeoipBlocksImpl;
import com.rivetlogic.geoip.model.impl.GeoipLocationsImpl;
import com.rivetlogic.geoip.portlet.IPGeoServicesPortletConstants;
import com.rivetlogic.geoip.service.GeoipBlocksLocalServiceUtil;
import com.rivetlogic.geoip.service.GeoipLocationsLocalServiceUtil;

public class GeoipMessageListener implements MessageListener {
    private static final Log LOG =
            LogFactoryUtil.getLog(GeoipMessageListener.class);

    public void receive(Message message) {
        try {
            if (message.getDestinationName().equals(
                    IPGeoServicesPortletConstants.MESSAGE_DESTINATION)) {
                doReceive(message);
            } else if (message.getDestinationName().equals(
                    IPGeoServicesPortletConstants.MESSAGE_RESPONSE)) {
                doReceiveResponse(message);
            }
        } catch (IOException e) {
            LOG.error(IPGeoServicesPortletConstants.ERROR_PROCESSING_MESSAGE, e);
        }
    }

    protected void doReceive(Message message) throws IOException {
        InputStream locations =
                (InputStream) message.get(
                        IPGeoServicesPortletConstants.ATTR_GEOIP_LOCATIONS_CSV);
        InputStream blocks =
                (InputStream) message.get(
                        IPGeoServicesPortletConstants.ATTR_GEOIP_BLOCKS_CSV);

        //getLocationFields(locations);
        //getBlockFields(blocks);

		String responseDestination =
		        message.getString(
		                IPGeoServicesPortletConstants.RESPONSE_RECEIVER);
		String userId = message.getString(IPGeoServicesPortletConstants.USER_ID);

		Message responseMessage = new Message();
		responseMessage.put(
		        IPGeoServicesPortletConstants.RESPONSE_MESSAGE,
		        IPGeoServicesPortletConstants.SUCCESS_PROCESSING_CSV_FILES);
		responseMessage.put(IPGeoServicesPortletConstants.USER_ID, userId);

	    MessageBusUtil.sendMessage(responseDestination, responseMessage);
	}

    public void doReceiveResponse(Message message) throws IOException {
        Long userId = message.getLong(IPGeoServicesPortletConstants.USER_ID);
        String type = IPGeoServicesPortletConstants.PORTLET_ID;
        Calendar cal = Calendar.getInstance();

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put(IPGeoServicesPortletConstants.NOTIFICATION_MESSAGE,
                message.getString(IPGeoServicesPortletConstants.RESPONSE_MESSAGE));

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

        GeoipLocationsLocalServiceUtil.truncateTable();

        GeoipLocations location = null;
        String[] values;

        br.readLine(); //read the first line and throw it away
        /*while (((*/strLine = br.readLine();//) != null) && !strLine.isEmpty()) {
            location = new GeoipLocationsImpl();
            values = strLine.split(
                    IPGeoServicesPortletConstants.SEPARATOR);

            location.setGeonameId(Long.parseLong(values[
                    IPGeoServicesPortletConstants.LOCATIONS_FILE_INDEX_GEONAMEID]));
            location.setCountryIsoCode(values[
                    IPGeoServicesPortletConstants.LOCATIONS_FILE_INDEX_COUNTRYISOCODE]
                            .trim());

            try {
                GeoipLocationsLocalServiceUtil.addGeoipLocations(location);
			} catch (SystemException e) {
			    LOG.error(e);
			}
        //}
    }

    private void getBlockFields(InputStream inputStream) throws IOException {
        String strLine = null;
        DataInputStream in = new DataInputStream(inputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        GeoipBlocksLocalServiceUtil.truncateTable();

        GeoipBlocks block = null;
        String[] values;
        String networkStartIP;

        br.readLine(); //read the first line and throw it away
        /*while (((*/strLine = br.readLine();//) != null) && !strLine.isEmpty()) {
            block = new GeoipBlocksImpl();
            values = strLine.split(
                    IPGeoServicesPortletConstants.SEPARATOR);

            networkStartIP = GeoipUtility.getNetworkStartIP(values[
                    IPGeoServicesPortletConstants.BLOCKS_FILE_INDEX_NETWORKSTARTIP]);

            //IP can be translated to IPv4 format
            if (!networkStartIP.equals("")) {
                int maskLenght = Integer.parseInt(values[
                        IPGeoServicesPortletConstants.BLOCKS_FILE_INDEX_NETWORKMASK]);
                IPv4 ip = new IPv4(
                        GeoipUtility.getIP_CIDR(
                                networkStartIP, maskLenght));

                long geonameId = 0L;
                if (!values[IPGeoServicesPortletConstants.BLOCKS_FILE_INDEX_GEONAMEID].equals("")) {
            	    geonameId = Long.parseLong(values[
            	            IPGeoServicesPortletConstants.BLOCKS_FILE_INDEX_GEONAMEID]);
                } else {
            	    if (!values[IPGeoServicesPortletConstants.BLOCKS_FILE_INDEX_REGISTERDCOUNTRY_GEONAMEID].equals("")) {
            		    geonameId = Long.parseLong(values[
            		        IPGeoServicesPortletConstants.BLOCKS_FILE_INDEX_REGISTERDCOUNTRY_GEONAMEID]);
            		}
            	}

            	//There was a geonameId associated to the ip
                if (geonameId != 0L) {
		            block.setGeonameId(geonameId);

		            String addressRange = ip.getHostAddressRange();

		            //firstIP + " - " + lastIP
		            String[] startEnd = addressRange.split(" - ");
		            block.setStartIp(
		                    GeoipUtility.ipToLong(startEnd[0]));
		            block.setEndIp(GeoipUtility.ipToLong(startEnd[1]));
	            	try {
					    GeoipBlocksLocalServiceUtil
					            .addGeoipBlocks(block);
					} catch (SystemException e) {
					    LOG.error(e);
					}
            	}
            }
        //}
    }
}
