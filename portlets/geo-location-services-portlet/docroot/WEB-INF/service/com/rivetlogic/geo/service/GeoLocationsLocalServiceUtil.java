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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GeoLocations. This utility wraps
 * {@link com.rivetlogic.geo.service.impl.GeoLocationsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author charles.rodriguez
 * @see GeoLocationsLocalService
 * @see com.rivetlogic.geo.service.base.GeoLocationsLocalServiceBaseImpl
 * @see com.rivetlogic.geo.service.impl.GeoLocationsLocalServiceImpl
 * @generated
 */
public class GeoLocationsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.geo.service.impl.GeoLocationsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the geo locations to the database. Also notifies the appropriate model listeners.
	*
	* @param geoLocations the geo locations
	* @return the geo locations that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations addGeoLocations(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGeoLocations(geoLocations);
	}

	/**
	* Creates a new geo locations with the primary key. Does not add the geo locations to the database.
	*
	* @param geonameId the primary key for the new geo locations
	* @return the new geo locations
	*/
	public static com.rivetlogic.geo.model.GeoLocations createGeoLocations(
		long geonameId) {
		return getService().createGeoLocations(geonameId);
	}

	/**
	* Deletes the geo locations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations that was removed
	* @throws PortalException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations deleteGeoLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGeoLocations(geonameId);
	}

	/**
	* Deletes the geo locations from the database. Also notifies the appropriate model listeners.
	*
	* @param geoLocations the geo locations
	* @return the geo locations that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations deleteGeoLocations(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGeoLocations(geoLocations);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rivetlogic.geo.model.GeoLocations fetchGeoLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGeoLocations(geonameId);
	}

	/**
	* Returns the geo locations with the primary key.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations
	* @throws PortalException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations getGeoLocations(
		long geonameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeoLocations(geonameId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rivetlogic.geo.model.GeoLocations> getGeoLocationses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeoLocationses(start, end);
	}

	/**
	* Returns the number of geo locationses.
	*
	* @return the number of geo locationses
	* @throws SystemException if a system exception occurred
	*/
	public static int getGeoLocationsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeoLocationsesCount();
	}

	/**
	* Updates the geo locations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geoLocations the geo locations
	* @return the geo locations that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations updateGeoLocations(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGeoLocations(geoLocations);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.rivetlogic.geo.model.GeoLocations addGeoipLocations(
		com.rivetlogic.geo.model.GeoLocations newLocations) {
		return getService().addGeoipLocations(newLocations);
	}

	public static void truncateTable() {
		getService().truncateTable();
	}

	public static java.lang.String getCountryISO(long geonameId) {
		return getService().getCountryISO(geonameId);
	}

	public static java.lang.String getLocation(java.lang.String IP) {
		return getService().getLocation(IP);
	}

	public static void clearService() {
		_service = null;
	}

	public static GeoLocationsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GeoLocationsLocalService.class.getName());

			if (invokableLocalService instanceof GeoLocationsLocalService) {
				_service = (GeoLocationsLocalService)invokableLocalService;
			}
			else {
				_service = new GeoLocationsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GeoLocationsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GeoLocationsLocalService service) {
	}

	private static GeoLocationsLocalService _service;
}