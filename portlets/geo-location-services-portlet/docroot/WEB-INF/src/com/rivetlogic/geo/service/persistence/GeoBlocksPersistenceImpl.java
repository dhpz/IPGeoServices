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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.geo.NoSuchGeoBlocksException;
import com.rivetlogic.geo.model.GeoBlocks;
import com.rivetlogic.geo.model.impl.GeoBlocksImpl;
import com.rivetlogic.geo.model.impl.GeoBlocksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the geo blocks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoBlocksPersistence
 * @see GeoBlocksUtil
 * @generated
 */
public class GeoBlocksPersistenceImpl extends BasePersistenceImpl<GeoBlocks>
	implements GeoBlocksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeoBlocksUtil} to access the geo blocks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeoBlocksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksModelImpl.FINDER_CACHE_ENABLED, GeoBlocksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksModelImpl.FINDER_CACHE_ENABLED, GeoBlocksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTENDIP =
		new FinderPath(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksModelImpl.FINDER_CACHE_ENABLED, GeoBlocksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStartEndIp",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STARTENDIP =
		new FinderPath(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByStartEndIp",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the geo blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	 *
	 * @param startIp the start ip
	 * @param endIp the end ip
	 * @return the matching geo blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeoBlocks> findByStartEndIp(long startIp, long endIp)
		throws SystemException {
		return findByStartEndIp(startIp, endIp, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<GeoBlocks> findByStartEndIp(long startIp, long endIp,
		int start, int end) throws SystemException {
		return findByStartEndIp(startIp, endIp, start, end, null);
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
	@Override
	public List<GeoBlocks> findByStartEndIp(long startIp, long endIp,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTENDIP;
		finderArgs = new Object[] { startIp, endIp, start, end, orderByComparator };

		List<GeoBlocks> list = (List<GeoBlocks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GeoBlocks geoBlocks : list) {
				if ((startIp <= geoBlocks.getStartIp()) ||
						(endIp >= geoBlocks.getEndIp())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GEOBLOCKS_WHERE);

			query.append(_FINDER_COLUMN_STARTENDIP_STARTIP_2);

			query.append(_FINDER_COLUMN_STARTENDIP_ENDIP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeoBlocksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(startIp);

				qPos.add(endIp);

				if (!pagination) {
					list = (List<GeoBlocks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeoBlocks>(list);
				}
				else {
					list = (List<GeoBlocks>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public GeoBlocks findByStartEndIp_First(long startIp, long endIp,
		OrderByComparator orderByComparator)
		throws NoSuchGeoBlocksException, SystemException {
		GeoBlocks geoBlocks = fetchByStartEndIp_First(startIp, endIp,
				orderByComparator);

		if (geoBlocks != null) {
			return geoBlocks;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startIp=");
		msg.append(startIp);

		msg.append(", endIp=");
		msg.append(endIp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeoBlocksException(msg.toString());
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
	@Override
	public GeoBlocks fetchByStartEndIp_First(long startIp, long endIp,
		OrderByComparator orderByComparator) throws SystemException {
		List<GeoBlocks> list = findByStartEndIp(startIp, endIp, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GeoBlocks findByStartEndIp_Last(long startIp, long endIp,
		OrderByComparator orderByComparator)
		throws NoSuchGeoBlocksException, SystemException {
		GeoBlocks geoBlocks = fetchByStartEndIp_Last(startIp, endIp,
				orderByComparator);

		if (geoBlocks != null) {
			return geoBlocks;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startIp=");
		msg.append(startIp);

		msg.append(", endIp=");
		msg.append(endIp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeoBlocksException(msg.toString());
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
	@Override
	public GeoBlocks fetchByStartEndIp_Last(long startIp, long endIp,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStartEndIp(startIp, endIp);

		if (count == 0) {
			return null;
		}

		List<GeoBlocks> list = findByStartEndIp(startIp, endIp, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GeoBlocks[] findByStartEndIp_PrevAndNext(GeoBlocksPK geoBlocksPK,
		long startIp, long endIp, OrderByComparator orderByComparator)
		throws NoSuchGeoBlocksException, SystemException {
		GeoBlocks geoBlocks = findByPrimaryKey(geoBlocksPK);

		Session session = null;

		try {
			session = openSession();

			GeoBlocks[] array = new GeoBlocksImpl[3];

			array[0] = getByStartEndIp_PrevAndNext(session, geoBlocks, startIp,
					endIp, orderByComparator, true);

			array[1] = geoBlocks;

			array[2] = getByStartEndIp_PrevAndNext(session, geoBlocks, startIp,
					endIp, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GeoBlocks getByStartEndIp_PrevAndNext(Session session,
		GeoBlocks geoBlocks, long startIp, long endIp,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOBLOCKS_WHERE);

		query.append(_FINDER_COLUMN_STARTENDIP_STARTIP_2);

		query.append(_FINDER_COLUMN_STARTENDIP_ENDIP_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeoBlocksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(startIp);

		qPos.add(endIp);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geoBlocks);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GeoBlocks> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geo blockses where startIp &lt; &#63; and endIp &gt; &#63; from the database.
	 *
	 * @param startIp the start ip
	 * @param endIp the end ip
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStartEndIp(long startIp, long endIp)
		throws SystemException {
		for (GeoBlocks geoBlocks : findByStartEndIp(startIp, endIp,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(geoBlocks);
		}
	}

	/**
	 * Returns the number of geo blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	 *
	 * @param startIp the start ip
	 * @param endIp the end ip
	 * @return the number of matching geo blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStartEndIp(long startIp, long endIp)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_STARTENDIP;

		Object[] finderArgs = new Object[] { startIp, endIp };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOBLOCKS_WHERE);

			query.append(_FINDER_COLUMN_STARTENDIP_STARTIP_2);

			query.append(_FINDER_COLUMN_STARTENDIP_ENDIP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(startIp);

				qPos.add(endIp);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STARTENDIP_STARTIP_2 = "geoBlocks.id.startIp < ? AND ";
	private static final String _FINDER_COLUMN_STARTENDIP_ENDIP_2 = "geoBlocks.endIp > ?";

	public GeoBlocksPersistenceImpl() {
		setModelClass(GeoBlocks.class);
	}

	/**
	 * Caches the geo blocks in the entity cache if it is enabled.
	 *
	 * @param geoBlocks the geo blocks
	 */
	@Override
	public void cacheResult(GeoBlocks geoBlocks) {
		EntityCacheUtil.putResult(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksImpl.class, geoBlocks.getPrimaryKey(), geoBlocks);

		geoBlocks.resetOriginalValues();
	}

	/**
	 * Caches the geo blockses in the entity cache if it is enabled.
	 *
	 * @param geoBlockses the geo blockses
	 */
	@Override
	public void cacheResult(List<GeoBlocks> geoBlockses) {
		for (GeoBlocks geoBlocks : geoBlockses) {
			if (EntityCacheUtil.getResult(
						GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
						GeoBlocksImpl.class, geoBlocks.getPrimaryKey()) == null) {
				cacheResult(geoBlocks);
			}
			else {
				geoBlocks.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geo blockses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeoBlocksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeoBlocksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geo blocks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeoBlocks geoBlocks) {
		EntityCacheUtil.removeResult(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksImpl.class, geoBlocks.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeoBlocks> geoBlockses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeoBlocks geoBlocks : geoBlockses) {
			EntityCacheUtil.removeResult(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
				GeoBlocksImpl.class, geoBlocks.getPrimaryKey());
		}
	}

	/**
	 * Creates a new geo blocks with the primary key. Does not add the geo blocks to the database.
	 *
	 * @param geoBlocksPK the primary key for the new geo blocks
	 * @return the new geo blocks
	 */
	@Override
	public GeoBlocks create(GeoBlocksPK geoBlocksPK) {
		GeoBlocks geoBlocks = new GeoBlocksImpl();

		geoBlocks.setNew(true);
		geoBlocks.setPrimaryKey(geoBlocksPK);

		return geoBlocks;
	}

	/**
	 * Removes the geo blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoBlocksPK the primary key of the geo blocks
	 * @return the geo blocks that was removed
	 * @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoBlocks remove(GeoBlocksPK geoBlocksPK)
		throws NoSuchGeoBlocksException, SystemException {
		return remove((Serializable)geoBlocksPK);
	}

	/**
	 * Removes the geo blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geo blocks
	 * @return the geo blocks that was removed
	 * @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoBlocks remove(Serializable primaryKey)
		throws NoSuchGeoBlocksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeoBlocks geoBlocks = (GeoBlocks)session.get(GeoBlocksImpl.class,
					primaryKey);

			if (geoBlocks == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeoBlocksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geoBlocks);
		}
		catch (NoSuchGeoBlocksException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GeoBlocks removeImpl(GeoBlocks geoBlocks)
		throws SystemException {
		geoBlocks = toUnwrappedModel(geoBlocks);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geoBlocks)) {
				geoBlocks = (GeoBlocks)session.get(GeoBlocksImpl.class,
						geoBlocks.getPrimaryKeyObj());
			}

			if (geoBlocks != null) {
				session.delete(geoBlocks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geoBlocks != null) {
			clearCache(geoBlocks);
		}

		return geoBlocks;
	}

	@Override
	public GeoBlocks updateImpl(com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws SystemException {
		geoBlocks = toUnwrappedModel(geoBlocks);

		boolean isNew = geoBlocks.isNew();

		Session session = null;

		try {
			session = openSession();

			if (geoBlocks.isNew()) {
				session.save(geoBlocks);

				geoBlocks.setNew(false);
			}
			else {
				session.merge(geoBlocks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GeoBlocksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoBlocksImpl.class, geoBlocks.getPrimaryKey(), geoBlocks);

		return geoBlocks;
	}

	protected GeoBlocks toUnwrappedModel(GeoBlocks geoBlocks) {
		if (geoBlocks instanceof GeoBlocksImpl) {
			return geoBlocks;
		}

		GeoBlocksImpl geoBlocksImpl = new GeoBlocksImpl();

		geoBlocksImpl.setNew(geoBlocks.isNew());
		geoBlocksImpl.setPrimaryKey(geoBlocks.getPrimaryKey());

		geoBlocksImpl.setGeonameId(geoBlocks.getGeonameId());
		geoBlocksImpl.setStartIp(geoBlocks.getStartIp());
		geoBlocksImpl.setEndIp(geoBlocks.getEndIp());

		return geoBlocksImpl;
	}

	/**
	 * Returns the geo blocks with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the geo blocks
	 * @return the geo blocks
	 * @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoBlocks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeoBlocksException, SystemException {
		GeoBlocks geoBlocks = fetchByPrimaryKey(primaryKey);

		if (geoBlocks == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeoBlocksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geoBlocks;
	}

	/**
	 * Returns the geo blocks with the primary key or throws a {@link com.rivetlogic.geo.NoSuchGeoBlocksException} if it could not be found.
	 *
	 * @param geoBlocksPK the primary key of the geo blocks
	 * @return the geo blocks
	 * @throws com.rivetlogic.geo.NoSuchGeoBlocksException if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoBlocks findByPrimaryKey(GeoBlocksPK geoBlocksPK)
		throws NoSuchGeoBlocksException, SystemException {
		return findByPrimaryKey((Serializable)geoBlocksPK);
	}

	/**
	 * Returns the geo blocks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geo blocks
	 * @return the geo blocks, or <code>null</code> if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoBlocks fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeoBlocks geoBlocks = (GeoBlocks)EntityCacheUtil.getResult(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
				GeoBlocksImpl.class, primaryKey);

		if (geoBlocks == _nullGeoBlocks) {
			return null;
		}

		if (geoBlocks == null) {
			Session session = null;

			try {
				session = openSession();

				geoBlocks = (GeoBlocks)session.get(GeoBlocksImpl.class,
						primaryKey);

				if (geoBlocks != null) {
					cacheResult(geoBlocks);
				}
				else {
					EntityCacheUtil.putResult(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
						GeoBlocksImpl.class, primaryKey, _nullGeoBlocks);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeoBlocksModelImpl.ENTITY_CACHE_ENABLED,
					GeoBlocksImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geoBlocks;
	}

	/**
	 * Returns the geo blocks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geoBlocksPK the primary key of the geo blocks
	 * @return the geo blocks, or <code>null</code> if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoBlocks fetchByPrimaryKey(GeoBlocksPK geoBlocksPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)geoBlocksPK);
	}

	/**
	 * Returns all the geo blockses.
	 *
	 * @return the geo blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeoBlocks> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GeoBlocks> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<GeoBlocks> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<GeoBlocks> list = (List<GeoBlocks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEOBLOCKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOBLOCKS;

				if (pagination) {
					sql = sql.concat(GeoBlocksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeoBlocks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeoBlocks>(list);
				}
				else {
					list = (List<GeoBlocks>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the geo blockses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeoBlocks geoBlocks : findAll()) {
			remove(geoBlocks);
		}
	}

	/**
	 * Returns the number of geo blockses.
	 *
	 * @return the number of geo blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GEOBLOCKS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the geo blocks persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.geo.model.GeoBlocks")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeoBlocks>> listenersList = new ArrayList<ModelListener<GeoBlocks>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeoBlocks>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(GeoBlocksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEOBLOCKS = "SELECT geoBlocks FROM GeoBlocks geoBlocks";
	private static final String _SQL_SELECT_GEOBLOCKS_WHERE = "SELECT geoBlocks FROM GeoBlocks geoBlocks WHERE ";
	private static final String _SQL_COUNT_GEOBLOCKS = "SELECT COUNT(geoBlocks) FROM GeoBlocks geoBlocks";
	private static final String _SQL_COUNT_GEOBLOCKS_WHERE = "SELECT COUNT(geoBlocks) FROM GeoBlocks geoBlocks WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geoBlocks.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeoBlocks exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GeoBlocks exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeoBlocksPersistenceImpl.class);
	private static GeoBlocks _nullGeoBlocks = new GeoBlocksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeoBlocks> toCacheModel() {
				return _nullGeoBlocksCacheModel;
			}
		};

	private static CacheModel<GeoBlocks> _nullGeoBlocksCacheModel = new CacheModel<GeoBlocks>() {
			@Override
			public GeoBlocks toEntityModel() {
				return _nullGeoBlocks;
			}
		};
}