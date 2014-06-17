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

package com.rivetlogic.geo.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rivetlogic.geo.model.GeoBlocks;
import com.rivetlogic.geo.service.GeoBlocksLocalService;
import com.rivetlogic.geo.service.persistence.GeoBlocksPK;
import com.rivetlogic.geo.service.persistence.GeoBlocksPersistence;
import com.rivetlogic.geo.service.persistence.GeoLocationsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the geo blocks local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.geo.service.impl.GeoBlocksLocalServiceImpl}.
 * </p>
 *
 * @author charles.rodriguez
 * @see com.rivetlogic.geo.service.impl.GeoBlocksLocalServiceImpl
 * @see com.rivetlogic.geo.service.GeoBlocksLocalServiceUtil
 * @generated
 */
public abstract class GeoBlocksLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements GeoBlocksLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.geo.service.GeoBlocksLocalServiceUtil} to access the geo blocks local service.
	 */

	/**
	 * Adds the geo blocks to the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoBlocks the geo blocks
	 * @return the geo blocks that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GeoBlocks addGeoBlocks(GeoBlocks geoBlocks)
		throws SystemException {
		geoBlocks.setNew(true);

		return geoBlocksPersistence.update(geoBlocks);
	}

	/**
	 * Creates a new geo blocks with the primary key. Does not add the geo blocks to the database.
	 *
	 * @param geoBlocksPK the primary key for the new geo blocks
	 * @return the new geo blocks
	 */
	@Override
	public GeoBlocks createGeoBlocks(GeoBlocksPK geoBlocksPK) {
		return geoBlocksPersistence.create(geoBlocksPK);
	}

	/**
	 * Deletes the geo blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoBlocksPK the primary key of the geo blocks
	 * @return the geo blocks that was removed
	 * @throws PortalException if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GeoBlocks deleteGeoBlocks(GeoBlocksPK geoBlocksPK)
		throws PortalException, SystemException {
		return geoBlocksPersistence.remove(geoBlocksPK);
	}

	/**
	 * Deletes the geo blocks from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoBlocks the geo blocks
	 * @return the geo blocks that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GeoBlocks deleteGeoBlocks(GeoBlocks geoBlocks)
		throws SystemException {
		return geoBlocksPersistence.remove(geoBlocks);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(GeoBlocks.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return geoBlocksPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return geoBlocksPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geo.model.impl.GeoBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return geoBlocksPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return geoBlocksPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return geoBlocksPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public GeoBlocks fetchGeoBlocks(GeoBlocksPK geoBlocksPK)
		throws SystemException {
		return geoBlocksPersistence.fetchByPrimaryKey(geoBlocksPK);
	}

	/**
	 * Returns the geo blocks with the primary key.
	 *
	 * @param geoBlocksPK the primary key of the geo blocks
	 * @return the geo blocks
	 * @throws PortalException if a geo blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoBlocks getGeoBlocks(GeoBlocksPK geoBlocksPK)
		throws PortalException, SystemException {
		return geoBlocksPersistence.findByPrimaryKey(geoBlocksPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return geoBlocksPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<GeoBlocks> getGeoBlockses(int start, int end)
		throws SystemException {
		return geoBlocksPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of geo blockses.
	 *
	 * @return the number of geo blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getGeoBlocksesCount() throws SystemException {
		return geoBlocksPersistence.countAll();
	}

	/**
	 * Updates the geo blocks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param geoBlocks the geo blocks
	 * @return the geo blocks that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GeoBlocks updateGeoBlocks(GeoBlocks geoBlocks)
		throws SystemException {
		return geoBlocksPersistence.update(geoBlocks);
	}

	/**
	 * Returns the geo blocks local service.
	 *
	 * @return the geo blocks local service
	 */
	public com.rivetlogic.geo.service.GeoBlocksLocalService getGeoBlocksLocalService() {
		return geoBlocksLocalService;
	}

	/**
	 * Sets the geo blocks local service.
	 *
	 * @param geoBlocksLocalService the geo blocks local service
	 */
	public void setGeoBlocksLocalService(
		com.rivetlogic.geo.service.GeoBlocksLocalService geoBlocksLocalService) {
		this.geoBlocksLocalService = geoBlocksLocalService;
	}

	/**
	 * Returns the geo blocks persistence.
	 *
	 * @return the geo blocks persistence
	 */
	public GeoBlocksPersistence getGeoBlocksPersistence() {
		return geoBlocksPersistence;
	}

	/**
	 * Sets the geo blocks persistence.
	 *
	 * @param geoBlocksPersistence the geo blocks persistence
	 */
	public void setGeoBlocksPersistence(
		GeoBlocksPersistence geoBlocksPersistence) {
		this.geoBlocksPersistence = geoBlocksPersistence;
	}

	/**
	 * Returns the geo locations local service.
	 *
	 * @return the geo locations local service
	 */
	public com.rivetlogic.geo.service.GeoLocationsLocalService getGeoLocationsLocalService() {
		return geoLocationsLocalService;
	}

	/**
	 * Sets the geo locations local service.
	 *
	 * @param geoLocationsLocalService the geo locations local service
	 */
	public void setGeoLocationsLocalService(
		com.rivetlogic.geo.service.GeoLocationsLocalService geoLocationsLocalService) {
		this.geoLocationsLocalService = geoLocationsLocalService;
	}

	/**
	 * Returns the geo locations remote service.
	 *
	 * @return the geo locations remote service
	 */
	public com.rivetlogic.geo.service.GeoLocationsService getGeoLocationsService() {
		return geoLocationsService;
	}

	/**
	 * Sets the geo locations remote service.
	 *
	 * @param geoLocationsService the geo locations remote service
	 */
	public void setGeoLocationsService(
		com.rivetlogic.geo.service.GeoLocationsService geoLocationsService) {
		this.geoLocationsService = geoLocationsService;
	}

	/**
	 * Returns the geo locations persistence.
	 *
	 * @return the geo locations persistence
	 */
	public GeoLocationsPersistence getGeoLocationsPersistence() {
		return geoLocationsPersistence;
	}

	/**
	 * Sets the geo locations persistence.
	 *
	 * @param geoLocationsPersistence the geo locations persistence
	 */
	public void setGeoLocationsPersistence(
		GeoLocationsPersistence geoLocationsPersistence) {
		this.geoLocationsPersistence = geoLocationsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rivetlogic.geo.model.GeoBlocks",
			geoBlocksLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rivetlogic.geo.model.GeoBlocks");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return GeoBlocks.class;
	}

	protected String getModelClassName() {
		return GeoBlocks.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = geoBlocksPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.geo.service.GeoBlocksLocalService.class)
	protected com.rivetlogic.geo.service.GeoBlocksLocalService geoBlocksLocalService;
	@BeanReference(type = GeoBlocksPersistence.class)
	protected GeoBlocksPersistence geoBlocksPersistence;
	@BeanReference(type = com.rivetlogic.geo.service.GeoLocationsLocalService.class)
	protected com.rivetlogic.geo.service.GeoLocationsLocalService geoLocationsLocalService;
	@BeanReference(type = com.rivetlogic.geo.service.GeoLocationsService.class)
	protected com.rivetlogic.geo.service.GeoLocationsService geoLocationsService;
	@BeanReference(type = GeoLocationsPersistence.class)
	protected GeoLocationsPersistence geoLocationsPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private GeoBlocksLocalServiceClpInvoker _clpInvoker = new GeoBlocksLocalServiceClpInvoker();
}