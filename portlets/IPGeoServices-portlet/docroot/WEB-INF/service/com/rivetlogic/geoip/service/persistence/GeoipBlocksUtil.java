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

import com.rivetlogic.geoip.model.GeoipBlocks;

import java.util.List;

/**
 * The persistence utility for the geoip blocks service. This utility wraps {@link GeoipBlocksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipBlocksPersistence
 * @see GeoipBlocksPersistenceImpl
 * @generated
 */
public class GeoipBlocksUtil {
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
	public static void clearCache(GeoipBlocks geoipBlocks) {
		getPersistence().clearCache(geoipBlocks);
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
	public static List<GeoipBlocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeoipBlocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeoipBlocks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeoipBlocks update(GeoipBlocks geoipBlocks)
		throws SystemException {
		return getPersistence().update(geoipBlocks);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeoipBlocks update(GeoipBlocks geoipBlocks,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(geoipBlocks, serviceContext);
	}

	/**
	* Returns all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @return the matching geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findByStartEndIp(
		long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStartEndIp(startIp, endIp);
	}

	/**
	* Returns a range of all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param start the lower bound of the range of geoip blockses
	* @param end the upper bound of the range of geoip blockses (not inclusive)
	* @return the range of matching geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findByStartEndIp(
		long startIp, long endIp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStartEndIp(startIp, endIp, start, end);
	}

	/**
	* Returns an ordered range of all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param start the lower bound of the range of geoip blockses
	* @param end the upper bound of the range of geoip blockses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findByStartEndIp(
		long startIp, long endIp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStartEndIp(startIp, endIp, start, end,
			orderByComparator);
	}

	/**
	* Returns the first geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geoip blocks
	* @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a matching geoip blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks findByStartEndIp_First(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException {
		return getPersistence()
				   .findByStartEndIp_First(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the first geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geoip blocks, or <code>null</code> if a matching geoip blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks fetchByStartEndIp_First(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStartEndIp_First(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the last geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geoip blocks
	* @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a matching geoip blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks findByStartEndIp_Last(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException {
		return getPersistence()
				   .findByStartEndIp_Last(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the last geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geoip blocks, or <code>null</code> if a matching geoip blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks fetchByStartEndIp_Last(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStartEndIp_Last(startIp, endIp, orderByComparator);
	}

	/**
	* Returns the geoip blockses before and after the current geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param geoipBlocksPK the primary key of the current geoip blocks
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geoip blocks
	* @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks[] findByStartEndIp_PrevAndNext(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK,
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException {
		return getPersistence()
				   .findByStartEndIp_PrevAndNext(geoipBlocksPK, startIp, endIp,
			orderByComparator);
	}

	/**
	* Removes all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63; from the database.
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
	* Returns the number of geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @return the number of matching geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStartEndIp(long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStartEndIp(startIp, endIp);
	}

	/**
	* Caches the geoip blocks in the entity cache if it is enabled.
	*
	* @param geoipBlocks the geoip blocks
	*/
	public static void cacheResult(
		com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks) {
		getPersistence().cacheResult(geoipBlocks);
	}

	/**
	* Caches the geoip blockses in the entity cache if it is enabled.
	*
	* @param geoipBlockses the geoip blockses
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> geoipBlockses) {
		getPersistence().cacheResult(geoipBlockses);
	}

	/**
	* Creates a new geoip blocks with the primary key. Does not add the geoip blocks to the database.
	*
	* @param geoipBlocksPK the primary key for the new geoip blocks
	* @return the new geoip blocks
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks create(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK) {
		return getPersistence().create(geoipBlocksPK);
	}

	/**
	* Removes the geoip blocks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geoipBlocksPK the primary key of the geoip blocks
	* @return the geoip blocks that was removed
	* @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks remove(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException {
		return getPersistence().remove(geoipBlocksPK);
	}

	public static com.rivetlogic.geoip.model.GeoipBlocks updateImpl(
		com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(geoipBlocks);
	}

	/**
	* Returns the geoip blocks with the primary key or throws a {@link com.rivetlogic.geoip.NoSuchGeoipBlocksException} if it could not be found.
	*
	* @param geoipBlocksPK the primary key of the geoip blocks
	* @return the geoip blocks
	* @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks findByPrimaryKey(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException {
		return getPersistence().findByPrimaryKey(geoipBlocksPK);
	}

	/**
	* Returns the geoip blocks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geoipBlocksPK the primary key of the geoip blocks
	* @return the geoip blocks, or <code>null</code> if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geoip.model.GeoipBlocks fetchByPrimaryKey(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(geoipBlocksPK);
	}

	/**
	* Returns all the geoip blockses.
	*
	* @return the geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the geoip blockses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geoip blockses
	* @param end the upper bound of the range of geoip blockses (not inclusive)
	* @return the range of geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the geoip blockses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geoip blockses
	* @param end the upper bound of the range of geoip blockses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the geoip blockses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of geoip blockses.
	*
	* @return the number of geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeoipBlocksPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeoipBlocksPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.geoip.service.ClpSerializer.getServletContextName(),
					GeoipBlocksPersistence.class.getName());

			ReferenceRegistry.registerReference(GeoipBlocksUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeoipBlocksPersistence persistence) {
	}

	private static GeoipBlocksPersistence _persistence;
}