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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rivetlogic.geoip.service.ClpSerializer;
import com.rivetlogic.geoip.service.GeoipLocationsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author charles.rodriguez
 */
public class GeoipLocationsClp extends BaseModelImpl<GeoipLocations>
	implements GeoipLocations {
	public GeoipLocationsClp() {
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
	public long getPrimaryKey() {
		return _geonameId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGeonameId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _geonameId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getGeonameId() {
		return _geonameId;
	}

	@Override
	public void setGeonameId(long geonameId) {
		_geonameId = geonameId;

		if (_geoipLocationsRemoteModel != null) {
			try {
				Class<?> clazz = _geoipLocationsRemoteModel.getClass();

				Method method = clazz.getMethod("setGeonameId", long.class);

				method.invoke(_geoipLocationsRemoteModel, geonameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryIsoCode() {
		return _countryIsoCode;
	}

	@Override
	public void setCountryIsoCode(String countryIsoCode) {
		_countryIsoCode = countryIsoCode;

		if (_geoipLocationsRemoteModel != null) {
			try {
				Class<?> clazz = _geoipLocationsRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryIsoCode",
						String.class);

				method.invoke(_geoipLocationsRemoteModel, countryIsoCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeoipLocationsRemoteModel() {
		return _geoipLocationsRemoteModel;
	}

	public void setGeoipLocationsRemoteModel(
		BaseModel<?> geoipLocationsRemoteModel) {
		_geoipLocationsRemoteModel = geoipLocationsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _geoipLocationsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_geoipLocationsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeoipLocationsLocalServiceUtil.addGeoipLocations(this);
		}
		else {
			GeoipLocationsLocalServiceUtil.updateGeoipLocations(this);
		}
	}

	@Override
	public GeoipLocations toEscapedModel() {
		return (GeoipLocations)ProxyUtil.newProxyInstance(GeoipLocations.class.getClassLoader(),
			new Class[] { GeoipLocations.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeoipLocationsClp clone = new GeoipLocationsClp();

		clone.setGeonameId(getGeonameId());
		clone.setCountryIsoCode(getCountryIsoCode());

		return clone;
	}

	@Override
	public int compareTo(GeoipLocations geoipLocations) {
		long primaryKey = geoipLocations.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoipLocationsClp)) {
			return false;
		}

		GeoipLocationsClp geoipLocations = (GeoipLocationsClp)obj;

		long primaryKey = geoipLocations.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{geonameId=");
		sb.append(getGeonameId());
		sb.append(", countryIsoCode=");
		sb.append(getCountryIsoCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.geoip.model.GeoipLocations");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>geonameId</column-name><column-value><![CDATA[");
		sb.append(getGeonameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryIsoCode</column-name><column-value><![CDATA[");
		sb.append(getCountryIsoCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _geonameId;
	private String _countryIsoCode;
	private BaseModel<?> _geoipLocationsRemoteModel;
}