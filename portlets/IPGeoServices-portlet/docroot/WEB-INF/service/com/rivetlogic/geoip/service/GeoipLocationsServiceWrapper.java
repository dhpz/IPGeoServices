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

package com.rivetlogic.geoip.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeoipLocationsService}.
 *
 * @author charles.rodriguez
 * @see GeoipLocationsService
 * @generated
 */
public class GeoipLocationsServiceWrapper implements GeoipLocationsService,
	ServiceWrapper<GeoipLocationsService> {
	public GeoipLocationsServiceWrapper(
		GeoipLocationsService geoipLocationsService) {
		_geoipLocationsService = geoipLocationsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geoipLocationsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geoipLocationsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geoipLocationsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getLocation(java.lang.String IP) {
		return _geoipLocationsService.getLocation(IP);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeoipLocationsService getWrappedGeoipLocationsService() {
		return _geoipLocationsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeoipLocationsService(
		GeoipLocationsService geoipLocationsService) {
		_geoipLocationsService = geoipLocationsService;
	}

	@Override
	public GeoipLocationsService getWrappedService() {
		return _geoipLocationsService;
	}

	@Override
	public void setWrappedService(GeoipLocationsService geoipLocationsService) {
		_geoipLocationsService = geoipLocationsService;
	}

	private GeoipLocationsService _geoipLocationsService;
}