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
 * This class is a wrapper for {@link GeoLocations}.
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoLocations
 * @generated
 */
public class GeoLocationsWrapper implements GeoLocations,
	ModelWrapper<GeoLocations> {
	public GeoLocationsWrapper(GeoLocations geoLocations) {
		_geoLocations = geoLocations;
	}

	@Override
	public Class<?> getModelClass() {
		return GeoLocations.class;
	}

	@Override
	public String getModelClassName() {
		return GeoLocations.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("geonameId", getGeonameId());
		attributes.put("countryIsoCode", getCountryIsoCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long geonameId = (Long)attributes.get("geonameId");

		if (geonameId != null) {
			setGeonameId(geonameId);
		}

		String countryIsoCode = (String)attributes.get("countryIsoCode");

		if (countryIsoCode != null) {
			setCountryIsoCode(countryIsoCode);
		}
	}

	/**
	* Returns the primary key of this geo locations.
	*
	* @return the primary key of this geo locations
	*/
	@Override
	public long getPrimaryKey() {
		return _geoLocations.getPrimaryKey();
	}

	/**
	* Sets the primary key of this geo locations.
	*
	* @param primaryKey the primary key of this geo locations
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geoLocations.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the geoname ID of this geo locations.
	*
	* @return the geoname ID of this geo locations
	*/
	@Override
	public long getGeonameId() {
		return _geoLocations.getGeonameId();
	}

	/**
	* Sets the geoname ID of this geo locations.
	*
	* @param geonameId the geoname ID of this geo locations
	*/
	@Override
	public void setGeonameId(long geonameId) {
		_geoLocations.setGeonameId(geonameId);
	}

	/**
	* Returns the country iso code of this geo locations.
	*
	* @return the country iso code of this geo locations
	*/
	@Override
	public java.lang.String getCountryIsoCode() {
		return _geoLocations.getCountryIsoCode();
	}

	/**
	* Sets the country iso code of this geo locations.
	*
	* @param countryIsoCode the country iso code of this geo locations
	*/
	@Override
	public void setCountryIsoCode(java.lang.String countryIsoCode) {
		_geoLocations.setCountryIsoCode(countryIsoCode);
	}

	@Override
	public boolean isNew() {
		return _geoLocations.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geoLocations.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geoLocations.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geoLocations.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geoLocations.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geoLocations.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geoLocations.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geoLocations.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geoLocations.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geoLocations.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geoLocations.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeoLocationsWrapper((GeoLocations)_geoLocations.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.geo.model.GeoLocations geoLocations) {
		return _geoLocations.compareTo(geoLocations);
	}

	@Override
	public int hashCode() {
		return _geoLocations.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.geo.model.GeoLocations> toCacheModel() {
		return _geoLocations.toCacheModel();
	}

	@Override
	public com.rivetlogic.geo.model.GeoLocations toEscapedModel() {
		return new GeoLocationsWrapper(_geoLocations.toEscapedModel());
	}

	@Override
	public com.rivetlogic.geo.model.GeoLocations toUnescapedModel() {
		return new GeoLocationsWrapper(_geoLocations.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geoLocations.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geoLocations.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geoLocations.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoLocationsWrapper)) {
			return false;
		}

		GeoLocationsWrapper geoLocationsWrapper = (GeoLocationsWrapper)obj;

		if (Validator.equals(_geoLocations, geoLocationsWrapper._geoLocations)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeoLocations getWrappedGeoLocations() {
		return _geoLocations;
	}

	@Override
	public GeoLocations getWrappedModel() {
		return _geoLocations;
	}

	@Override
	public void resetOriginalValues() {
		_geoLocations.resetOriginalValues();
	}

	private GeoLocations _geoLocations;
}