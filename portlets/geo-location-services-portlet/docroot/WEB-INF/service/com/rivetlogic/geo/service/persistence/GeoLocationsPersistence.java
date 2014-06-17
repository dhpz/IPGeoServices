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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.geo.model.GeoLocations;

/**
 * The persistence interface for the geo locations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoLocationsPersistenceImpl
 * @see GeoLocationsUtil
 * @generated
 */
public interface GeoLocationsPersistence extends BasePersistence<GeoLocations> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeoLocationsUtil} to access the geo locations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the geo locations in the entity cache if it is enabled.
	*
	* @param geoLocations the geo locations
	*/
	public void cacheResult(com.rivetlogic.geo.model.GeoLocations geoLocations);

	/**
	* Caches the geo locationses in the entity cache if it is enabled.
	*
	* @param geoLocationses the geo locationses
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.geo.model.GeoLocations> geoLocationses);

	/**
	* Creates a new geo locations with the primary key. Does not add the geo locations to the database.
	*
	* @param geonameId the primary key for the new geo locations
	* @return the new geo locations
	*/
	public com.rivetlogic.geo.model.GeoLocations create(long geonameId);

	/**
	* Removes the geo locations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations that was removed
	* @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geo.model.GeoLocations remove(long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoLocationsException;

	public com.rivetlogic.geo.model.GeoLocations updateImpl(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the geo locations with the primary key or throws a {@link com.rivetlogic.geo.NoSuchGeoLocationsException} if it could not be found.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations
	* @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geo.model.GeoLocations findByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoLocationsException;

	/**
	* Returns the geo locations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geonameId the primary key of the geo locations
	* @return the geo locations, or <code>null</code> if a geo locations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geo.model.GeoLocations fetchByPrimaryKey(
		long geonameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the geo locationses.
	*
	* @return the geo locationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.geo.model.GeoLocations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geo.model.GeoLocations> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geo.model.GeoLocations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geo locationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geo locationses.
	*
	* @return the number of geo locationses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}