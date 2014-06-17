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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rivetlogic.geo.service.ClpSerializer;
import com.rivetlogic.geo.service.GeoBlocksLocalServiceUtil;
import com.rivetlogic.geo.service.persistence.GeoBlocksPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author charles.rodriguez
 */
public class GeoBlocksClp extends BaseModelImpl<GeoBlocks> implements GeoBlocks {
	public GeoBlocksClp() {
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
	public GeoBlocksPK getPrimaryKey() {
		return new GeoBlocksPK(_geonameId, _startIp);
	}

	@Override
	public void setPrimaryKey(GeoBlocksPK primaryKey) {
		setGeonameId(primaryKey.geonameId);
		setStartIp(primaryKey.startIp);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new GeoBlocksPK(_geonameId, _startIp);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((GeoBlocksPK)primaryKeyObj);
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

	@Override
	public long getGeonameId() {
		return _geonameId;
	}

	@Override
	public void setGeonameId(long geonameId) {
		_geonameId = geonameId;

		if (_geoBlocksRemoteModel != null) {
			try {
				Class<?> clazz = _geoBlocksRemoteModel.getClass();

				Method method = clazz.getMethod("setGeonameId", long.class);

				method.invoke(_geoBlocksRemoteModel, geonameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStartIp() {
		return _startIp;
	}

	@Override
	public void setStartIp(long startIp) {
		_startIp = startIp;

		if (_geoBlocksRemoteModel != null) {
			try {
				Class<?> clazz = _geoBlocksRemoteModel.getClass();

				Method method = clazz.getMethod("setStartIp", long.class);

				method.invoke(_geoBlocksRemoteModel, startIp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEndIp() {
		return _endIp;
	}

	@Override
	public void setEndIp(long endIp) {
		_endIp = endIp;

		if (_geoBlocksRemoteModel != null) {
			try {
				Class<?> clazz = _geoBlocksRemoteModel.getClass();

				Method method = clazz.getMethod("setEndIp", long.class);

				method.invoke(_geoBlocksRemoteModel, endIp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeoBlocksRemoteModel() {
		return _geoBlocksRemoteModel;
	}

	public void setGeoBlocksRemoteModel(BaseModel<?> geoBlocksRemoteModel) {
		_geoBlocksRemoteModel = geoBlocksRemoteModel;
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

		Class<?> remoteModelClass = _geoBlocksRemoteModel.getClass();

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

		Object returnValue = method.invoke(_geoBlocksRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeoBlocksLocalServiceUtil.addGeoBlocks(this);
		}
		else {
			GeoBlocksLocalServiceUtil.updateGeoBlocks(this);
		}
	}

	@Override
	public GeoBlocks toEscapedModel() {
		return (GeoBlocks)ProxyUtil.newProxyInstance(GeoBlocks.class.getClassLoader(),
			new Class[] { GeoBlocks.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeoBlocksClp clone = new GeoBlocksClp();

		clone.setGeonameId(getGeonameId());
		clone.setStartIp(getStartIp());
		clone.setEndIp(getEndIp());

		return clone;
	}

	@Override
	public int compareTo(GeoBlocks geoBlocks) {
		GeoBlocksPK primaryKey = geoBlocks.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoBlocksClp)) {
			return false;
		}

		GeoBlocksClp geoBlocks = (GeoBlocksClp)obj;

		GeoBlocksPK primaryKey = geoBlocks.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{geonameId=");
		sb.append(getGeonameId());
		sb.append(", startIp=");
		sb.append(getStartIp());
		sb.append(", endIp=");
		sb.append(getEndIp());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.geo.model.GeoBlocks");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>geonameId</column-name><column-value><![CDATA[");
		sb.append(getGeonameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startIp</column-name><column-value><![CDATA[");
		sb.append(getStartIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endIp</column-name><column-value><![CDATA[");
		sb.append(getEndIp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _geonameId;
	private long _startIp;
	private long _endIp;
	private BaseModel<?> _geoBlocksRemoteModel;
}