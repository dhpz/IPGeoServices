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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.geoip.model.GeoipLocations;

/**
 * The persistence interface for the geoip locations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipLocationsPersistenceImpl
 * @see GeoipLocationsUtil
 * @generated
 */
public interface GeoipLocationsPersistence extends BasePersistence<GeoipLocations> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeoipLocationsUtil} to access the geoip locations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the geoip locations in the entity cache if it is enabled.
	*
	* @param geoipLocations the geoip locations
	*/
	public void cacheResult(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations);

	/**
	* Caches the geoip locationses in the entity cache if it is enabled.
	*
	* @param geoipLocationses the geoip locationses
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.geoip.model.GeoipLocations> geoipLocationses);

	/**
	* Creates a new geoip locations with the primary key. Does not add the geoip locations to the database.
	*
	* @param geonameId the primary key for the new geoip locations
	* @return the new geoip locations
	*/
	public com.rivetlogic.geoip.model.GeoipLocations create(long geonameId);

	/**
	* Removes the geoip locations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations that was removed
	* @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipLocations remove(long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipLocationsException;

	public com.rivetlogic.geoip.model.GeoipLocations updateImpl(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the geoip locations with the primary key or throws a {@link com.rivetlogic.geoip.NoSuchGeoipLocationsException} if it could not be found.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations
	* @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipLocations findByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipLocationsException;

	/**
	* Returns the geoip locations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geonameId the primary key of the geoip locations
	* @return the geoip locations, or <code>null</code> if a geoip locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipLocations fetchByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the geoip locationses.
	*
	* @return the geoip locationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.geoip.model.GeoipLocations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geoip.model.GeoipLocations> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geoip.model.GeoipLocations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geoip locationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geoip locationses.
	*
	* @return the number of geoip locationses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}