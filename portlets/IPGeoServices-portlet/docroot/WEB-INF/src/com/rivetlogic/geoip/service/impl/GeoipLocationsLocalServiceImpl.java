/**
 * Copyright (C) 2014 Rivet Logic Corporation. All rights reserved.
 */

/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.geoip.service.impl;

import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.geoip.model.GeoipLocations;
import com.rivetlogic.geoip.portlet.IPGeoServicesPortletConstants;
import com.rivetlogic.geoip.service.base.GeoipLocationsLocalServiceBaseImpl;
import com.rivetlogic.geoip.util.GeoipUtility;

/**
 * The implementation of the geoip locations local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.geoip.service.GeoipLocationsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author charles.rodriguez
 * @see com.rivetlogic.geoip.service.base.GeoipLocationsLocalServiceBaseImpl
 * @see com.rivetlogic.geoip.service.GeoipLocationsLocalServiceUtil
 */
public class GeoipLocationsLocalServiceImpl
        extends GeoipLocationsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.geoip.service.GeoipLocationsLocalServiceUtil} to access the geoip locations local service.
	 */

	private static final Log LOG =
		    LogFactoryUtil.getLog(GeoipLocationsLocalServiceImpl.class);

	@Override
    public GeoipLocations addGeoipLocations(GeoipLocations newLocations) {
		GeoipLocations locations =
				geoipLocationsPersistence.create(newLocations.getGeonameId());
        locations.setCountryIsoCode(newLocations.getCountryIsoCode());

        try {
        	geoipLocationsPersistence.update(locations);
		} catch (SystemException e) {
			LOG.error(e);
		}

        return locations;
    }

	public void truncateTable(){
		Session session = geoipLocationsPersistence.openSession();
		Query query =
				session.createSQLQuery(IPGeoServicesPortletConstants.SQL_TRUNCATE
		                + IPGeoServicesPortletConstants.LOCATIONS_TABLE);
		query.executeUpdate();
	}

	public String getCountryISO(long geonameId){
		String countryISO = StringPool.BLANK;
		try {
			GeoipLocations location =
					geoipLocationsPersistence.fetchByPrimaryKey(geonameId);
			if(location != null){
				countryISO = location.getCountryIsoCode();
			}
			
		} catch (SystemException e) {
			LOG.error(e);
		}

		return countryISO;
	}

	public String getLocation(String IP){
		long ip = GeoipUtility.ipToLong(IP);
        long geonameId = geoipBlocksLocalService.getGeonameId(ip, ip);

        return getCountryISO(geonameId);
    }
}