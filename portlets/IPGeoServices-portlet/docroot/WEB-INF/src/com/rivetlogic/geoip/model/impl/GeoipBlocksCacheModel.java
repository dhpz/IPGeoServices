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

package com.rivetlogic.geoip.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.geoip.model.GeoipBlocks;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GeoipBlocks in entity cache.
 *
 * @author charles.rodriguez
 * @see GeoipBlocks
 * @generated
 */
public class GeoipBlocksCacheModel implements CacheModel<GeoipBlocks>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{geonameId=");
		sb.append(geonameId);
		sb.append(", startIp=");
		sb.append(startIp);
		sb.append(", endIp=");
		sb.append(endIp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeoipBlocks toEntityModel() {
		GeoipBlocksImpl geoipBlocksImpl = new GeoipBlocksImpl();

		geoipBlocksImpl.setGeonameId(geonameId);
		geoipBlocksImpl.setStartIp(startIp);
		geoipBlocksImpl.setEndIp(endIp);

		geoipBlocksImpl.resetOriginalValues();

		return geoipBlocksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		geonameId = objectInput.readLong();
		startIp = objectInput.readLong();
		endIp = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(geonameId);
		objectOutput.writeLong(startIp);
		objectOutput.writeLong(endIp);
	}

	public long geonameId;
	public long startIp;
	public long endIp;
}