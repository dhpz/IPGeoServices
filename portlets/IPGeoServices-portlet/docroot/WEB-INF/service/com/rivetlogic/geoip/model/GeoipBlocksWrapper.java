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

package com.rivetlogic.geoip.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GeoipBlocks}.
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipBlocks
 * @generated
 */
public class GeoipBlocksWrapper implements GeoipBlocks,
	ModelWrapper<GeoipBlocks> {
	public GeoipBlocksWrapper(GeoipBlocks geoipBlocks) {
		_geoipBlocks = geoipBlocks;
	}

	@Override
	public Class<?> getModelClass() {
		return GeoipBlocks.class;
	}

	@Override
	public String getModelClassName() {
		return GeoipBlocks.class.getName();
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
	* Returns the primary key of this geoip blocks.
	*
	* @return the primary key of this geoip blocks
	*/
	@Override
	public com.rivetlogic.geoip.service.persistence.GeoipBlocksPK getPrimaryKey() {
		return _geoipBlocks.getPrimaryKey();
	}

	/**
	* Sets the primary key of this geoip blocks.
	*
	* @param primaryKey the primary key of this geoip blocks
	*/
	@Override
	public void setPrimaryKey(
		com.rivetlogic.geoip.service.persistence.GeoipBlocksPK primaryKey) {
		_geoipBlocks.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the geoname ID of this geoip blocks.
	*
	* @return the geoname ID of this geoip blocks
	*/
	@Override
	public long getGeonameId() {
		return _geoipBlocks.getGeonameId();
	}

	/**
	* Sets the geoname ID of this geoip blocks.
	*
	* @param geonameId the geoname ID of this geoip blocks
	*/
	@Override
	public void setGeonameId(long geonameId) {
		_geoipBlocks.setGeonameId(geonameId);
	}

	/**
	* Returns the start ip of this geoip blocks.
	*
	* @return the start ip of this geoip blocks
	*/
	@Override
	public long getStartIp() {
		return _geoipBlocks.getStartIp();
	}

	/**
	* Sets the start ip of this geoip blocks.
	*
	* @param startIp the start ip of this geoip blocks
	*/
	@Override
	public void setStartIp(long startIp) {
		_geoipBlocks.setStartIp(startIp);
	}

	/**
	* Returns the end ip of this geoip blocks.
	*
	* @return the end ip of this geoip blocks
	*/
	@Override
	public long getEndIp() {
		return _geoipBlocks.getEndIp();
	}

	/**
	* Sets the end ip of this geoip blocks.
	*
	* @param endIp the end ip of this geoip blocks
	*/
	@Override
	public void setEndIp(long endIp) {
		_geoipBlocks.setEndIp(endIp);
	}

	@Override
	public boolean isNew() {
		return _geoipBlocks.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geoipBlocks.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geoipBlocks.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geoipBlocks.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geoipBlocks.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geoipBlocks.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geoipBlocks.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geoipBlocks.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geoipBlocks.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geoipBlocks.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geoipBlocks.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeoipBlocksWrapper((GeoipBlocks)_geoipBlocks.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.geoip.model.GeoipBlocks geoipBlocks) {
		return _geoipBlocks.compareTo(geoipBlocks);
	}

	@Override
	public int hashCode() {
		return _geoipBlocks.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.geoip.model.GeoipBlocks> toCacheModel() {
		return _geoipBlocks.toCacheModel();
	}

	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks toEscapedModel() {
		return new GeoipBlocksWrapper(_geoipBlocks.toEscapedModel());
	}

	@Override
	public com.rivetlogic.geoip.model.GeoipBlocks toUnescapedModel() {
		return new GeoipBlocksWrapper(_geoipBlocks.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geoipBlocks.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geoipBlocks.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geoipBlocks.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoipBlocksWrapper)) {
			return false;
		}

		GeoipBlocksWrapper geoipBlocksWrapper = (GeoipBlocksWrapper)obj;

		if (Validator.equals(_geoipBlocks, geoipBlocksWrapper._geoipBlocks)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeoipBlocks getWrappedGeoipBlocks() {
		return _geoipBlocks;
	}

	@Override
	public GeoipBlocks getWrappedModel() {
		return _geoipBlocks;
	}

	@Override
	public void resetOriginalValues() {
		_geoipBlocks.resetOriginalValues();
	}

	private GeoipBlocks _geoipBlocks;
}