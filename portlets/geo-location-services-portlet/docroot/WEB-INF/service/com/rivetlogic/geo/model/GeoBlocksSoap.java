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

import com.rivetlogic.geo.service.persistence.GeoBlocksPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author charles.rodriguez
 * @generated
 */
public class GeoBlocksSoap implements Serializable {
	public static GeoBlocksSoap toSoapModel(GeoBlocks model) {
		GeoBlocksSoap soapModel = new GeoBlocksSoap();

		soapModel.setGeonameId(model.getGeonameId());
		soapModel.setStartIp(model.getStartIp());
		soapModel.setEndIp(model.getEndIp());

		return soapModel;
	}

	public static GeoBlocksSoap[] toSoapModels(GeoBlocks[] models) {
		GeoBlocksSoap[] soapModels = new GeoBlocksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeoBlocksSoap[][] toSoapModels(GeoBlocks[][] models) {
		GeoBlocksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeoBlocksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeoBlocksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeoBlocksSoap[] toSoapModels(List<GeoBlocks> models) {
		List<GeoBlocksSoap> soapModels = new ArrayList<GeoBlocksSoap>(models.size());

		for (GeoBlocks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeoBlocksSoap[soapModels.size()]);
	}

	public GeoBlocksSoap() {
	}

	public GeoBlocksPK getPrimaryKey() {
		return new GeoBlocksPK(_geonameId, _startIp);
	}

	public void setPrimaryKey(GeoBlocksPK pk) {
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