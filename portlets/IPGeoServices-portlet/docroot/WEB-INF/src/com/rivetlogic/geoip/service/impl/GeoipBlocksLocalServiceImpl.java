/**
 * Copyright (C) 2014 Rivet Logic Corporation. All rights reserved.
 */

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

package com.rivetlogic.geoip.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rivetlogic.geoip.model.GeoipBlocks;
import com.rivetlogic.geoip.portlet.IPGeoServicesPortletConstants;
import com.rivetlogic.geoip.service.base.GeoipBlocksLocalServiceBaseImpl;
import com.rivetlogic.geoip.service.persistence.GeoipBlocksPK;

/**
 * The implementation of the geoip blocks local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.geoip.service.GeoipBlocksLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author charles.rodriguez
 * @see com.rivetlogic.geoip.service.base.GeoipBlocksLocalServiceBaseImpl
 * @see com.rivetlogic.geoip.service.GeoipBlocksLocalServiceUtil
 */
public class GeoipBlocksLocalServiceImpl extends GeoipBlocksLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.geoip.service.GeoipBlocksLocalServiceUtil} to access the geoip blocks local service.
	 */

	private static final Log LOG =
		    LogFactoryUtil.getLog(GeoipBlocksLocalServiceImpl.class);

	@Override
    public GeoipBlocks addGeoipBlocks(GeoipBlocks newBlocks) {
		GeoipBlocksPK blocksPk = new GeoipBlocksPK();

		GeoipBlocks blocks =
				geoipBlocksPersistence.create(blocksPk);

		blocks.setGeonameId(newBlocks.getGeonameId());
        blocks.setStartIp(newBlocks.getStartIp());
        blocks.setEndIp(newBlocks.getEndIp());

        try {
        	geoipBlocksPersistence.update(blocks);
		} catch (SystemException e) {
			LOG.error(e);
		}

        return blocks;
	}

	public void truncateTable(){
		Session session = geoipBlocksPersistence.openSession();
		Query query =
				session.createSQLQuery("truncate table "
		+ IPGeoServicesPortletConstants.BLOCKS_TABLE);
		query.executeUpdate();
	}

	public long getGeonameId(long startId, long endId){
		long geonameId = 0L;

		try {
			List<GeoipBlocks> blocks =
					geoipBlocksPersistence.findByStartEndIp(startId, endId);
			geonameId = blocks.get(0).getGeonameId();
		} catch (SystemException e) {
			LOG.error(e);
		}

		return geonameId;
	}
}
