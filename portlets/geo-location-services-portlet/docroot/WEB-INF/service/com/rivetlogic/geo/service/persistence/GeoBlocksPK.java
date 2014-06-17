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

package com.rivetlogic.geo.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author charles.rodriguez
 */
public class GeoBlocksPK implements Comparable<GeoBlocksPK>, Serializable {
	public long geonameId;
	public long startIp;

	public GeoBlocksPK() {
	}

	public GeoBlocksPK(long geonameId, long startIp) {
		this.geonameId = geonameId;
		this.startIp = startIp;
	}

	public long getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(long geonameId) {
		this.geonameId = geonameId;
	}

	public long getStartIp() {
		return startIp;
	}

	public void setStartIp(long startIp) {
		this.startIp = startIp;
	}

	@Override
	public int compareTo(GeoBlocksPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (geonameId < pk.geonameId) {
			value = -1;
		}
		else if (geonameId > pk.geonameId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (startIp < pk.startIp) {
			value = -1;
		}
		else if (startIp > pk.startIp) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeoBlocksPK)) {
			return false;
		}

		GeoBlocksPK pk = (GeoBlocksPK)obj;

		if ((geonameId == pk.geonameId) && (startIp == pk.startIp)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(geonameId) + String.valueOf(startIp)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("geonameId");
		sb.append(StringPool.EQUAL);
		sb.append(geonameId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("startIp");
		sb.append(StringPool.EQUAL);
		sb.append(startIp);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}