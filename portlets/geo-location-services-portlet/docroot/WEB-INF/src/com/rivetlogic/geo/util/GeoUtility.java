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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.geo.portlet.GeoServicesPortletConstants;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GeoUtility {
	private static final Log LOG =
		    LogFactoryUtil.getLog(GeoUtility.class);

	public static long ipToLong(String ip) {
		InetAddress inetIp;
		long result = GeoServicesPortletConstants.DEFAULT_ID;

		try {
			inetIp = InetAddress.getByName(ip);
			byte[] octets = inetIp.getAddress();

			for (byte octet : octets) {
	            result <<= GeoServicesPortletConstants.OCTET_NUMBER;
	            result |= octet
	                    & GeoServicesPortletConstants.LAST_EIGHT_BITS;
	        }
		} catch (UnknownHostException e) {
			LOG.error(e);
		}

        return result;
    }

	//Get subnet mask
    private static int getSubnetMask(int maskLenght) {
        return maskLenght - GeoServicesPortletConstants.BIT_DIFFERENCE;
	}

	//Get IP in IPv4 format
    public static String getNetworkStartIP(String IPv6) {
	    String IPv4 = StringPool.BLANK;

		if (IPv6.contains(GeoServicesPortletConstants.IPV6_MAP)) {
            IPv4 = IPv6.replace(GeoServicesPortletConstants.IPV6_MAP, StringPool.BLANK);
		}
		return IPv4;
	}

	//IP in CIDR format like: 10.1.0.25/16
	public static String getIP_CIDR(String ip, int maskLenght) {
		return ip + StringPool.FORWARD_SLASH + getSubnetMask(maskLenght);
	}

	public static long getHostIP() {
		long ip = GeoServicesPortletConstants.DEFAULT_ID;

		return ip;
	}
}
