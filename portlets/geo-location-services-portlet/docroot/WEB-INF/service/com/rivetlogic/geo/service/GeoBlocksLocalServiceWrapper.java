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

package com.rivetlogic.geo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeoBlocksLocalService}.
 *
 * @author charles.rodriguez
 * @see GeoBlocksLocalService
 * @generated
 */
public class GeoBlocksLocalServiceWrapper implements GeoBlocksLocalService,
	ServiceWrapper<GeoBlocksLocalService> {
	public GeoBlocksLocalServiceWrapper(
		GeoBlocksLocalService geoBlocksLocalService) {
		_geoBlocksLocalService = geoBlocksLocalService;
	}

	/**
	* Adds the geo blocks to the database. Also notifies the appropriate model listeners.
	*
	* @param geoBlocks the geo blocks
	* @return the geo blocks that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoBlocks addGeoBlocks(
		com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.addGeoBlocks(geoBlocks);
	}

	/**
	* Creates a new geo blocks with the primary key. Does not add the geo blocks to the database.
	*
	* @param geoBlocksPK the primary key for the new geo blocks
	* @return the new geo blocks
	*/
	@Override
	public com.rivetlogic.geo.model.GeoBlocks createGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK) {
		return _geoBlocksLocalService.createGeoBlocks(geoBlocksPK);
	}

	/**
	* Deletes the geo blocks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geoBlocksPK the primary key of the geo blocks
	* @return the geo blocks that was removed
	* @throws PortalException if a geo blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoBlocks deleteGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.deleteGeoBlocks(geoBlocksPK);
	}

	/**
	* Deletes the geo blocks from the database. Also notifies the appropriate model listeners.
	*
	* @param geoBlocks the geo blocks
	* @return the geo blocks that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoBlocks deleteGeoBlocks(
		com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.deleteGeoBlocks(geoBlocks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geoBlocksLocalService.dynamicQuery();
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
		return _geoBlocksLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _geoBlocksLocalService.dynamicQueryCount(dynamicQuery);
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
		return _geoBlocksLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rivetlogic.geo.model.GeoBlocks fetchGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.fetchGeoBlocks(geoBlocksPK);
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
	public com.rivetlogic.geo.model.GeoBlocks getGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.getGeoBlocks(geoBlocksPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rivetlogic.geo.model.GeoBlocks> getGeoBlockses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.getGeoBlockses(start, end);
	}

	/**
	* Returns the number of geo blockses.
	*
	* @return the number of geo blockses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeoBlocksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.getGeoBlocksesCount();
	}

	/**
	* Updates the geo blocks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geoBlocks the geo blocks
	* @return the geo blocks that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.geo.model.GeoBlocks updateGeoBlocks(
		com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geoBlocksLocalService.updateGeoBlocks(geoBlocks);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geoBlocksLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geoBlocksLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geoBlocksLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rivetlogic.geo.model.GeoBlocks addGeoipBlocks(
		com.rivetlogic.geo.model.GeoBlocks newBlocks) {
		return _geoBlocksLocalService.addGeoipBlocks(newBlocks);
	}

	@Override
	public void truncateTable() {
		_geoBlocksLocalService.truncateTable();
	}

	@Override
	public long getGeonameId(long startId, long endId) {
		return _geoBlocksLocalService.getGeonameId(startId, endId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeoBlocksLocalService getWrappedGeoBlocksLocalService() {
		return _geoBlocksLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeoBlocksLocalService(
		GeoBlocksLocalService geoBlocksLocalService) {
		_geoBlocksLocalService = geoBlocksLocalService;
	}

	@Override
	public GeoBlocksLocalService getWrappedService() {
		return _geoBlocksLocalService;
	}

	@Override
	public void setWrappedService(GeoBlocksLocalService geoBlocksLocalService) {
		_geoBlocksLocalService = geoBlocksLocalService;
	}

	private GeoBlocksLocalService _geoBlocksLocalService;
}