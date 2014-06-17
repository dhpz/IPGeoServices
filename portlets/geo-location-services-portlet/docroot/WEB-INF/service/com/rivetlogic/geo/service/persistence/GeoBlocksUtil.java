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

import com.rivetlogic.geo.model.GeoBlocks;

import java.util.List;

/**
 * The persistence utility for the geo blocks service. This utility wraps {@link GeoBlocksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoBlocksPersistence
 * @see GeoBlocksPersistenceImpl
 * @generated
 */
public class GeoBlocksUtil {
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
	public static void clearCache(GeoBlocks geoBlocks) {
		getPersistence().clearCache(geoBlocks);
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
	public static List<GeoBlocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeoBlocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeoBlocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeoBlocks update(GeoBlocks geoBlocks)
		throws SystemException {
		return getPersistence().update(geoBlocks);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeoBlocks update(GeoBlocks geoBlocks,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(geoBlocks, serviceContext);
	}

	/**
	* Returns all the geo blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @return the matching geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoBlocks> findByStartEndIp(
		long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStartEndIp(startIp, endIp);
	}

	/**
	* Returns a range of all the geo blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param start the lower bound of the range of geo blockses
	* @param end the upper bound of the range of geo blockses (not inclusive)
	* @return the range of matching geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoBlocks> findByStartEndIp(
		long startIp, long endIp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStartEndIp(startIp, endIp, start, end);
	}

	/**
	* Returns an ordered range of all the geo blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param start the lower bound of the range of geo blockses
	* @param end the upper bound of the range of geo blockses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoBlocks> findByStartEndIp(
		long startIp, long endIp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStartEndIp(startIp, endIp, start, end,
			orderByComparator);
	}

	/**
	* Returns the first geo blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geo blocks
	* @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a matching geo blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks findByStartEndIp_First(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoBlocksException {
		return getPersistence()
				   .findByStartEndIp_First(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the first geo blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geo blocks, or <code>null</code> if a matching geo blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks fetchByStartEndIp_First(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStartEndIp_First(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the last geo blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geo blocks
	* @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a matching geo blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks findByStartEndIp_Last(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoBlocksException {
		return getPersistence()
				   .findByStartEndIp_Last(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the last geo blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geo blocks, or <code>null</code> if a matching geo blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks fetchByStartEndIp_Last(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStartEndIp_Last(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the geo blockses before and after the current geo blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param geoBlocksPK the primary key of the current geo blocks
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geo blocks
	* @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a geo blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks[] findByStartEndIp_PrevAndNext(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK,
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoBlocksException {
		return getPersistence()
				   .findByStartEndIp_PrevAndNext(geoBlocksPK, startIp, endIp,
			orderByComparator);
	}

	/**
	* Removes all the geo blockses where startIp &lt; &#63; and endIp &gt; &#63; from the database.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStartEndIp(long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStartEndIp(startIp, endIp);
	}

	/**
	* Returns the number of geo blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @return the number of matching geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStartEndIp(long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStartEndIp(startIp, endIp);
	}

	/**
	* Caches the geo blocks in the entity cache if it is enabled.
	*
	* @param geoBlocks the geo blocks
	*/
	public static void cacheResult(com.rivetlogic.geo.model.GeoBlocks geoBlocks) {
		getPersistence().cacheResult(geoBlocks);
	}

	/**
	* Caches the geo blockses in the entity cache if it is enabled.
	*
	* @param geoBlockses the geo blockses
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.geo.model.GeoBlocks> geoBlockses) {
		getPersistence().cacheResult(geoBlockses);
	}

	/**
	* Creates a new geo blocks with the primary key. Does not add the geo blocks to the database.
	*
	* @param geoBlocksPK the primary key for the new geo blocks
	* @return the new geo blocks
	*/
	public static com.rivetlogic.geo.model.GeoBlocks create(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK) {
		return getPersistence().create(geoBlocksPK);
	}

	/**
	* Removes the geo blocks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geoBlocksPK the primary key of the geo blocks
	* @return the geo blocks that was removed
	* @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a geo blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks remove(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoBlocksException {
		return getPersistence().remove(geoBlocksPK);
	}

	public static com.rivetlogic.geo.model.GeoBlocks updateImpl(
		com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(geoBlocks);
	}

	/**
	* Returns the geo blocks with the primary key or throws a {@link com.rivetlogic.geo.NoSuchGeoBlocksException} if it could not be found.
	*
	* @param geoBlocksPK the primary key of the geo blocks
	* @return the geo blocks
	* @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a geo blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks findByPrimaryKey(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geo.NoSuchGeoBlocksException {
		return getPersistence().findByPrimaryKey(geoBlocksPK);
	}

	/**
	* Returns the geo blocks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geoBlocksPK the primary key of the geo blocks
	* @return the geo blocks, or <code>null</code> if a geo blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks fetchByPrimaryKey(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(geoBlocksPK);
	}

	/**
	* Returns all the geo blockses.
	*
	* @return the geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoBlocks> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the geo blockses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo blockses
	* @param end the upper bound of the range of geo blockses (not inclusive)
	* @return the range of geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoBlocks> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the geo blockses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geo blockses
	* @param end the upper bound of the range of geo blockses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geo.model.GeoBlocks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the geo blockses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of geo blockses.
	*
	* @return the number of geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeoBlocksPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeoBlocksPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.geo.service.ClpSerializer.getServletContextName(),
					GeoBlocksPersistence.class.getName());

			ReferenceRegistry.registerReference(GeoBlocksUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeoBlocksPersistence persistence) {
	}

	private static GeoBlocksPersistence _persistence;
}