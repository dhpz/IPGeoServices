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

package com.rivetlogic.geoip.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.geoip.model.GeoipLocations;

import java.util.List;

/**
 * The persistence utility for the geoip locations service. This utility wraps {@link GeoipLocationsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipLocationsPersistence
 * @see GeoipLocationsPersistenceImpl
 * @generated
 */
public class GeoipLocationsUtil {
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
	public static void clearCache(GeoipLocations geoipLocations) {
		getPersistence().clearCache(geoipLocations);
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
	public static List<GeoipLocations> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeoipLocations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeoipLocations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeoipLocations update(GeoipLocations geoipLocations)
		throws SystemException {
		return getPersistence().update(geoipLocations);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeoipLocations update(GeoipLocations geoipLocations,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(geoipLocations, serviceContext);
	}

	/**
	* Caches the geoip locations in the entity cache if it is enabled.
	*
	* @param geoipLocations the geoip locations
	*/
	public static void cacheResult(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations) {
		getPersistence().cacheResult(geoipLocations);
	}

	/**
	* Caches the geoip locationses in the entity cache if it is enabled.
	*
	* @param geoipLocationses the geoip locationses
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.geoip.model.GeoipLocations> geoipLocationses) {
		getPersistence().cacheResult(geoipLocationses);
	}

	/**
	* Creates a new geoip locations with the primary key. Does not add the geoip locations to the database.
	*
	* @param geonameId the primary key for the new geoip locations
	* @return the new geoip locations
	*/
	public static com.rivetlogic.geoip.model.GeoipLocations create(
		long geonameId) {
		return getPersistence().create(geonameId);
	}

	/**
	* Removes the geoip locations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations that was removed
	* @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipLocations remove(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipLocationsException {
		return getPersistence().remove(geonameId);
	}

	public static com.rivetlogic.geoip.model.GeoipLocations updateImpl(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(geoipLocations);
	}

	/**
	* Returns the geoip locations with the primary key or throws a {@link com.rivetlogic.geoip.NoSuchGeoipLocationsException} if it could not be found.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations
	* @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipLocations findByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipLocationsException {
		return getPersistence().findByPrimaryKey(geonameId);
	}

	/**
	* Returns the geoip locations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations, or <code>null</code> if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipLocations fetchByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(geonameId);
	}

	/**
	* Returns all the geoip locationses.
	*
	* @return the geoip locationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipLocations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rivetlogic.geoip.model.GeoipLocations> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the geoip locationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geoip locationses
	* @param end the upper bound of the range of geoip locationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of geoip locationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipLocations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the geoip locationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of geoip locationses.
	*
	* @return the number of geoip locationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeoipLocationsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeoipLocationsPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.geoip.service.ClpSerializer.getServletContextName(),
					GeoipLocationsPersistence.class.getName());

			ReferenceRegistry.registerReference(GeoipLocationsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeoipLocationsPersistence persistence) {
	}

	private static GeoipLocationsPersistence _persistence;
}