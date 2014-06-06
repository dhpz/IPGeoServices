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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.geoip.model.GeoipLocations;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GeoipLocations in entity cache.
 *
 * @author charles.rodriguez
 * @see GeoipLocations
 * @generated
 */
public class GeoipLocationsCacheModel implements CacheModel<GeoipLocations>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{geonameId=");
		sb.append(geonameId);
		sb.append(", countryIsoCode=");
		sb.append(countryIsoCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeoipLocations toEntityModel() {
		GeoipLocationsImpl geoipLocationsImpl = new GeoipLocationsImpl();

		geoipLocationsImpl.setGeonameId(geonameId);

		if (countryIsoCode == null) {
			geoipLocationsImpl.setCountryIsoCode(StringPool.BLANK);
		}
		else {
			geoipLocationsImpl.setCountryIsoCode(countryIsoCode);
		}

		geoipLocationsImpl.resetOriginalValues();

		return geoipLocationsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		geonameId = objectInput.readLong();
		countryIsoCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(geonameId);

		if (countryIsoCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryIsoCode);
		}
	}

	public long geonameId;
	public String countryIsoCode;
}