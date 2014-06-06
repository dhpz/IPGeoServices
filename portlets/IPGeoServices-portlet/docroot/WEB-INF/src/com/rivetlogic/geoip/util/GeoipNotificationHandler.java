package com.rivetlogic.geoip.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.rivetlogic.geoip.portlet.IPGeoServicesPortletConstants;

public class GeoipNotificationHandler extends BaseUserNotificationHandler {
    public GeoipNotificationHandler() {
        setPortletId(IPGeoServicesPortletConstants.PORTLET_ID);
    }

    @Override
    protected String getBody(UserNotificationEvent userNotificationEvent,
            ServiceContext serviceContext) throws Exception {
        JSONObject payload =
                JSONFactoryUtil.createJSONObject(
                        userNotificationEvent.getPayload());

        StringBundler sb = new StringBundler();
        sb.append("<div class=\"");
        sb.append(IPGeoServicesPortletConstants.GEOIP_MESSAGE);
        sb.append("\">");
        sb.append(LanguageUtil.get(serviceContext.getLocale(),
                payload.getString(
                        IPGeoServicesPortletConstants.NOTIFICATION_MESSAGE)));
        sb.append("</div>");

        return sb.toString();
    }

    @Override
    protected String getLink(UserNotificationEvent userNotificationEvent,
            ServiceContext serviceContext) throws Exception {
        return "/";
    }
}
