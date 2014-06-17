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

package com.rivetlogic.geo.service.impl;

import com.rivetlogic.geo.service.base.GeoLocationsServiceBaseImpl;

/**
 * The implementation of the geo locations remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.geo.service.GeoLocationsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author charles.rodriguez
 * @see com.rivetlogic.geo.service.base.GeoLocationsServiceBaseImpl
 * @see com.rivetlogic.geo.service.GeoLocationsServiceUtil
 */
public class GeoLocationsServiceImpl extends GeoLocationsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.geo.service.GeoLocationsServiceUtil} to access the geo locations remote service.
	 */
	public String getLocation(String IP){
		return geoLocationsLocalService.getLocation(IP);
	}
}