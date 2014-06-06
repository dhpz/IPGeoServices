<%-- 
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
 */
--%>

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="processGeoipFiles" var="processGeoipFilesURL" />

<liferay-ui:success key="<%=IPGeoServicesPortletConstants.UPLOAD_SUCCESS_KEY%>" 
        message="<%=IPGeoServicesPortletConstants.SUCCESS_UPLOADING_CSV%>" />

<aui:form name="ipgeoservices" action="${processGeoipFilesURL}" method="POST" enctype="multipart/form-data">
	<aui:fieldset label="geoip-files">
    	<%--Locations GeoIP csv--%>
        <aui:input name="<%=IPGeoServicesPortletConstants.ATTR_GEOIP_LOCATIONS_CSV%>" type="file" label="geoip-location-csv">
        	<aui:validator name="acceptFiles">'csv'</aui:validator>
        	<aui:validator name="required" />
        </aui:input>
        <%--Blocks GeoIP csv--%>
        <aui:input name="<%=IPGeoServicesPortletConstants.ATTR_GEOIP_BLOCKS_CSV%>" type="file" label="geoip-blocks-csv">
        	<aui:validator name="acceptFiles">'csv'</aui:validator>
        	<aui:validator name="required" />
        </aui:input>
    </aui:fieldset>
    
    <aui:button type="submit" name="submit" value='process-geoip'/>
</aui:form>
