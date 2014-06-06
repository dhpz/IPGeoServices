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

import com.rivetlogic.geoip.model.GeoipBlocks;

/**
 * The persistence interface for the geoip blocks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipBlocksPersistenceImpl
 * @see GeoipBlocksUtil
 * @generated
 */
public interface GeoipBlocksPersistence extends BasePersistence<GeoipBlocks> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeoipBlocksUtil} to access the geoip blocks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @return the matching geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findByStartEndIp(
		long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findByStartEndIp(
		long startIp, long endIp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findByStartEndIp(
		long startIp, long endIp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.geoip.model.GeoipBlocks findByStartEndIp_First(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException;

	/**
	* Returns the first geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geoip blocks, or <code>null</code> if a matching geoip blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipBlocks fetchByStartEndIp_First(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.geoip.model.GeoipBlocks findByStartEndIp_Last(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException;

	/**
	* Returns the last geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geoip blocks, or <code>null</code> if a matching geoip blocks could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipBlocks fetchByStartEndIp_Last(
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.geoip.model.GeoipBlocks[] findByStartEndIp_PrevAndNext(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK,
		long startIp, long endIp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException;

	/**
	* Removes all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63; from the database.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStartEndIp(long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	*
	* @param startIp the start ip
	* @param endIp the end ip
	* @return the number of matching geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStartEndIp(long startIp, long endIp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the geoip blocks in the entity cache if it is enabled.
	*
	* @param geoipBlocks the geoip blocks
	*/
	public void cacheResult(com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks);

	/**
	* Caches the geoip blockses in the entity cache if it is enabled.
	*
	* @param geoipBlockses the geoip blockses
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> geoipBlockses);

	/**
	* Creates a new geoip blocks with the primary key. Does not add the geoip blocks to the database.
	*
	* @param geoipBlocksPK the primary key for the new geoip blocks
	* @return the new geoip blocks
	*/
	public com.rivetlogic.geoip.model.GeoipBlocks create(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK);

	/**
	* Removes the geoip blocks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geoipBlocksPK the primary key of the geoip blocks
	* @return the geoip blocks that was removed
	* @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipBlocks remove(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException;

	public com.rivetlogic.geoip.model.GeoipBlocks updateImpl(
		com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the geoip blocks with the primary key or throws a {@link com.rivetlogic.geoip.NoSuchGeoipBlocksException} if it could not be found.
	*
	* @param geoipBlocksPK the primary key of the geoip blocks
	* @return the geoip blocks
	* @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipBlocks findByPrimaryKey(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.geoip.NoSuchGeoipBlocksException;

	/**
	* Returns the geoip blocks with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geoipBlocksPK the primary key of the geoip blocks
	* @return the geoip blocks, or <code>null</code> if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.geoip.model.GeoipBlocks fetchByPrimaryKey(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the geoip blockses.
	*
	* @return the geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geoip blockses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geoip blockses.
	*
	* @return the number of geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}