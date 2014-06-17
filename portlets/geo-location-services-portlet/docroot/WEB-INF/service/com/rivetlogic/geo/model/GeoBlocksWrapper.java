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

package com.rivetlogic.geo.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GeoBlocks}.
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoBlocks
 * @generated
 */
public class GeoBlocksWrapper implements GeoBlocks, ModelWrapper<GeoBlocks> {
	public GeoBlocksWrapper(GeoBlocks geoBlocks) {
		_geoBlocks = geoBlocks;
	}

	@Override
	public Class<?> getModelClass() {
		return GeoBlocks.class;
	}

	@Override
	public String getModelClassName() {
		return GeoBlocks.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("geonameId", getGeonameId());
		attributes.put("startIp", getStartIp());
		attributes.put("endIp", getEndIp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long geonameId = (Long)attributes.get("geonameId");

		if (geonameId != null) {
			setGeonameId(geonameId);
		}

		Long startIp = (Long)attributes.get("startIp");

		if (startIp != null) {
			setStartIp(startIp);
		}

		Long endIp = (Long)attributes.get("endIp");

		if (endIp != null) {
			setEndIp(endIp);
		}
	}

	/**
	* Returns the primary key of this geo blocks.
	*
	* @return the primary key of this geo blocks
	*/
	@Override
	public com.rivetlogic.geo.service.persistence.GeoBlocksPK getPrimaryKey() {
		return _geoBlocks.getPrimaryKey();
	}

	/**
	* Sets the primary key of this geo blocks.
	*
	* @param primaryKey the primary key of this geo blocks
	*/
	@Override
	public void setPrimaryKey(
		com.rivetlogic.geo.service.persistence.GeoBlocksPK primaryKey) {
		_geoBlocks.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the geoname ID of this geo blocks.
	*
	* @return the geoname ID of this geo blocks
	*/
	@Override
	public long getGeonameId() {
		return _geoBlocks.getGeonameId();
	}

	/**
	* Sets the geoname ID of this geo blocks.
	*
	* @param geonameId the geoname ID of this geo blocks
	*/
	@Override
	public void setGeonameId(long geonameId) {
		_geoBlocks.setGeonameId(geonameId);
	}

	/**
	* Returns the start ip of this geo blocks.
	*
	* @return the start ip of this geo blocks
	*/
	@Override
	public long getStartIp() {
		return _geoBlocks.getStartIp();
	}

	/**
	* Sets the start ip of this geo blocks.
	*
	* @param startIp the start ip of this geo blocks
	*/
	@Override
	public void setStartIp(long startIp) {
		_geoBlocks.setStartIp(startIp);
	}

	/**
	* Returns the end ip of this geo blocks.
	*
	* @return the end ip of this geo blocks
	*/
	@Override
	public long getEndIp() {
		return _geoBlocks.getEndIp();
	}

	/**
	* Sets the end ip of this geo blocks.
	*
	* @param endIp the end ip of this geo blocks
	*/
	@Override
	public void setEndIp(long endIp) {
		_geoBlocks.setEndIp(endIp);
	}

	@Override
	public boolean isNew() {
		return _geoBlocks.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geoBlocks.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geoBlocks.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geoBlocks.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geoBlocks.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geoBlocks.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geoBlocks.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geoBlocks.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geoBlocks.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geoBlocks.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geoBlocks.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeoBlocksWrapper((GeoBlocks)_geoBlocks.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.geo.model.GeoBlocks geoBlocks) {
		return _geoBlocks.compareTo(geoBlocks);
	}

	@Override
	public int hashCode() {
		return _geoBlocks.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.geo.model.GeoBlocks> toCacheModel() {
		return _geoBlocks.toCacheModel();
	}

	@Override
	public com.rivetlogic.geo.model.GeoBlocks toEscapedModel() {
		return new GeoBlocksWrapper(_geoBlocks.toEscapedModel());
	}

	@Override
	public com.rivetlogic.geo.model.GeoBlocks toUnescapedModel() {
		return new GeoBlocksWrapper(_geoBlocks.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geoBlocks.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geoBlocks.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geoBlocks.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoBlocksWrapper)) {
			return false;
		}

		GeoBlocksWrapper geoBlocksWrapper = (GeoBlocksWrapper)obj;

		if (Validator.equals(_geoBlocks, geoBlocksWrapper._geoBlocks)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeoBlocks getWrappedGeoBlocks() {
		return _geoBlocks;
	}

	@Override
	public GeoBlocks getWrappedModel() {
		return _geoBlocks;
	}

	@Override
	public void resetOriginalValues() {
		_geoBlocks.resetOriginalValues();
	}

	private GeoBlocks _geoBlocks;
}