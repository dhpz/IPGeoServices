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
 * Provides a wrapper for {@link GeoLocationsLocalService}.
 *
 * @author charles.rodriguez
 * @see GeoLocationsLocalService
 * @generated
 */
public class GeoLocationsLocalServiceWrapper implements GeoLocationsLocalService,
	ServiceWrapper<GeoLocationsLocalService> {
	public GeoLocationsLocalServiceWrapper(
		GeoLocationsLocalService geoLocationsLocalService) {
		_geoLocationsLocalService = geoLocationsLocalService;
	}

	/**
	* Adds the geo locations to the database. Also notifies the appropriate model listeners.
	*
	* @param geoLocations the geo locations
	* @return the geo locations that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoLocations addGeoLocations(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.addGeoLocations(geoLocations);
	}

	/**
	* Creates a new geo locations with the primary key. Does not add the geo locations to the database.
	*
	* @param geonameId the primary key for the new geo locations
	* @return the new geo locations
	*/
	@Override
	public com.rivetlogic.geo.model.GeoLocations createGeoLocations(
		long geonameId) {
		return _geoLocationsLocalService.createGeoLocations(geonameId);
	}

	/**
	* Deletes the geo locations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations that was removed
	* @throws PortalException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoLocations deleteGeoLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.deleteGeoLocations(geonameId);
	}

	/**
	* Deletes the geo locations from the database. Also notifies the appropriate model listeners.
	*
	* @param geoLocations the geo locations
	* @return the geo locations that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoLocations deleteGeoLocations(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.deleteGeoLocations(geoLocations);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geoLocationsLocalService.dynamicQuery();
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
		return _geoLocationsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geoLocationsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geoLocationsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _geoLocationsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _geoLocationsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.geo.model.GeoLocations fetchGeoLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.fetchGeoLocations(geonameId);
	}

	/**
	* Returns the geo locations with the primary key.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations
	* @throws PortalException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoLocations getGeoLocations(long geonameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.getGeoLocations(geonameId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the geo locationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo locationses
	* @param end the upper bound of the range of geo locationses (not inclusive)
	* @return the range of geo locationses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rivetlogic.geo.model.GeoLocations> getGeoLocationses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.getGeoLocationses(start, end);
	}

	/**
	* Returns the number of geo locationses.
	*
	* @return the number of geo locationses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeoLocationsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.getGeoLocationsesCount();
	}

	/**
	* Updates the geo locations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geoLocations the geo locations
	* @return the geo locations that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoLocations updateGeoLocations(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoLocationsLocalService.updateGeoLocations(geoLocations);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geoLocationsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geoLocationsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geoLocationsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rivetlogic.geo.model.GeoLocations addGeoipLocations(
		com.rivetlogic.geo.model.GeoLocations newLocations) {
		return _geoLocationsLocalService.addGeoipLocations(newLocations);
	}

	@Override
	public void truncateTable() {
		_geoLocationsLocalService.truncateTable();
	}

	@Override
	public java.lang.String getCountryISO(long geonameId) {
		return _geoLocationsLocalService.getCountryISO(geonameId);
	}

	@Override
	public java.lang.String getLocation(java.lang.String IP) {
		return _geoLocationsLocalService.getLocation(IP);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeoLocationsLocalService getWrappedGeoLocationsLocalService() {
		return _geoLocationsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeoLocationsLocalService(
		GeoLocationsLocalService geoLocationsLocalService) {
		_geoLocationsLocalService = geoLocationsLocalService;
	}

	@Override
	public GeoLocationsLocalService getWrappedService() {
		return _geoLocationsLocalService;
	}

	@Override
	public void setWrappedService(
		GeoLocationsLocalService geoLocationsLocalService) {
		_geoLocationsLocalService = geoLocationsLocalService;
	}

	private GeoLocationsLocalService _geoLocationsLocalService;
}