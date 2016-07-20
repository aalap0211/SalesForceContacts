package com.xtivia.salesforce.contact.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.xtivia.salesforce.contact.util.ContactSearchUtil;
import com.xtivia.salesforce.util.SalesForceUtil;

import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@SuppressWarnings({"unchecked","rawtype"})
@Path("/contacts")
public class ListContactService {
	 private static final Log LOGGER = LogFactoryUtil.getLog(ListContactService.class);

	 	/*
	 	 * Method to fetch all contacts from the sales force.
	 	 * */
	    @GET
	    @Path("/showallContacts")
	    @Produces("application/json")
	    public Response getAllContacts(@Context HttpServletRequest httpServletRequest, @QueryParam("plidParam") String plid, @QueryParam("portletIdParam") String portletId) throws Exception {
	    	ResponseBuilder builder;
	    	long userId = Long.parseLong(httpServletRequest.getRemoteUser());
	    	PrincipalThreadLocal.setName(userId);
	    	
	    	User user = UserLocalServiceUtil.getUserById(userId);
	    	
	    	PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
	    	boolean hasPermission = LayoutPermissionUtil.contains(permissionChecker, Long.parseLong(plid), ActionKeys.VIEW);
	    	PortletPreferences portletPreferences = SalesForceUtil.getPreferences(plid, portletId);
	    	if(hasPermission) {
	    		//Get access token from the the sales force passing the url and required credentials which are saved in preferences. 
		    	String accessToken = SalesForceUtil.getAccessTokenFromPreferences(portletPreferences);
		    	String serviceUrl = portletPreferences.getValue(SalesForceUtil.SERVICE_URL, StringPool.BLANK);
		        try {
		            if (LOGGER.isDebugEnabled()) {
		                LOGGER.debug("About to fetch the list of leads. Using an empty search criteria and the search API to fetch the list.");
		            }
		            //Make a call to the contact service util to fetch list of contacts
		            builder = Response.ok(ContactSearchUtil.listContacts(serviceUrl, accessToken));
		        } catch (Exception e) {
		            LOGGER.error("Failed to get a list of leads using the empty search criteria.", e);
		            builder = Response.serverError().entity("Failed to get a list of leads.");
		        }
	    	} else {
	    		builder = Response.serverError().entity("You do not have permission to access. Contact admin.");
	    	}
	        return builder.build();
	    }
	    
	    
}
