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

import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl;
import com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl;

public class IPGeoServicesPortletConstants {
    public static final String ATTR_GEOIP_LOCATIONS_CSV = "locationsCsv";
    public static final String ATTR_GEOIP_BLOCKS_CSV = "blocksCsv";

    public static final String ERROR_PROCESSING_CSV = "geoip-error-processing-csv";
    public static final String ERROR_PROCESSING_MESSAGE = "geoip-error-processing-message";

    public static final String SUCCESS_UPLOADING_CSV = "geoip-upload-success";
    public static final String UPLOAD_SUCCESS_KEY = "geoip-upload-success-key";
    public static final String SUCCESS_PROCESSING_CSV_FILES = "geoip-process-csv-success";

    public static final String LOCATIONS_TABLE = GeoipLocationsModelImpl.TABLE_NAME;// "rivetlogic_geoip_GeoipLocations";
    public static final String BLOCKS_TABLE = GeoipBlocksModelImpl.TABLE_NAME;//"rivetlogic_geoip_GeoipBlocks";

    public static final String IPV6_MAP = "::ffff:";	//IPv4 address that was mapped to IPv6
    public static final int BIT_DIFFERENCE = 96;		//Difference between IPv4 and IPv6
    public static final int LAST_EIGHT_BITS = 0xff;
    public static final int OCTET_NUMBER = 8;
    public static final int LOWER_VALID_NETMASK_LENGHT = 8;
    public static final Long DEFAULT_ID = 0L; 

    public static final String SEPARATOR = StringPool.COMMA;
    public static final String RANGE_SEPARATOR = " - ";
    public static final String SQL_TRUNCATE = " truncate table ";

    public static final int LOCATIONS_FILE_INDEX_GEONAMEID = 0;
    public static final int LOCATIONS_FILE_INDEX_COUNTRYISOCODE = 3;
    public static final int BLOCKS_FILE_INDEX_NETWORKSTARTIP = 0;
    public static final int BLOCKS_FILE_INDEX_NETWORKMASK = 1;
    public static final int BLOCKS_FILE_INDEX_GEONAMEID = 2;
    public static final int BLOCKS_FILE_INDEX_REGISTERDCOUNTRY_GEONAMEID = 3;

    public static final String MESSAGE_DESTINATION = "geoip/files";
    public static final String MESSAGE_RESPONSE = "geoip/files/response";
    public static final String RESPONSE_RECEIVER = "responseReceiver";
    public static final String RESPONSE_MESSAGE = "response";
    public static final String NOTIFICATION_MESSAGE = "notificationMessage";

    public static final String USER_ID = "userId";
    public static final String PORTLET_ID = "ipgeoservices_WAR_IPGeoServicesportlet";
    public static final String GEOIP_MESSAGE = "geoip-message";
}
