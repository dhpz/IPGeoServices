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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GeoBlocks. This utility wraps
 * {@link com.rivetlogic.geo.service.impl.GeoBlocksLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author charles.rodriguez
 * @see GeoBlocksLocalService
 * @see com.rivetlogic.geo.service.base.GeoBlocksLocalServiceBaseImpl
 * @see com.rivetlogic.geo.service.impl.GeoBlocksLocalServiceImpl
 * @generated
 */
public class GeoBlocksLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.geo.service.impl.GeoBlocksLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the geo blocks to the database. Also notifies the appropriate model listeners.
	*
	* @param geoBlocks the geo blocks
	* @return the geo blocks that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks addGeoBlocks(
		com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGeoBlocks(geoBlocks);
	}

	/**
	* Creates a new geo blocks with the primary key. Does not add the geo blocks to the database.
	*
	* @param geoBlocksPK the primary key for the new geo blocks
	* @return the new geo blocks
	*/
	public static com.rivetlogic.geo.model.GeoBlocks createGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK) {
		return getService().createGeoBlocks(geoBlocksPK);
	}

	/**
	* Deletes the geo blocks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geoBlocksPK the primary key of the geo blocks
	* @return the geo blocks that was removed
	* @throws PortalException if a geo blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks deleteGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGeoBlocks(geoBlocksPK);
	}

	/**
	* Deletes the geo blocks from the database. Also notifies the appropriate model listeners.
	*
	* @param geoBlocks the geo blocks
	* @return the geo blocks that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks deleteGeoBlocks(
		com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGeoBlocks(geoBlocks);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rivetlogic.geo.model.GeoBlocks fetchGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGeoBlocks(geoBlocksPK);
	}

	/**
	* Returns the geo blocks with the primary key.
	*
	* @param geoBlocksPK the primary key of the geo blocks
	* @return the geo blocks
	* @throws PortalException if a geo blocks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks getGeoBlocks(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK geoBlocksPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeoBlocks(geoBlocksPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rivetlogic.geo.model.GeoBlocks> getGeoBlockses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeoBlockses(start, end);
	}

	/**
	* Returns the number of geo blockses.
	*
	* @return the number of geo blockses
	* @throws SystemException if a system exception occurred
	*/
	public static int getGeoBlocksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeoBlocksesCount();
	}

	/**
	* Updates the geo blocks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geoBlocks the geo blocks
	* @return the geo blocks that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.geo.model.GeoBlocks updateGeoBlocks(
		com.rivetlogic.geo.model.GeoBlocks geoBlocks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGeoBlocks(geoBlocks);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.rivetlogic.geo.model.GeoBlocks addGeoipBlocks(
		com.rivetlogic.geo.model.GeoBlocks newBlocks) {
		return getService().addGeoipBlocks(newBlocks);
	}

	public static void truncateTable() {
		getService().truncateTable();
	}

	public static long getGeonameId(long startId, long endId) {
		return getService().getGeonameId(startId, endId);
	}

	public static void clearService() {
		_service = null;
	}

	public static GeoBlocksLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GeoBlocksLocalService.class.getName());

			if (invokableLocalService instanceof GeoBlocksLocalService) {
				_service = (GeoBlocksLocalService)invokableLocalService;
			}
			else {
				_service = new GeoBlocksLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GeoBlocksLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GeoBlocksLocalService service) {
	}

	private static GeoBlocksLocalService _service;
}