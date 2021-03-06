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

package com.rivetlogic.geoip.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GeoipISOCodePortlet
 */
public class IPGeoServicesPortlet extends MVCPortlet {
    private static final Log logger =
    		LogFactoryUtil.getLog(IPGeoServicesPortlet.class);

	public void processGeoipFiles(ActionRequest request, ActionResponse response) {
    	UploadPortletRequest uploadRequest =
    			PortalUtil.getUploadPortletRequest(request);

    	File locationsFile =
    			uploadRequest.getFile(IPGeoServicesPortletConstants.ATTR_GEOIP_LOCATIONS_CSV);
    	File blocksFile =
    			uploadRequest.getFile(IPGeoServicesPortletConstants.ATTR_GEOIP_BLOCKS_CSV);

    	ThemeDisplay themeDisplay =
    	        (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
    	 ServiceContext serviceContext = new ServiceContext();
    	 serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

    	try {
			InputStream locations = new FileInputStream(locationsFile);
			InputStream blocks = new FileInputStream(blocksFile);

			Message message = new Message();
			message.put(IPGeoServicesPortletConstants.ATTR_GEOIP_LOCATIONS_CSV, locations);
			message.put(IPGeoServicesPortletConstants.ATTR_GEOIP_BLOCKS_CSV, blocks);
			message.put(IPGeoServicesPortletConstants.RESPONSE_RECEIVER, 
					IPGeoServicesPortletConstants.MESSAGE_RESPONSE);
			message.put(IPGeoServicesPortletConstants.USER_ID, themeDisplay.getUserId());
			MessageBusUtil.sendMessage(IPGeoServicesPortletConstants.MESSAGE_DESTINATION, message);

			SessionMessages.add(request, IPGeoServicesPortletConstants.UPLOAD_SUCCESS_KEY);
		} catch (FileNotFoundException e) {
			SessionErrors.add(request, IPGeoServicesPortletConstants.ERROR_PROCESSING_CSV);
            logger.error(e);
		}
    }
}
