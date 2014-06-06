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
 * Provides a wrapper for {@link GeoipLocationsLocalService}.
 *
 * @author charles.rodriguez
 * @see GeoipLocationsLocalService
 * @generated
 */
public class GeoipLocationsLocalServiceWrapper
	implements GeoipLocationsLocalService,
		ServiceWrapper<GeoipLocationsLocalService> {
	public GeoipLocationsLocalServiceWrapper(
		GeoipLocationsLocalService geoipLocationsLocalService) {
		_geoipLocationsLocalService = geoipLocationsLocalService;
	}

	/**
	* Adds the geoip locations to the database. Also notifies the appropriate model listeners.
	*
	* @param geoipLocations the geoip locations
	* @return the geoip locations that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipLocations addGeoipLocations(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.addGeoipLocations(geoipLocations);
	}

	/**
	* Creates a new geoip locations with the primary key. Does not add the geoip locations to the database.
	*
	* @param geonameId the primary key for the new geoip locations
	* @return the new geoip locations
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipLocations createGeoipLocations(
		long geonameId) {
		return _geoipLocationsLocalService.createGeoipLocations(geonameId);
	}

	/**
	* Deletes the geoip locations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations that was removed
	* @throws PortalException if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipLocations deleteGeoipLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.deleteGeoipLocations(geonameId);
	}

	/**
	* Deletes the geoip locations from the database. Also notifies the appropriate model listeners.
	*
	* @param geoipLocations the geoip locations
	* @return the geoip locations that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipLocations deleteGeoipLocations(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.deleteGeoipLocations(geoipLocations);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geoipLocationsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.geoip.model.GeoipLocations fetchGeoipLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.fetchGeoipLocations(geonameId);
	}

	/**
	* Returns the geoip locations with the primary key.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations
	* @throws PortalException if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipLocations getGeoipLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.getGeoipLocations(geonameId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the geoip locationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geoip locationses
	* @param end the upper bound of the range of geoip locationses (not inclusive)
	* @return the range of geoip locationses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rivetlogic.geoip.model.GeoipLocations> getGeoipLocationses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.getGeoipLocationses(start, end);
	}

	/**
	* Returns the number of geoip locationses.
	*
	* @return the number of geoip locationses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeoipLocationsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.getGeoipLocationsesCount();
	}

	/**
	* Updates the geoip locations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geoipLocations the geoip locations
	* @return the geoip locations that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipLocations updateGeoipLocations(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipLocationsLocalService.updateGeoipLocations(geoipLocations);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geoipLocationsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geoipLocationsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geoipLocationsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void truncateTable() {
		_geoipLocationsLocalService.truncateTable();
	}

	@Override
	public java.lang.String getCountryISO(long geonameId) {
		return _geoipLocationsLocalService.getCountryISO(geonameId);
	}

	@Override
	public java.lang.String getLocation(java.lang.String IP) {
		return _geoipLocationsLocalService.getLocation(IP);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeoipLocationsLocalService getWrappedGeoipLocationsLocalService() {
		return _geoipLocationsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeoipLocationsLocalService(
		GeoipLocationsLocalService geoipLocationsLocalService) {
		_geoipLocationsLocalService = geoipLocationsLocalService;
	}

	@Override
	public GeoipLocationsLocalService getWrappedService() {
		return _geoipLocationsLocalService;
	}

	@Override
	public void setWrappedService(
		GeoipLocationsLocalService geoipLocationsLocalService) {
		_geoipLocationsLocalService = geoipLocationsLocalService;
	}

	private GeoipLocationsLocalService _geoipLocationsLocalService;
}