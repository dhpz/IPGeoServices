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

import com.rivetlogic.geo.NoSuchGeoLocationsException;
import com.rivetlogic.geo.model.GeoLocations;
import com.rivetlogic.geo.model.impl.GeoLocationsImpl;
import com.rivetlogic.geo.model.impl.GeoLocationsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the geo locations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoLocationsPersistence
 * @see GeoLocationsUtil
 * @generated
 */
public class GeoLocationsPersistenceImpl extends BasePersistenceImpl<GeoLocations>
	implements GeoLocationsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeoLocationsUtil} to access the geo locations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeoLocationsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoLocationsModelImpl.FINDER_CACHE_ENABLED, GeoLocationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoLocationsModelImpl.FINDER_CACHE_ENABLED, GeoLocationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoLocationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GeoLocationsPersistenceImpl() {
		setModelClass(GeoLocations.class);
	}

	/**
	 * Caches the geo locations in the entity cache if it is enabled.
	 *
	 * @param geoLocations the geo locations
	 */
	@Override
	public void cacheResult(GeoLocations geoLocations) {
		EntityCacheUtil.putResult(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoLocationsImpl.class, geoLocations.getPrimaryKey(), geoLocations);

		geoLocations.resetOriginalValues();
	}

	/**
	 * Caches the geo locationses in the entity cache if it is enabled.
	 *
	 * @param geoLocationses the geo locationses
	 */
	@Override
	public void cacheResult(List<GeoLocations> geoLocationses) {
		for (GeoLocations geoLocations : geoLocationses) {
			if (EntityCacheUtil.getResult(
						GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
						GeoLocationsImpl.class, geoLocations.getPrimaryKey()) == null) {
				cacheResult(geoLocations);
			}
			else {
				geoLocations.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geo locationses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeoLocationsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeoLocationsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geo locations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeoLocations geoLocations) {
		EntityCacheUtil.removeResult(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoLocationsImpl.class, geoLocations.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeoLocations> geoLocationses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeoLocations geoLocations : geoLocationses) {
			EntityCacheUtil.removeResult(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
				GeoLocationsImpl.class, geoLocations.getPrimaryKey());
		}
	}

	/**
	 * Creates a new geo locations with the primary key. Does not add the geo locations to the database.
	 *
	 * @param geonameId the primary key for the new geo locations
	 * @return the new geo locations
	 */
	@Override
	public GeoLocations create(long geonameId) {
		GeoLocations geoLocations = new GeoLocationsImpl();

		geoLocations.setNew(true);
		geoLocations.setPrimaryKey(geonameId);

		return geoLocations;
	}

	/**
	 * Removes the geo locations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geonameId the primary key of the geo locations
	 * @return the geo locations that was removed
	 * @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoLocations remove(long geonameId)
		throws NoSuchGeoLocationsException, SystemException {
		return remove((Serializable)geonameId);
	}

	/**
	 * Removes the geo locations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geo locations
	 * @return the geo locations that was removed
	 * @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoLocations remove(Serializable primaryKey)
		throws NoSuchGeoLocationsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeoLocations geoLocations = (GeoLocations)session.get(GeoLocationsImpl.class,
					primaryKey);

			if (geoLocations == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeoLocationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geoLocations);
		}
		catch (NoSuchGeoLocationsException nsee) {
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
	protected GeoLocations removeImpl(GeoLocations geoLocations)
		throws SystemException {
		geoLocations = toUnwrappedModel(geoLocations);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geoLocations)) {
				geoLocations = (GeoLocations)session.get(GeoLocationsImpl.class,
						geoLocations.getPrimaryKeyObj());
			}

			if (geoLocations != null) {
				session.delete(geoLocations);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geoLocations != null) {
			clearCache(geoLocations);
		}

		return geoLocations;
	}

	@Override
	public GeoLocations updateImpl(
		com.rivetlogic.geo.model.GeoLocations geoLocations)
		throws SystemException {
		geoLocations = toUnwrappedModel(geoLocations);

		boolean isNew = geoLocations.isNew();

		Session session = null;

		try {
			session = openSession();

			if (geoLocations.isNew()) {
				session.save(geoLocations);

				geoLocations.setNew(false);
			}
			else {
				session.merge(geoLocations);
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

		EntityCacheUtil.putResult(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
			GeoLocationsImpl.class, geoLocations.getPrimaryKey(), geoLocations);

		return geoLocations;
	}

	protected GeoLocations toUnwrappedModel(GeoLocations geoLocations) {
		if (geoLocations instanceof GeoLocationsImpl) {
			return geoLocations;
		}

		GeoLocationsImpl geoLocationsImpl = new GeoLocationsImpl();

		geoLocationsImpl.setNew(geoLocations.isNew());
		geoLocationsImpl.setPrimaryKey(geoLocations.getPrimaryKey());

		geoLocationsImpl.setGeonameId(geoLocations.getGeonameId());
		geoLocationsImpl.setCountryIsoCode(geoLocations.getCountryIsoCode());

		return geoLocationsImpl;
	}

	/**
	 * Returns the geo locations with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the geo locations
	 * @return the geo locations
	 * @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoLocations findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeoLocationsException, SystemException {
		GeoLocations geoLocations = fetchByPrimaryKey(primaryKey);

		if (geoLocations == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeoLocationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geoLocations;
	}

	/**
	 * Returns the geo locations with the primary key or throws a {@link com.rivetlogic.geo.NoSuchGeoLocationsException} if it could not be found.
	 *
	 * @param geonameId the primary key of the geo locations
	 * @return the geo locations
	 * @throws com.rivetlogic.geo.NoSuchGeoLocationsException if a geo locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoLocations findByPrimaryKey(long geonameId)
		throws NoSuchGeoLocationsException, SystemException {
		return findByPrimaryKey((Serializable)geonameId);
	}

	/**
	 * Returns the geo locations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geo locations
	 * @return the geo locations, or <code>null</code> if a geo locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoLocations fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeoLocations geoLocations = (GeoLocations)EntityCacheUtil.getResult(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
				GeoLocationsImpl.class, primaryKey);

		if (geoLocations == _nullGeoLocations) {
			return null;
		}

		if (geoLocations == null) {
			Session session = null;

			try {
				session = openSession();

				geoLocations = (GeoLocations)session.get(GeoLocationsImpl.class,
						primaryKey);

				if (geoLocations != null) {
					cacheResult(geoLocations);
				}
				else {
					EntityCacheUtil.putResult(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
						GeoLocationsImpl.class, primaryKey, _nullGeoLocations);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeoLocationsModelImpl.ENTITY_CACHE_ENABLED,
					GeoLocationsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geoLocations;
	}

	/**
	 * Returns the geo locations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geonameId the primary key of the geo locations
	 * @return the geo locations, or <code>null</code> if a geo locations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoLocations fetchByPrimaryKey(long geonameId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)geonameId);
	}

	/**
	 * Returns all the geo locationses.
	 *
	 * @return the geo locationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeoLocations> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GeoLocations> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<GeoLocations> findAll(int start, int end,
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

		List<GeoLocations> list = (List<GeoLocations>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEOLOCATIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOLOCATIONS;

				if (pagination) {
					sql = sql.concat(GeoLocationsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeoLocations>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeoLocations>(list);
				}
				else {
					list = (List<GeoLocations>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the geo locationses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeoLocations geoLocations : findAll()) {
			remove(geoLocations);
		}
	}

	/**
	 * Returns the number of geo locationses.
	 *
	 * @return the number of geo locationses
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

				Query q = session.createQuery(_SQL_COUNT_GEOLOCATIONS);

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
	 * Initializes the geo locations persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.geo.model.GeoLocations")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeoLocations>> listenersList = new ArrayList<ModelListener<GeoLocations>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeoLocations>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeoLocationsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEOLOCATIONS = "SELECT geoLocations FROM GeoLocations geoLocations";
	private static final String _SQL_COUNT_GEOLOCATIONS = "SELECT COUNT(geoLocations) FROM GeoLocations geoLocations";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geoLocations.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeoLocations exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeoLocationsPersistenceImpl.class);
	private static GeoLocations _nullGeoLocations = new GeoLocationsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeoLocations> toCacheModel() {
				return _nullGeoLocationsCacheModel;
			}
		};

	private static CacheModel<GeoLocations> _nullGeoLocationsCacheModel = new CacheModel<GeoLocations>() {
			@Override
			public GeoLocations toEntityModel() {
				return _nullGeoLocations;
			}
		};
}