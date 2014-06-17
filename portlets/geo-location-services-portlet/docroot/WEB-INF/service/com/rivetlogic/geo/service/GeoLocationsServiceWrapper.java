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

package com.rivetlogic.geo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeoLocationsService}.
 *
 * @author charles.rodriguez
 * @see GeoLocationsService
 * @generated
 */
public class GeoLocationsServiceWrapper implements GeoLocationsService,
	ServiceWrapper<GeoLocationsService> {
	public GeoLocationsServiceWrapper(GeoLocationsService geoLocationsService) {
		_geoLocationsService = geoLocationsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geoLocationsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geoLocationsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geoLocationsService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String getLocation(java.lang.String IP) {
		return _geoLocationsService.getLocation(IP);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeoLocationsService getWrappedGeoLocationsService() {
		return _geoLocationsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeoLocationsService(
		GeoLocationsService geoLocationsService) {
		_geoLocationsService = geoLocationsService;
	}

	@Override
	public GeoLocationsService getWrappedService() {
		return _geoLocationsService;
	}

	@Override
	public void setWrappedService(GeoLocationsService geoLocationsService) {
		_geoLocationsService = geoLocationsService;
	}

	private GeoLocationsService _geoLocationsService;
}