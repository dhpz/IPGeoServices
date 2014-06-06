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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rivetlogic.geoip.service.http.GeoipLocationsServiceSoap}.
 *
 * @author charles.rodriguez
 * @see com.rivetlogic.geoip.service.http.GeoipLocationsServiceSoap
 * @generated
 */
public class GeoipLocationsSoap implements Serializable {
	public static GeoipLocationsSoap toSoapModel(GeoipLocations model) {
		GeoipLocationsSoap soapModel = new GeoipLocationsSoap();

		soapModel.setGeonameId(model.getGeonameId());
		soapModel.setCountryIsoCode(model.getCountryIsoCode());

		return soapModel;
	}

	public static GeoipLocationsSoap[] toSoapModels(GeoipLocations[] models) {
		GeoipLocationsSoap[] soapModels = new GeoipLocationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeoipLocationsSoap[][] toSoapModels(GeoipLocations[][] models) {
		GeoipLocationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeoipLocationsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeoipLocationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeoipLocationsSoap[] toSoapModels(List<GeoipLocations> models) {
		List<GeoipLocationsSoap> soapModels = new ArrayList<GeoipLocationsSoap>(models.size());

		for (GeoipLocations model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeoipLocationsSoap[soapModels.size()]);
	}

	public GeoipLocationsSoap() {
	}

	public long getPrimaryKey() {
		return _geonameId;
	}

	public void setPrimaryKey(long pk) {
		setGeonameId(pk);
	}

	public long getGeonameId() {
		return _geonameId;
	}

	public void setGeonameId(long geonameId) {
		_geonameId = geonameId;
	}

	public String getCountryIsoCode() {
		return _countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		_countryIsoCode = countryIsoCode;
	}

	private long _geonameId;
	private String _countryIsoCode;
}