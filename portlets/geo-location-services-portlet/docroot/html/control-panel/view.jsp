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

<portlet:actionURL name="processGeoFiles" var="processGeoFilesURL" />

<liferay-ui:success key="<%=GeoServicesPortletConstants.UPLOAD_SUCCESS_KEY%>" 
        message="<%=GeoServicesPortletConstants.SUCCESS_UPLOADING_CSV%>" />

<aui:form name="geoservices" action="${processGeoFilesURL}" method="POST" enctype="multipart/form-data">
	<aui:fieldset label="geo-files">
    	<%--Locations Geo csv--%>
        <aui:input name="<%=GeoServicesPortletConstants.ATTR_GEO_LOCATIONS_CSV%>" type="file" label="geo-location-csv">
        	<aui:validator name="acceptFiles">'csv'</aui:validator>
        	<aui:validator name="required" />
        </aui:input>
        <%--Blocks Geo csv--%>
        <aui:input name="<%=GeoServicesPortletConstants.ATTR_GEO_BLOCKS_CSV%>" type="file" label="geo-blocks-csv">
        	<aui:validator name="acceptFiles">'csv'</aui:validator>
        	<aui:validator name="required" />
        </aui:input>
    </aui:fieldset>
    
    <aui:button type="submit" name="submit" value='process-geo'/>
</aui:form>
