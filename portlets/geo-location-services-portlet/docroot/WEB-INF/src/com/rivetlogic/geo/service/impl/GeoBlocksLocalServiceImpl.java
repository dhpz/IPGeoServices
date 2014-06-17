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

package com.rivetlogic.geo.service.impl;

import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rivetlogic.geo.NoSuchGeoBlocksException;
import com.rivetlogic.geo.model.GeoBlocks;
import com.rivetlogic.geo.portlet.GeoServicesPortletConstants;
import com.rivetlogic.geo.service.base.GeoBlocksLocalServiceBaseImpl;
import com.rivetlogic.geo.service.persistence.GeoBlocksPK;

/**
 * The implementation of the geo blocks local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.geo.service.GeoBlocksLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author charles.rodriguez
 * @see com.rivetlogic.geo.service.base.GeoBlocksLocalServiceBaseImpl
 * @see com.rivetlogic.geo.service.GeoBlocksLocalServiceUtil
 */
public class GeoBlocksLocalServiceImpl extends GeoBlocksLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.geo.service.GeoBlocksLocalServiceUtil} to access the geo blocks local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(GeoBlocksLocalServiceImpl.class);

	@Override
    public GeoBlocks addGeoipBlocks(GeoBlocks newBlocks) {
		GeoBlocksPK blocksPk = new GeoBlocksPK();

		GeoBlocks blocks = geoBlocksPersistence.create(blocksPk);

		blocks.setGeonameId(newBlocks.getGeonameId());
        blocks.setStartIp(newBlocks.getStartIp());
        blocks.setEndIp(newBlocks.getEndIp());

        try {
        	geoBlocksPersistence.update(blocks);
		} catch (SystemException e) {
			LOG.error(e);
		}

        return blocks;
	}

	public void truncateTable(){
		Session session = geoBlocksPersistence.openSession();
		Query query =
				session.createSQLQuery(GeoServicesPortletConstants.SQL_TRUNCATE
		+ GeoServicesPortletConstants.BLOCKS_TABLE);
		query.executeUpdate();
	}

	public long getGeonameId(long startId, long endId){
		long geonameId = GeoServicesPortletConstants.DEFAULT_ID;
		GeoBlocks geoIpBlock;
		try {
			geoIpBlock = geoBlocksPersistence.findByStartEndIp_First(startId, endId, null);
			if(geoIpBlock != null){
				geonameId = geoIpBlock.getGeonameId();
			}
			
		} catch (NoSuchGeoBlocksException e) {
			LOG.error(e);
		} catch (SystemException e) {
			LOG.error(e);
		}
		
		return geonameId;
	}
}