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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.geoip.NoSuchGeoipLocationsException;
import com.rivetlogic.geoip.model.GeoipLocations;
import com.rivetlogic.geoip.model.impl.GeoipLocationsImpl;
import com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the geoip locations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipLocationsPersistence
 * @see GeoipLocationsUtil
 * @generated
 */
public class GeoipLocationsPersistenceImpl extends BasePersistenceImpl<GeoipLocations>
	implements GeoipLocationsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeoipLocationsUtil} to access the geoip locations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeoipLocationsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoipLocationsModelImpl.FINDER_CACHE_ENABLED,
			GeoipLocationsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoipLocationsModelImpl.FINDER_CACHE_ENABLED,
			GeoipLocationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoipLocationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GeoipLocationsPersistenceImpl() {
		setModelClass(GeoipLocations.class);
	}

	/**
	 * Caches the geoip locations in the entity cache if it is enabled.
	 *
	 * @param geoipLocations the geoip locations
	 */
	@Override
	public void cacheResult(GeoipLocations geoipLocations) {
		EntityCacheUtil.putResult(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoipLocationsImpl.class, geoipLocations.getPrimaryKey(),
			geoipLocations);

		geoipLocations.resetOriginalValues();
	}

	/**
	 * Caches the geoip locationses in the entity cache if it is enabled.
	 *
	 * @param geoipLocationses the geoip locationses
	 */
	@Override
	public void cacheResult(List<GeoipLocations> geoipLocationses) {
		for (GeoipLocations geoipLocations : geoipLocationses) {
			if (EntityCacheUtil.getResult(
						GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
						GeoipLocationsImpl.class, geoipLocations.getPrimaryKey()) == null) {
				cacheResult(geoipLocations);
			}
			else {
				geoipLocations.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geoip locationses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeoipLocationsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeoipLocationsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geoip locations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeoipLocations geoipLocations) {
		EntityCacheUtil.removeResult(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoipLocationsImpl.class, geoipLocations.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeoipLocations> geoipLocationses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeoipLocations geoipLocations : geoipLocationses) {
			EntityCacheUtil.removeResult(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
				GeoipLocationsImpl.class, geoipLocations.getPrimaryKey());
		}
	}

	/**
	 * Creates a new geoip locations with the primary key. Does not add the geoip locations to the database.
	 *
	 * @param geonameId the primary key for the new geoip locations
	 * @return the new geoip locations
	 */
	@Override
	public GeoipLocations create(long geonameId) {
		GeoipLocations geoipLocations = new GeoipLocationsImpl();

		geoipLocations.setNew(true);
		geoipLocations.setPrimaryKey(geonameId);

		return geoipLocations;
	}

	/**
	 * Removes the geoip locations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geonameId the primary key of the geoip locations
	 * @return the geoip locations that was removed
	 * @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipLocations remove(long geonameId)
		throws NoSuchGeoipLocationsException, SystemException {
		return remove((Serializable)geonameId);
	}

	/**
	 * Removes the geoip locations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geoip locations
	 * @return the geoip locations that was removed
	 * @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipLocations remove(Serializable primaryKey)
		throws NoSuchGeoipLocationsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeoipLocations geoipLocations = (GeoipLocations)session.get(GeoipLocationsImpl.class,
					primaryKey);

			if (geoipLocations == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeoipLocationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geoipLocations);
		}
		catch (NoSuchGeoipLocationsException nsee) {
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
	protected GeoipLocations removeImpl(GeoipLocations geoipLocations)
		throws SystemException {
		geoipLocations = toUnwrappedModel(geoipLocations);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geoipLocations)) {
				geoipLocations = (GeoipLocations)session.get(GeoipLocationsImpl.class,
						geoipLocations.getPrimaryKeyObj());
			}

			if (geoipLocations != null) {
				session.delete(geoipLocations);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geoipLocations != null) {
			clearCache(geoipLocations);
		}

		return geoipLocations;
	}

	@Override
	public GeoipLocations updateImpl(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations)
		throws SystemException {
		geoipLocations = toUnwrappedModel(geoipLocations);

		boolean isNew = geoipLocations.isNew();

		Session session = null;

		try {
			session = openSession();

			if (geoipLocations.isNew()) {
				session.save(geoipLocations);

				geoipLocations.setNew(false);
			}
			else {
				session.merge(geoipLocations);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoipLocationsImpl.class, geoipLocations.getPrimaryKey(),
			geoipLocations);

		return geoipLocations;
	}

	protected GeoipLocations toUnwrappedModel(GeoipLocations geoipLocations) {
		if (geoipLocations instanceof GeoipLocationsImpl) {
			return geoipLocations;
		}

		GeoipLocationsImpl geoipLocationsImpl = new GeoipLocationsImpl();

		geoipLocationsImpl.setNew(geoipLocations.isNew());
		geoipLocationsImpl.setPrimaryKey(geoipLocations.getPrimaryKey());

		geoipLocationsImpl.setGeonameId(geoipLocations.getGeonameId());
		geoipLocationsImpl.setCountryIsoCode(geoipLocations.getCountryIsoCode());

		return geoipLocationsImpl;
	}

	/**
	 * Returns the geoip locations with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the geoip locations
	 * @return the geoip locations
	 * @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipLocations findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeoipLocationsException, SystemException {
		GeoipLocations geoipLocations = fetchByPrimaryKey(primaryKey);

		if (geoipLocations == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeoipLocationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geoipLocations;
	}

	/**
	 * Returns the geoip locations with the primary key or throws a {@link com.rivetlogic.geoip.NoSuchGeoipLocationsException} if it could not be found.
	 *
	 * @param geonameId the primary key of the geoip locations
	 * @return the geoip locations
	 * @throws com.rivetlogic.geoip.NoSuchGeoipLocationsException if a geoip locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipLocations findByPrimaryKey(long geonameId)
		throws NoSuchGeoipLocationsException, SystemException {
		return findByPrimaryKey((Serializable)geonameId);
	}

	/**
	 * Returns the geoip locations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geoip locations
	 * @return the geoip locations, or <code>null</code> if a geoip locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipLocations fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeoipLocations geoipLocations = (GeoipLocations)EntityCacheUtil.getResult(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
				GeoipLocationsImpl.class, primaryKey);

		if (geoipLocations == _nullGeoipLocations) {
			return null;
		}

		if (geoipLocations == null) {
			Session session = null;

			try {
				session = openSession();

				geoipLocations = (GeoipLocations)session.get(GeoipLocationsImpl.class,
						primaryKey);

				if (geoipLocations != null) {
					cacheResult(geoipLocations);
				}
				else {
					EntityCacheUtil.putResult(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
						GeoipLocationsImpl.class, primaryKey,
						_nullGeoipLocations);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeoipLocationsModelImpl.ENTITY_CACHE_ENABLED,
					GeoipLocationsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geoipLocations;
	}

	/**
	 * Returns the geoip locations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geonameId the primary key of the geoip locations
	 * @return the geoip locations, or <code>null</code> if a geoip locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipLocations fetchByPrimaryKey(long geonameId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)geonameId);
	}

	/**
	 * Returns all the geoip locationses.
	 *
	 * @return the geoip locationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeoipLocations> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GeoipLocations> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<GeoipLocations> findAll(int start, int end,
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

		List<GeoipLocations> list = (List<GeoipLocations>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEOIPLOCATIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOIPLOCATIONS;

				if (pagination) {
					sql = sql.concat(GeoipLocationsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeoipLocations>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeoipLocations>(list);
				}
				else {
					list = (List<GeoipLocations>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the geoip locationses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeoipLocations geoipLocations : findAll()) {
			remove(geoipLocations);
		}
	}

	/**
	 * Returns the number of geoip locationses.
	 *
	 * @return the number of geoip locationses
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

				Query q = session.createQuery(_SQL_COUNT_GEOIPLOCATIONS);

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
	 * Initializes the geoip locations persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.geoip.model.GeoipLocations")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeoipLocations>> listenersList = new ArrayList<ModelListener<GeoipLocations>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeoipLocations>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeoipLocationsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEOIPLOCATIONS = "SELECT geoipLocations FROM GeoipLocations geoipLocations";
	private static final String _SQL_COUNT_GEOIPLOCATIONS = "SELECT COUNT(geoipLocations) FROM GeoipLocations geoipLocations";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geoipLocations.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeoipLocations exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeoipLocationsPersistenceImpl.class);
	private static GeoipLocations _nullGeoipLocations = new GeoipLocationsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeoipLocations> toCacheModel() {
				return _nullGeoipLocationsCacheModel;
			}
		};

	private static CacheModel<GeoipLocations> _nullGeoipLocationsCacheModel = new CacheModel<GeoipLocations>() {
			@Override
			public GeoipLocations toEntityModel() {
				return _nullGeoipLocations;
			}
		};
}