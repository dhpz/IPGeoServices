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

import com.rivetlogic.geoip.service.persistence.GeoipBlocksPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author charles.rodriguez
 * @generated
 */
public class GeoipBlocksSoap implements Serializable {
	public static GeoipBlocksSoap toSoapModel(GeoipBlocks model) {
		GeoipBlocksSoap soapModel = new GeoipBlocksSoap();

		soapModel.setGeonameId(model.getGeonameId());
		soapModel.setStartIp(model.getStartIp());
		soapModel.setEndIp(model.getEndIp());

		return soapModel;
	}

	public static GeoipBlocksSoap[] toSoapModels(GeoipBlocks[] models) {
		GeoipBlocksSoap[] soapModels = new GeoipBlocksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeoipBlocksSoap[][] toSoapModels(GeoipBlocks[][] models) {
		GeoipBlocksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeoipBlocksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeoipBlocksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeoipBlocksSoap[] toSoapModels(List<GeoipBlocks> models) {
		List<GeoipBlocksSoap> soapModels = new ArrayList<GeoipBlocksSoap>(models.size());

		for (GeoipBlocks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeoipBlocksSoap[soapModels.size()]);
	}

	public GeoipBlocksSoap() {
	}

	public GeoipBlocksPK getPrimaryKey() {
		return new GeoipBlocksPK(_geonameId, _startIp);
	}

	public void setPrimaryKey(GeoipBlocksPK pk) {
		setGeonameId(pk.geonameId);
		setStartIp(pk.startIp);
	}

	public long getGeonameId() {
		return _geonameId;
	}

	public void setGeonameId(long geonameId) {
		_geonameId = geonameId;
	}

	public long getStartIp() {
		return _startIp;
	}

	public void setStartIp(long startIp) {
		_startIp = startIp;
	}

	public long getEndIp() {
		return _endIp;
	}

	public void setEndIp(long endIp) {
		_endIp = endIp;
	}

	private long _geonameId;
	private long _startIp;
	private long _endIp;
}