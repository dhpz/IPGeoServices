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

package com.rivetlogic.geoip.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeoipBlocksLocalService}.
 *
 * @author charles.rodriguez
 * @see GeoipBlocksLocalService
 * @generated
 */
public class GeoipBlocksLocalServiceWrapper implements GeoipBlocksLocalService,
	ServiceWrapper<GeoipBlocksLocalService> {
	public GeoipBlocksLocalServiceWrapper(
		GeoipBlocksLocalService geoipBlocksLocalService) {
		_geoipBlocksLocalService = geoipBlocksLocalService;
	}

	/**
	* Adds the geoip blocks to the database. Also notifies the appropriate model listeners.
	*
	* @param geoipBlocks the geoip blocks
	* @return the geoip blocks that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks addGeoipBlocks(
		com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.addGeoipBlocks(geoipBlocks);
	}

	/**
	* Creates a new geoip blocks with the primary key. Does not add the geoip blocks to the database.
	*
	* @param geoipBlocksPK the primary key for the new geoip blocks
	* @return the new geoip blocks
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks createGeoipBlocks(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK) {
		return _geoipBlocksLocalService.createGeoipBlocks(geoipBlocksPK);
	}

	/**
	* Deletes the geoip blocks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geoipBlocksPK the primary key of the geoip blocks
	* @return the geoip blocks that was removed
	* @throws PortalException if a geoip blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks deleteGeoipBlocks(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.deleteGeoipBlocks(geoipBlocksPK);
	}

	/**
	* Deletes the geoip blocks from the database. Also notifies the appropriate model listeners.
	*
	* @param geoipBlocks the geoip blocks
	* @return the geoip blocks that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks deleteGeoipBlocks(
		com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.deleteGeoipBlocks(geoipBlocks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geoipBlocksLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks fetchGeoipBlocks(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.fetchGeoipBlocks(geoipBlocksPK);
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
	public com.rivetlogic.geoip.model.GeoipBlocks getGeoipBlocks(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK geoipBlocksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.getGeoipBlocks(geoipBlocksPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rivetlogic.geoip.model.GeoipBlocks> getGeoipBlockses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.getGeoipBlockses(start, end);
	}

	/**
	* Returns the number of geoip blockses.
	*
	* @return the number of geoip blockses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeoipBlocksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.getGeoipBlocksesCount();
	}

	/**
	* Updates the geoip blocks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geoipBlocks the geoip blocks
	* @return the geoip blocks that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks updateGeoipBlocks(
		com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoipBlocksLocalService.updateGeoipBlocks(geoipBlocks);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geoipBlocksLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geoipBlocksLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geoipBlocksLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void truncateTable() {
		_geoipBlocksLocalService.truncateTable();
	}

	@Override
	public long getGeonameId(long startId, long endId) {
		return _geoipBlocksLocalService.getGeonameId(startId, endId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeoipBlocksLocalService getWrappedGeoipBlocksLocalService() {
		return _geoipBlocksLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeoipBlocksLocalService(
		GeoipBlocksLocalService geoipBlocksLocalService) {
		_geoipBlocksLocalService = geoipBlocksLocalService;
	}

	@Override
	public GeoipBlocksLocalService getWrappedService() {
		return _geoipBlocksLocalService;
	}

	@Override
	public void setWrappedService(
		GeoipBlocksLocalService geoipBlocksLocalService) {
		_geoipBlocksLocalService = geoipBlocksLocalService;
	}

	private GeoipBlocksLocalService _geoipBlocksLocalService;
}