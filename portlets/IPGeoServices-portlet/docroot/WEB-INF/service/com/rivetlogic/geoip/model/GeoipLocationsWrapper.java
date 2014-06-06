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
 * This class is a wrapper for {@link GeoipLocations}.
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipLocations
 * @generated
 */
public class GeoipLocationsWrapper implements GeoipLocations,
	ModelWrapper<GeoipLocations> {
	public GeoipLocationsWrapper(GeoipLocations geoipLocations) {
		_geoipLocations = geoipLocations;
	}

	@Override
	public Class<?> getModelClass() {
		return GeoipLocations.class;
	}

	@Override
	public String getModelClassName() {
		return GeoipLocations.class.getName();
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
	* Returns the primary key of this geoip locations.
	*
	* @return the primary key of this geoip locations
	*/
	@Override
	public long getPrimaryKey() {
		return _geoipLocations.getPrimaryKey();
	}

	/**
	* Sets the primary key of this geoip locations.
	*
	* @param primaryKey the primary key of this geoip locations
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geoipLocations.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the geoname ID of this geoip locations.
	*
	* @return the geoname ID of this geoip locations
	*/
	@Override
	public long getGeonameId() {
		return _geoipLocations.getGeonameId();
	}

	/**
	* Sets the geoname ID of this geoip locations.
	*
	* @param geonameId the geoname ID of this geoip locations
	*/
	@Override
	public void setGeonameId(long geonameId) {
		_geoipLocations.setGeonameId(geonameId);
	}

	/**
	* Returns the country iso code of this geoip locations.
	*
	* @return the country iso code of this geoip locations
	*/
	@Override
	public java.lang.String getCountryIsoCode() {
		return _geoipLocations.getCountryIsoCode();
	}

	/**
	* Sets the country iso code of this geoip locations.
	*
	* @param countryIsoCode the country iso code of this geoip locations
	*/
	@Override
	public void setCountryIsoCode(java.lang.String countryIsoCode) {
		_geoipLocations.setCountryIsoCode(countryIsoCode);
	}

	@Override
	public boolean isNew() {
		return _geoipLocations.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geoipLocations.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geoipLocations.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geoipLocations.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geoipLocations.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geoipLocations.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geoipLocations.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geoipLocations.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geoipLocations.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geoipLocations.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geoipLocations.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeoipLocationsWrapper((GeoipLocations)_geoipLocations.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.geoip.model.GeoipLocations geoipLocations) {
		return _geoipLocations.compareTo(geoipLocations);
	}

	@Override
	public int hashCode() {
		return _geoipLocations.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.geoip.model.GeoipLocations> toCacheModel() {
		return _geoipLocations.toCacheModel();
	}

	@Override
	public com.rivetlogic.geoip.model.GeoipLocations toEscapedModel() {
		return new GeoipLocationsWrapper(_geoipLocations.toEscapedModel());
	}

	@Override
	public com.rivetlogic.geoip.model.GeoipLocations toUnescapedModel() {
		return new GeoipLocationsWrapper(_geoipLocations.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geoipLocations.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geoipLocations.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geoipLocations.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoipLocationsWrapper)) {
			return false;
		}

		GeoipLocationsWrapper geoipLocationsWrapper = (GeoipLocationsWrapper)obj;

		if (Validator.equals(_geoipLocations,
					geoipLocationsWrapper._geoipLocations)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeoipLocations getWrappedGeoipLocations() {
		return _geoipLocations;
	}

	@Override
	public GeoipLocations getWrappedModel() {
		return _geoipLocations;
	}

	@Override
	public void resetOriginalValues() {
		_geoipLocations.resetOriginalValues();
	}

	private GeoipLocations _geoipLocations;
}