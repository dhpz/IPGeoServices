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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the GeoipLocations service. Represents a row in the &quot;rivetlogic_geoip_GeoipLocations&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rivetlogic.geoip.model.impl.GeoipLocationsImpl}.
 * </p>
 *
 * @author charles.rodriguez
 * @see GeoipLocations
 * @see com.rivetlogic.geoip.model.impl.GeoipLocationsImpl
 * @see com.rivetlogic.geoip.model.impl.GeoipLocationsModelImpl
 * @generated
 */
public interface GeoipLocationsModel extends BaseModel<GeoipLocations> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a geoip locations model instance should use the {@link GeoipLocations} interface instead.
	 */

	/**
	 * Returns the primary key of this geoip locations.
	 *
	 * @return the primary key of this geoip locations
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this geoip locations.
	 *
	 * @param primaryKey the primary key of this geoip locations
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the geoname ID of this geoip locations.
	 *
	 * @return the geoname ID of this geoip locations
	 */
	public long getGeonameId();

	/**
	 * Sets the geoname ID of this geoip locations.
	 *
	 * @param geonameId the geoname ID of this geoip locations
	 */
	public void setGeonameId(long geonameId);

	/**
	 * Returns the country iso code of this geoip locations.
	 *
	 * @return the country iso code of this geoip locations
	 */
	@AutoEscape
	public String getCountryIsoCode();

	/**
	 * Sets the country iso code of this geoip locations.
	 *
	 * @param countryIsoCode the country iso code of this geoip locations
	 */
	public void setCountryIsoCode(String countryIsoCode);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(GeoipLocations geoipLocations);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GeoipLocations> toCacheModel();

	@Override
	public GeoipLocations toEscapedModel();

	@Override
	public GeoipLocations toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}