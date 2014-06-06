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
import com.rivetlogic.geoip.service.GeoipBlocksLocalServiceUtil;
import com.rivetlogic.geoip.service.persistence.GeoipBlocksPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author charles.rodriguez
 */
public class GeoipBlocksClp extends BaseModelImpl<GeoipBlocks>
	implements GeoipBlocks {
	public GeoipBlocksClp() {
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
	public GeoipBlocksPK getPrimaryKey() {
		return new GeoipBlocksPK(_geonameId, _startIp);
	}

	@Override
	public void setPrimaryKey(GeoipBlocksPK primaryKey) {
		setGeonameId(primaryKey.geonameId);
		setStartIp(primaryKey.startIp);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new GeoipBlocksPK(_geonameId, _startIp);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((GeoipBlocksPK)primaryKeyObj);
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

		if (_geoipBlocksRemoteModel != null) {
			try {
				Class<?> clazz = _geoipBlocksRemoteModel.getClass();

				Method method = clazz.getMethod("setGeonameId", long.class);

				method.invoke(_geoipBlocksRemoteModel, geonameId);
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

		if (_geoipBlocksRemoteModel != null) {
			try {
				Class<?> clazz = _geoipBlocksRemoteModel.getClass();

				Method method = clazz.getMethod("setStartIp", long.class);

				method.invoke(_geoipBlocksRemoteModel, startIp);
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

		if (_geoipBlocksRemoteModel != null) {
			try {
				Class<?> clazz = _geoipBlocksRemoteModel.getClass();

				Method method = clazz.getMethod("setEndIp", long.class);

				method.invoke(_geoipBlocksRemoteModel, endIp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeoipBlocksRemoteModel() {
		return _geoipBlocksRemoteModel;
	}

	public void setGeoipBlocksRemoteModel(BaseModel<?> geoipBlocksRemoteModel) {
		_geoipBlocksRemoteModel = geoipBlocksRemoteModel;
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

		Class<?> remoteModelClass = _geoipBlocksRemoteModel.getClass();

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

		Object returnValue = method.invoke(_geoipBlocksRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeoipBlocksLocalServiceUtil.addGeoipBlocks(this);
		}
		else {
			GeoipBlocksLocalServiceUtil.updateGeoipBlocks(this);
		}
	}

	@Override
	public GeoipBlocks toEscapedModel() {
		return (GeoipBlocks)ProxyUtil.newProxyInstance(GeoipBlocks.class.getClassLoader(),
			new Class[] { GeoipBlocks.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeoipBlocksClp clone = new GeoipBlocksClp();

		clone.setGeonameId(getGeonameId());
		clone.setStartIp(getStartIp());
		clone.setEndIp(getEndIp());

		return clone;
	}

	@Override
	public int compareTo(GeoipBlocks geoipBlocks) {
		GeoipBlocksPK primaryKey = geoipBlocks.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoipBlocksClp)) {
			return false;
		}

		GeoipBlocksClp geoipBlocks = (GeoipBlocksClp)obj;

		GeoipBlocksPK primaryKey = geoipBlocks.getPrimaryKey();

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
		sb.append("com.rivetlogic.geoip.model.GeoipBlocks");
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
	private BaseModel<?> _geoipBlocksRemoteModel;
}