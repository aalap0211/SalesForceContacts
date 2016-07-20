package com.xtivia.salesforce.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class SalesForceUtil {

	public static final String SERVICE_URL = "serviceUrl";
	public static final String CLIENT_ID = "clientId";
	public static final String CLIENT_ID_PARAM = "client_id";
	public static final String CLIENT_SECRET_PARAM = "client_secret";

	public static final String CLIENT_SECRET = "clientSecret";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String SECURITY_TOKEN = "securityToken";
	public static final String GRANT_TYPE = "grant_type";

	public static final String ACCESS_TOKEN = "access_token";
	public static final String ACCESS_TOKEN_SESSION_KEY = "";

	public static final String ERROR_MESSAGE = "errorMessage";
	private static final Log LOGGER = LogFactoryUtil.getLog(SalesForceUtil.class);

	/*
	 * Get access token on the basis of the information saved into the
	 * preferences
	 */
	public static String getAccessTokenFromPreferences(PortletPreferences preferences) {
		List<NameValuePair> params = grantTokenparamsFromPreferences(preferences);
		String accessToken = null;
		try {
			accessToken = fetchAccessToken(params);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return accessToken;
	}

	/*
	 * Get token params from preferences.
	 */
	private static List<NameValuePair> grantTokenparamsFromPreferences(PortletPreferences preferences) {
		String clientId = preferences.getValue(SalesForceUtil.CLIENT_ID, StringPool.BLANK);
		String clientSecret = preferences.getValue(SalesForceUtil.CLIENT_SECRET, StringPool.BLANK);
		String username = preferences.getValue(SalesForceUtil.USERNAME, StringPool.BLANK);
		String password = preferences.getValue(SalesForceUtil.PASSWORD, StringPool.BLANK);
		String securityToken = preferences.getValue(SalesForceUtil.SECURITY_TOKEN, StringPool.BLANK);

		if (StringUtils.isEmpty(clientId) || StringUtils.isEmpty(clientSecret) || StringUtils.isEmpty(username)
				|| StringUtils.isEmpty(password) || StringUtils.isEmpty(securityToken)) {
			throw new IllegalStateException(
					"The required OAuth configuration or credentials have not been configured in the portlet.");
		}

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		/*
		 * params.add(new BasicNameValuePair(SalesForceUtil.GRANT_TYPE,
		 * SalesForceUtil.PASSWORD)); params.add(new
		 * BasicNameValuePair(SalesForceUtil.CLIENT_ID, clientId));
		 * params.add(new BasicNameValuePair(SalesForceUtil.CLIENT_SECRET,
		 * clientSecret)); params.add(new
		 * BasicNameValuePair(SalesForceUtil.USERNAME, username));
		 * params.add(new BasicNameValuePair(SalesForceUtil.PASSWORD, password +
		 * securityToken));
		 */
		params.add(new BasicNameValuePair(GRANT_TYPE, PASSWORD));
		params.add(new BasicNameValuePair(CLIENT_ID_PARAM, clientId));
		params.add(new BasicNameValuePair(CLIENT_SECRET_PARAM, clientSecret));
		params.add(new BasicNameValuePair(USERNAME, username));
		params.add(new BasicNameValuePair(PASSWORD, password + securityToken));
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("Post Params:\n%s", ToStringBuilder.reflectionToString(params)));
		}
		return params;
	}

	/*
	 * Fetch access token on the basis of the params values get from
	 * preferencecs.
	 */
	private static String fetchAccessToken(List<NameValuePair> params) throws IOException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("About to fetch access token");
		}
		HttpPost httpPost = new HttpPost("https://login.salesforce.com/services/oauth2/token");
		httpPost.setEntity(new UrlEncodedFormEntity(params));
		CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
		String body = EntityUtils.toString(response.getEntity());
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("SalesForce Response:\n Code:%s\n Body:%s",
					response.getStatusLine().getStatusCode(), body));
		}
		Map<String, String> responseKeys = new ObjectMapper().readValue(body, Map.class);
		if (!responseKeys.containsKey(SalesForceUtil.ACCESS_TOKEN)) {
			throw new SFAuthFailureException(ToStringBuilder.reflectionToString(responseKeys));
		}
		String accessToken = responseKeys.get(SalesForceUtil.ACCESS_TOKEN);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format(
					"Successfully obtained the accessToken: %s. This is a secure value. Make sure this is not showing up in production log.",
					accessToken));
		}
		return accessToken;
	}

	/*
	 * Get portlet preferences.
	 */
	public static PortletPreferences getPreferences(String plid, String portletId) {
		List<com.liferay.portal.kernel.model.PortletPreferences> portletPreferences = PortletPreferencesLocalServiceUtil
				.getPortletPreferences(Long.parseLong(plid), portletId);
		PortletPreferences portletPreference = null;
		if (Validator.isNotNull(portletPreferences) && portletPreferences.size() > 0) {
			com.liferay.portal.kernel.model.PortletPreferences preference = portletPreferences.get(0);
			portletPreference = PortletPreferencesLocalServiceUtil.getPreferences(preference.getCompanyId(),
					preference.getOwnerId(), preference.getOwnerType(), preference.getPlid(), portletId);
		}
		return portletPreference;
	}

	/**
	 * Understands representing an authentication error returned by SalesForce
	 * 
	 * @author Aalap Desai
	 * 
	 */
	private static class SFAuthFailureException extends RuntimeException {

		private static final long serialVersionUID = -6228641469753971763L;

		public SFAuthFailureException(String message) {
			super(message);
		}
	}
}
