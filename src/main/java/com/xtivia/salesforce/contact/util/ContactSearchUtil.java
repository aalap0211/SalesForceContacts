package com.xtivia.salesforce.contact.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.xtivia.salesforce.contact.model.Contact;
import com.xtivia.salesforce.contact.model.ContactSearchCriteria;
import com.xtivia.salesforce.exceptions.FailedSearchException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class ContactSearchUtil {

    private static final Log LOGGER = LogFactoryUtil.getLog(ContactSearchUtil.class);
    private static final String RECORDS = "records";
    public static List<Contact> listContacts(String baseUrl, String accessToken) throws IOException {
        return searchContacts(baseUrl, accessToken, ContactSearchCriteria.EMPTY_CRITERIA);
    }

    public static List<Contact> searchContacts(String baseUrl, String accessToken, ContactSearchCriteria criteria) throws IOException {
        return salesForceApiCall(String.format("%s/query", baseUrl), accessToken, criteria.searchQuery());
    }

    private static List<Contact> salesForceApiCall(String leadUrl, String accessToken, String query) throws IOException {
        RequestBuilder builder = RequestBuilder.get(leadUrl).addParameter("q", query)
                .addHeader(new BasicHeader("Authorization", String.format("Bearer %s", accessToken)));
        CloseableHttpResponse response = HttpClients.createDefault().execute(builder.build());
        String body = EntityUtils.toString(response.getEntity());
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("SalesForce Search URL: %s\nSearch Query: %s\nResponse from SalesForce: %s", leadUrl, query, body));
        }
        return convertToContacts(new ObjectMapper().readValue(body, Map.class));
    }

    private static List<Contact> convertToContacts(Map contactResponse) {
        if (!contactResponse.containsKey("done")) {
            throw new FailedSearchException("SalesForce Search did not return success.");
        }
        
        List<Contact> contacts = new ArrayList<Contact>();
        for (Map contactsAttr : (List<Map>) contactResponse.get(RECORDS)) {
            contacts.add(ContactBuilder.makeNewContact(contactsAttr));
        }
        LOGGER.info(String.format("Successfully searched %s leads.", contacts.size()));
        return contacts;
    }

}
