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

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rivetlogic.geoip.portlet.IPGeoServicesPortletConstants;

public class GeoipUtility {
	private static final Log LOG =
		    LogFactoryUtil.getLog(GeoipUtility.class);

	public static long ipToLong(String ip) {
		InetAddress inetIp;
		long result = 0;

		try {
			inetIp = InetAddress.getByName(ip);
			byte[] octets = inetIp.getAddress();

			for (byte octet : octets) {
	            result <<= IPGeoServicesPortletConstants.OCTET_NUMBER;
	            result |= octet
	                    & IPGeoServicesPortletConstants.LAST_EIGHT_BITS;
	        }
		} catch (UnknownHostException e) {
			LOG.error(e);
		}

        return result;
    }

	//Get subnet mask
    private static int getSubnetMask(int maskLenght) {
        return maskLenght - IPGeoServicesPortletConstants.BIT_DIFFERENCE;
	}

	//Get IP in IPv4 format
    public static String getNetworkStartIP(String IPv6) {
	    String IPv4 = "";

		if (IPv6.contains(IPGeoServicesPortletConstants.IPV6_MAP)) {
            IPv4 = IPv6.replace(IPGeoServicesPortletConstants.IPV6_MAP, "");
		}
		return IPv4;
	}

	//IP in CIDR format like: 10.1.0.25/16
	public static String getIP_CIDR(String ip, int maskLenght) {
		return ip + "/" + getSubnetMask(maskLenght);
	}

	public static long getHostIP() {
		long ip = 0L;

		return ip;
	}
}
