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

package com.rivetlogic.geo.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.geo.model.GeoLocations;

import java.util.List;

/**
 * The persistence utility for the geo locations service. This utility wraps {@link GeoLocationsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoLocationsPersistence
 * @see GeoLocationsPersistenceImpl
 * @generated
 */
public class GeoLocationsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GeoLocations geoLocations) {
		getPersistence().clearCache(geoLocations);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GeoLocations> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeoLocations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeoLocations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeoLocations update(GeoLocations geoLocations)
		throws SystemException {
		return getPersistence().update(geoLocations);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeoLocations update(GeoLocations geoLocations,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(geoLocations, serviceContext);
	}

	/**
	* Caches the geo locations in the entity cache if it is enabled.
	*
	* @param geoLocations the geo locations
	*/
	public static void cacheResult(
		com.rivetlogic.geo.model.GeoLocations geoLocations) {
		getPersistence().cacheResult(geoLocations);
	}

	/**
	* Caches the geo locationses in the entity cache if it is enabled.
	*
	* @param geoLocationses the geo locationses
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.geo.model.GeoLocations> geoLocationses) {
		getPersistence().cacheResult(geoLocationses);
	}

	/**
	* Creates a new geo locations with the primary key. Does not add the geo locations to the database.
	*
	* @param geonameId the primary key for the new geo locations
	* @return the new geo locations
	*/
	public static com.rivetlogic.geo.model.GeoLocations create(long geonameId) {
		return getPersistence().create(geonameId);
	}

	/**
	* Removes the geo locations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations that was removed
	* @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations remove(long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoLocationsException {
		return getPersistence().remove(geonameId);
	}

	public static com.rivetlogic.geo.model.GeoLocations updateImpl(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(geoLocations);
	}

	/**
	* Returns the geo locations with the primary key or throws a {@link com.rivetlogic.geo.NoSuchGeoLocationsException} if it could not be found.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations
	* @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations findByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoLocationsException {
		return getPersistence().findByPrimaryKey(geonameId);
	}

	/**
	* Returns the geo locations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations, or <code>null</code> if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoLocations fetchByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(geonameId);
	}

	/**
	* Returns all the geo locationses.
	*
	* @return the geo locationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoLocations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rivetlogic.geo.model.GeoLocations> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the geo locationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo locationses
	* @param end the upper bound of the range of geo locationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of geo locationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoLocations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the geo locationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of geo locationses.
	*
	* @return the number of geo locationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeoLocationsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeoLocationsPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.geo.service.ClpSerializer.getServletContextName(),
					GeoLocationsPersistence.class.getName());

			ReferenceRegistry.registerReference(GeoLocationsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeoLocationsPersistence persistence) {
	}

	private static GeoLocationsPersistence _persistence;
}