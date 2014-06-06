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

import com.rivetlogic.geoip.NoSuchGeoipBlocksException;
import com.rivetlogic.geoip.model.GeoipBlocks;
import com.rivetlogic.geoip.model.impl.GeoipBlocksImpl;
import com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the geoip blocks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipBlocksPersistence
 * @see GeoipBlocksUtil
 * @generated
 */
public class GeoipBlocksPersistenceImpl extends BasePersistenceImpl<GeoipBlocks>
	implements GeoipBlocksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeoipBlocksUtil} to access the geoip blocks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeoipBlocksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksModelImpl.FINDER_CACHE_ENABLED, GeoipBlocksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksModelImpl.FINDER_CACHE_ENABLED, GeoipBlocksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTENDIP =
		new FinderPath(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksModelImpl.FINDER_CACHE_ENABLED, GeoipBlocksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStartEndIp",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STARTENDIP =
		new FinderPath(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByStartEndIp",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	 *
	 * @param startIp the start ip
	 * @param endIp the end ip
	 * @return the matching geoip blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeoipBlocks> findByStartEndIp(long startIp, long endIp)
		throws SystemException {
		return findByStartEndIp(startIp, endIp, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<GeoipBlocks> findByStartEndIp(long startIp, long endIp,
		int start, int end) throws SystemException {
		return findByStartEndIp(startIp, endIp, start, end, null);
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
	@Override
	public List<GeoipBlocks> findByStartEndIp(long startIp, long endIp,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTENDIP;
		finderArgs = new Object[] { startIp, endIp, start, end, orderByComparator };

		List<GeoipBlocks> list = (List<GeoipBlocks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GeoipBlocks geoipBlocks : list) {
				if ((startIp <= geoipBlocks.getStartIp()) ||
						(endIp >= geoipBlocks.getEndIp())) {
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

			query.append(_SQL_SELECT_GEOIPBLOCKS_WHERE);

			query.append(_FINDER_COLUMN_STARTENDIP_STARTIP_2);

			query.append(_FINDER_COLUMN_STARTENDIP_ENDIP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeoipBlocksModelImpl.ORDER_BY_JPQL);
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
					list = (List<GeoipBlocks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeoipBlocks>(list);
				}
				else {
					list = (List<GeoipBlocks>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first geoip blocks in the ordered set where startIp &lt; &#63; and endIp &gt; &#63;.
	 *
	 * @param startIp the start ip
	 * @param endIp the end ip
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geoip blocks
	 * @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a matching geoip blocks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks findByStartEndIp_First(long startIp, long endIp,
		OrderByComparator orderByComparator)
		throws NoSuchGeoipBlocksException, SystemException {
		GeoipBlocks geoipBlocks = fetchByStartEndIp_First(startIp, endIp,
				orderByComparator);

		if (geoipBlocks != null) {
			return geoipBlocks;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startIp=");
		msg.append(startIp);

		msg.append(", endIp=");
		msg.append(endIp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeoipBlocksException(msg.toString());
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
	@Override
	public GeoipBlocks fetchByStartEndIp_First(long startIp, long endIp,
		OrderByComparator orderByComparator) throws SystemException {
		List<GeoipBlocks> list = findByStartEndIp(startIp, endIp, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GeoipBlocks findByStartEndIp_Last(long startIp, long endIp,
		OrderByComparator orderByComparator)
		throws NoSuchGeoipBlocksException, SystemException {
		GeoipBlocks geoipBlocks = fetchByStartEndIp_Last(startIp, endIp,
				orderByComparator);

		if (geoipBlocks != null) {
			return geoipBlocks;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startIp=");
		msg.append(startIp);

		msg.append(", endIp=");
		msg.append(endIp);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeoipBlocksException(msg.toString());
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
	@Override
	public GeoipBlocks fetchByStartEndIp_Last(long startIp, long endIp,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStartEndIp(startIp, endIp);

		if (count == 0) {
			return null;
		}

		List<GeoipBlocks> list = findByStartEndIp(startIp, endIp, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GeoipBlocks[] findByStartEndIp_PrevAndNext(
		GeoipBlocksPK geoipBlocksPK, long startIp, long endIp,
		OrderByComparator orderByComparator)
		throws NoSuchGeoipBlocksException, SystemException {
		GeoipBlocks geoipBlocks = findByPrimaryKey(geoipBlocksPK);

		Session session = null;

		try {
			session = openSession();

			GeoipBlocks[] array = new GeoipBlocksImpl[3];

			array[0] = getByStartEndIp_PrevAndNext(session, geoipBlocks,
					startIp, endIp, orderByComparator, true);

			array[1] = geoipBlocks;

			array[2] = getByStartEndIp_PrevAndNext(session, geoipBlocks,
					startIp, endIp, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GeoipBlocks getByStartEndIp_PrevAndNext(Session session,
		GeoipBlocks geoipBlocks, long startIp, long endIp,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOIPBLOCKS_WHERE);

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
			query.append(GeoipBlocksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(startIp);

		qPos.add(endIp);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geoipBlocks);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GeoipBlocks> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geoip blockses where startIp &lt; &#63; and endIp &gt; &#63; from the database.
	 *
	 * @param startIp the start ip
	 * @param endIp the end ip
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStartEndIp(long startIp, long endIp)
		throws SystemException {
		for (GeoipBlocks geoipBlocks : findByStartEndIp(startIp, endIp,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(geoipBlocks);
		}
	}

	/**
	 * Returns the number of geoip blockses where startIp &lt; &#63; and endIp &gt; &#63;.
	 *
	 * @param startIp the start ip
	 * @param endIp the end ip
	 * @return the number of matching geoip blockses
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

			query.append(_SQL_COUNT_GEOIPBLOCKS_WHERE);

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

	private static final String _FINDER_COLUMN_STARTENDIP_STARTIP_2 = "geoipBlocks.id.startIp < ? AND ";
	private static final String _FINDER_COLUMN_STARTENDIP_ENDIP_2 = "geoipBlocks.endIp > ?";

	public GeoipBlocksPersistenceImpl() {
		setModelClass(GeoipBlocks.class);
	}

	/**
	 * Caches the geoip blocks in the entity cache if it is enabled.
	 *
	 * @param geoipBlocks the geoip blocks
	 */
	@Override
	public void cacheResult(GeoipBlocks geoipBlocks) {
		EntityCacheUtil.putResult(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksImpl.class, geoipBlocks.getPrimaryKey(), geoipBlocks);

		geoipBlocks.resetOriginalValues();
	}

	/**
	 * Caches the geoip blockses in the entity cache if it is enabled.
	 *
	 * @param geoipBlockses the geoip blockses
	 */
	@Override
	public void cacheResult(List<GeoipBlocks> geoipBlockses) {
		for (GeoipBlocks geoipBlocks : geoipBlockses) {
			if (EntityCacheUtil.getResult(
						GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
						GeoipBlocksImpl.class, geoipBlocks.getPrimaryKey()) == null) {
				cacheResult(geoipBlocks);
			}
			else {
				geoipBlocks.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geoip blockses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeoipBlocksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeoipBlocksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geoip blocks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeoipBlocks geoipBlocks) {
		EntityCacheUtil.removeResult(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksImpl.class, geoipBlocks.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeoipBlocks> geoipBlockses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeoipBlocks geoipBlocks : geoipBlockses) {
			EntityCacheUtil.removeResult(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
				GeoipBlocksImpl.class, geoipBlocks.getPrimaryKey());
		}
	}

	/**
	 * Creates a new geoip blocks with the primary key. Does not add the geoip blocks to the database.
	 *
	 * @param geoipBlocksPK the primary key for the new geoip blocks
	 * @return the new geoip blocks
	 */
	@Override
	public GeoipBlocks create(GeoipBlocksPK geoipBlocksPK) {
		GeoipBlocks geoipBlocks = new GeoipBlocksImpl();

		geoipBlocks.setNew(true);
		geoipBlocks.setPrimaryKey(geoipBlocksPK);

		return geoipBlocks;
	}

	/**
	 * Removes the geoip blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoipBlocksPK the primary key of the geoip blocks
	 * @return the geoip blocks that was removed
	 * @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks remove(GeoipBlocksPK geoipBlocksPK)
		throws NoSuchGeoipBlocksException, SystemException {
		return remove((Serializable)geoipBlocksPK);
	}

	/**
	 * Removes the geoip blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geoip blocks
	 * @return the geoip blocks that was removed
	 * @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks remove(Serializable primaryKey)
		throws NoSuchGeoipBlocksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeoipBlocks geoipBlocks = (GeoipBlocks)session.get(GeoipBlocksImpl.class,
					primaryKey);

			if (geoipBlocks == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeoipBlocksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geoipBlocks);
		}
		catch (NoSuchGeoipBlocksException nsee) {
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
	protected GeoipBlocks removeImpl(GeoipBlocks geoipBlocks)
		throws SystemException {
		geoipBlocks = toUnwrappedModel(geoipBlocks);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geoipBlocks)) {
				geoipBlocks = (GeoipBlocks)session.get(GeoipBlocksImpl.class,
						geoipBlocks.getPrimaryKeyObj());
			}

			if (geoipBlocks != null) {
				session.delete(geoipBlocks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geoipBlocks != null) {
			clearCache(geoipBlocks);
		}

		return geoipBlocks;
	}

	@Override
	public GeoipBlocks updateImpl(
		com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks)
		throws SystemException {
		geoipBlocks = toUnwrappedModel(geoipBlocks);

		boolean isNew = geoipBlocks.isNew();

		Session session = null;

		try {
			session = openSession();

			if (geoipBlocks.isNew()) {
				session.save(geoipBlocks);

				geoipBlocks.setNew(false);
			}
			else {
				session.merge(geoipBlocks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GeoipBlocksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
			GeoipBlocksImpl.class, geoipBlocks.getPrimaryKey(), geoipBlocks);

		return geoipBlocks;
	}

	protected GeoipBlocks toUnwrappedModel(GeoipBlocks geoipBlocks) {
		if (geoipBlocks instanceof GeoipBlocksImpl) {
			return geoipBlocks;
		}

		GeoipBlocksImpl geoipBlocksImpl = new GeoipBlocksImpl();

		geoipBlocksImpl.setNew(geoipBlocks.isNew());
		geoipBlocksImpl.setPrimaryKey(geoipBlocks.getPrimaryKey());

		geoipBlocksImpl.setGeonameId(geoipBlocks.getGeonameId());
		geoipBlocksImpl.setStartIp(geoipBlocks.getStartIp());
		geoipBlocksImpl.setEndIp(geoipBlocks.getEndIp());

		return geoipBlocksImpl;
	}

	/**
	 * Returns the geoip blocks with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the geoip blocks
	 * @return the geoip blocks
	 * @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeoipBlocksException, SystemException {
		GeoipBlocks geoipBlocks = fetchByPrimaryKey(primaryKey);

		if (geoipBlocks == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeoipBlocksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geoipBlocks;
	}

	/**
	 * Returns the geoip blocks with the primary key or throws a {@link com.rivetlogic.geoip.NoSuchGeoipBlocksException} if it could not be found.
	 *
	 * @param geoipBlocksPK the primary key of the geoip blocks
	 * @return the geoip blocks
	 * @throws com.rivetlogic.geoip.NoSuchGeoipBlocksException if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks findByPrimaryKey(GeoipBlocksPK geoipBlocksPK)
		throws NoSuchGeoipBlocksException, SystemException {
		return findByPrimaryKey((Serializable)geoipBlocksPK);
	}

	/**
	 * Returns the geoip blocks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geoip blocks
	 * @return the geoip blocks, or <code>null</code> if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeoipBlocks geoipBlocks = (GeoipBlocks)EntityCacheUtil.getResult(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
				GeoipBlocksImpl.class, primaryKey);

		if (geoipBlocks == _nullGeoipBlocks) {
			return null;
		}

		if (geoipBlocks == null) {
			Session session = null;

			try {
				session = openSession();

				geoipBlocks = (GeoipBlocks)session.get(GeoipBlocksImpl.class,
						primaryKey);

				if (geoipBlocks != null) {
					cacheResult(geoipBlocks);
				}
				else {
					EntityCacheUtil.putResult(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
						GeoipBlocksImpl.class, primaryKey, _nullGeoipBlocks);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeoipBlocksModelImpl.ENTITY_CACHE_ENABLED,
					GeoipBlocksImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geoipBlocks;
	}

	/**
	 * Returns the geoip blocks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geoipBlocksPK the primary key of the geoip blocks
	 * @return the geoip blocks, or <code>null</code> if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks fetchByPrimaryKey(GeoipBlocksPK geoipBlocksPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)geoipBlocksPK);
	}

	/**
	 * Returns all the geoip blockses.
	 *
	 * @return the geoip blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeoipBlocks> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GeoipBlocks> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<GeoipBlocks> findAll(int start, int end,
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

		List<GeoipBlocks> list = (List<GeoipBlocks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEOIPBLOCKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOIPBLOCKS;

				if (pagination) {
					sql = sql.concat(GeoipBlocksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeoipBlocks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeoipBlocks>(list);
				}
				else {
					list = (List<GeoipBlocks>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the geoip blockses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeoipBlocks geoipBlocks : findAll()) {
			remove(geoipBlocks);
		}
	}

	/**
	 * Returns the number of geoip blockses.
	 *
	 * @return the number of geoip blockses
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

				Query q = session.createQuery(_SQL_COUNT_GEOIPBLOCKS);

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
	 * Initializes the geoip blocks persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.geoip.model.GeoipBlocks")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeoipBlocks>> listenersList = new ArrayList<ModelListener<GeoipBlocks>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeoipBlocks>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeoipBlocksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEOIPBLOCKS = "SELECT geoipBlocks FROM GeoipBlocks geoipBlocks";
	private static final String _SQL_SELECT_GEOIPBLOCKS_WHERE = "SELECT geoipBlocks FROM GeoipBlocks geoipBlocks WHERE ";
	private static final String _SQL_COUNT_GEOIPBLOCKS = "SELECT COUNT(geoipBlocks) FROM GeoipBlocks geoipBlocks";
	private static final String _SQL_COUNT_GEOIPBLOCKS_WHERE = "SELECT COUNT(geoipBlocks) FROM GeoipBlocks geoipBlocks WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geoipBlocks.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeoipBlocks exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GeoipBlocks exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeoipBlocksPersistenceImpl.class);
	private static GeoipBlocks _nullGeoipBlocks = new GeoipBlocksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeoipBlocks> toCacheModel() {
				return _nullGeoipBlocksCacheModel;
			}
		};

	private static CacheModel<GeoipBlocks> _nullGeoipBlocksCacheModel = new CacheModel<GeoipBlocks>() {
			@Override
			public GeoipBlocks toEntityModel() {
				return _nullGeoipBlocks;
			}
		};
}