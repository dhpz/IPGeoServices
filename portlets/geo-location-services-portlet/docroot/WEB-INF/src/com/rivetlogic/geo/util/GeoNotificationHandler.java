package com.rivetlogic.geo.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.rivetlogic.geo.portlet.GeoServicesPortletConstants;

public class GeoNotificationHandler extends BaseUserNotificationHandler {
	
    public GeoNotificationHandler() {
        setPortletId(GeoServicesPortletConstants.PORTLET_ID);
    }

    @Override
    protected String getBody(UserNotificationEvent userNotificationEvent,
            ServiceContext serviceContext) throws Exception {
        JSONObject payload =
                JSONFactoryUtil.createJSONObject(
                        userNotificationEvent.getPayload());
        StringBundler sb = new StringBundler();
        sb.append("<div class=\"");
        sb.append(GeoServicesPortletConstants.GEO_MESSAGE);
        sb.append("\">");
        sb.append(LanguageUtil.get(serviceContext.getLocale(),
                payload.getString(
                        GeoServicesPortletConstants.NOTIFICATION_MESSAGE)));
        sb.append("</div>");

        return sb.toString();
    }

    @Override
    protected String getLink(UserNotificationEvent userNotificationEvent,
            ServiceContext serviceContext) throws Exception {
        return StringPool.FORWARD_SLASH;
    }
}
