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

package com.rivetlogic.geoip.service.base;

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

import com.rivetlogic.geoip.model.GeoipBlocks;
import com.rivetlogic.geoip.service.GeoipBlocksLocalService;
import com.rivetlogic.geoip.service.persistence.GeoipBlocksPK;
import com.rivetlogic.geoip.service.persistence.GeoipBlocksPersistence;
import com.rivetlogic.geoip.service.persistence.GeoipLocationsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the geoip blocks local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.geoip.service.impl.GeoipBlocksLocalServiceImpl}.
 * </p>
 *
 * @author charles.rodriguez
 * @see com.rivetlogic.geoip.service.impl.GeoipBlocksLocalServiceImpl
 * @see com.rivetlogic.geoip.service.GeoipBlocksLocalServiceUtil
 * @generated
 */
public abstract class GeoipBlocksLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements GeoipBlocksLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.geoip.service.GeoipBlocksLocalServiceUtil} to access the geoip blocks local service.
	 */

	/**
	 * Adds the geoip blocks to the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoipBlocks the geoip blocks
	 * @return the geoip blocks that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GeoipBlocks addGeoipBlocks(GeoipBlocks geoipBlocks)
		throws SystemException {
		geoipBlocks.setNew(true);

		return geoipBlocksPersistence.update(geoipBlocks);
	}

	/**
	 * Creates a new geoip blocks with the primary key. Does not add the geoip blocks to the database.
	 *
	 * @param geoipBlocksPK the primary key for the new geoip blocks
	 * @return the new geoip blocks
	 */
	@Override
	public GeoipBlocks createGeoipBlocks(GeoipBlocksPK geoipBlocksPK) {
		return geoipBlocksPersistence.create(geoipBlocksPK);
	}

	/**
	 * Deletes the geoip blocks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoipBlocksPK the primary key of the geoip blocks
	 * @return the geoip blocks that was removed
	 * @throws PortalException if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GeoipBlocks deleteGeoipBlocks(GeoipBlocksPK geoipBlocksPK)
		throws PortalException, SystemException {
		return geoipBlocksPersistence.remove(geoipBlocksPK);
	}

	/**
	 * Deletes the geoip blocks from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geoipBlocks the geoip blocks
	 * @return the geoip blocks that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GeoipBlocks deleteGeoipBlocks(GeoipBlocks geoipBlocks)
		throws SystemException {
		return geoipBlocksPersistence.remove(geoipBlocks);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(GeoipBlocks.class,
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
		return geoipBlocksPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return geoipBlocksPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.geoip.model.impl.GeoipBlocksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return geoipBlocksPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return geoipBlocksPersistence.countWithDynamicQuery(dynamicQuery);
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
		return geoipBlocksPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public GeoipBlocks fetchGeoipBlocks(GeoipBlocksPK geoipBlocksPK)
		throws SystemException {
		return geoipBlocksPersistence.fetchByPrimaryKey(geoipBlocksPK);
	}

	/**
	 * Returns the geoip blocks with the primary key.
	 *
	 * @param geoipBlocksPK the primary key of the geoip blocks
	 * @return the geoip blocks
	 * @throws PortalException if a geoip blocks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeoipBlocks getGeoipBlocks(GeoipBlocksPK geoipBlocksPK)
		throws PortalException, SystemException {
		return geoipBlocksPersistence.findByPrimaryKey(geoipBlocksPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return geoipBlocksPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<GeoipBlocks> getGeoipBlockses(int start, int end)
		throws SystemException {
		return geoipBlocksPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of geoip blockses.
	 *
	 * @return the number of geoip blockses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getGeoipBlocksesCount() throws SystemException {
		return geoipBlocksPersistence.countAll();
	}

	/**
	 * Updates the geoip blocks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param geoipBlocks the geoip blocks
	 * @return the geoip blocks that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GeoipBlocks updateGeoipBlocks(GeoipBlocks geoipBlocks)
		throws SystemException {
		return geoipBlocksPersistence.update(geoipBlocks);
	}

	/**
	 * Returns the geoip blocks local service.
	 *
	 * @return the geoip blocks local service
	 */
	public com.rivetlogic.geoip.service.GeoipBlocksLocalService getGeoipBlocksLocalService() {
		return geoipBlocksLocalService;
	}

	/**
	 * Sets the geoip blocks local service.
	 *
	 * @param geoipBlocksLocalService the geoip blocks local service
	 */
	public void setGeoipBlocksLocalService(
		com.rivetlogic.geoip.service.GeoipBlocksLocalService geoipBlocksLocalService) {
		this.geoipBlocksLocalService = geoipBlocksLocalService;
	}

	/**
	 * Returns the geoip blocks persistence.
	 *
	 * @return the geoip blocks persistence
	 */
	public GeoipBlocksPersistence getGeoipBlocksPersistence() {
		return geoipBlocksPersistence;
	}

	/**
	 * Sets the geoip blocks persistence.
	 *
	 * @param geoipBlocksPersistence the geoip blocks persistence
	 */
	public void setGeoipBlocksPersistence(
		GeoipBlocksPersistence geoipBlocksPersistence) {
		this.geoipBlocksPersistence = geoipBlocksPersistence;
	}

	/**
	 * Returns the geoip locations local service.
	 *
	 * @return the geoip locations local service
	 */
	public com.rivetlogic.geoip.service.GeoipLocationsLocalService getGeoipLocationsLocalService() {
		return geoipLocationsLocalService;
	}

	/**
	 * Sets the geoip locations local service.
	 *
	 * @param geoipLocationsLocalService the geoip locations local service
	 */
	public void setGeoipLocationsLocalService(
		com.rivetlogic.geoip.service.GeoipLocationsLocalService geoipLocationsLocalService) {
		this.geoipLocationsLocalService = geoipLocationsLocalService;
	}

	/**
	 * Returns the geoip locations remote service.
	 *
	 * @return the geoip locations remote service
	 */
	public com.rivetlogic.geoip.service.GeoipLocationsService getGeoipLocationsService() {
		return geoipLocationsService;
	}

	/**
	 * Sets the geoip locations remote service.
	 *
	 * @param geoipLocationsService the geoip locations remote service
	 */
	public void setGeoipLocationsService(
		com.rivetlogic.geoip.service.GeoipLocationsService geoipLocationsService) {
		this.geoipLocationsService = geoipLocationsService;
	}

	/**
	 * Returns the geoip locations persistence.
	 *
	 * @return the geoip locations persistence
	 */
	public GeoipLocationsPersistence getGeoipLocationsPersistence() {
		return geoipLocationsPersistence;
	}

	/**
	 * Sets the geoip locations persistence.
	 *
	 * @param geoipLocationsPersistence the geoip locations persistence
	 */
	public void setGeoipLocationsPersistence(
		GeoipLocationsPersistence geoipLocationsPersistence) {
		this.geoipLocationsPersistence = geoipLocationsPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.rivetlogic.geoip.model.GeoipBlocks",
			geoipBlocksLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rivetlogic.geoip.model.GeoipBlocks");
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
		return GeoipBlocks.class;
	}

	protected String getModelClassName() {
		return GeoipBlocks.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = geoipBlocksPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.geoip.service.GeoipBlocksLocalService.class)
	protected com.rivetlogic.geoip.service.GeoipBlocksLocalService geoipBlocksLocalService;
	@BeanReference(type = GeoipBlocksPersistence.class)
	protected GeoipBlocksPersistence geoipBlocksPersistence;
	@BeanReference(type = com.rivetlogic.geoip.service.GeoipLocationsLocalService.class)
	protected com.rivetlogic.geoip.service.GeoipLocationsLocalService geoipLocationsLocalService;
	@BeanReference(type = com.rivetlogic.geoip.service.GeoipLocationsService.class)
	protected com.rivetlogic.geoip.service.GeoipLocationsService geoipLocationsService;
	@BeanReference(type = GeoipLocationsPersistence.class)
	protected GeoipLocationsPersistence geoipLocationsPersistence;
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
	private GeoipBlocksLocalServiceClpInvoker _clpInvoker = new GeoipBlocksLocalServiceClpInvoker();
}