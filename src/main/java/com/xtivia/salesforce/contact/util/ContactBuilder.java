package com.xtivia.salesforce.contact.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CamelCaseUtil;
import com.xtivia.salesforce.contact.model.Contact;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContactBuilder {

	private static final Log LOGGER = LogFactoryUtil.getLog(ContactBuilder.class);
	
    /**
     * pass in an attribute map for creating a Contact object.
     *
     * @param contactsAttr Map
     *
     * @return Contact
     */
    public static Contact makeNewContact(Map contactsAttr) {
    	System.out.println(CamelCaseUtil.fromCamelCase("FIRST NAME--->>>"+(String)contactsAttr.get("FirstName")));
    	
        Contact contact = new Contact((String) contactsAttr.get("Id"),
                (String) contactsAttr.get("AccountId"),
                (String) contactsAttr.get("isDeleted"),
                (String) contactsAttr.get("MasterRecordId"),
                (String) contactsAttr.get("LastName"),
                (String) contactsAttr.get("FirstName"),
                (String) contactsAttr.get("Salutation"),
                (String) contactsAttr.get("Name"),
                (String) contactsAttr.get("OtherStreet"),
                (String) contactsAttr.get("OtherCity"),
                (String) contactsAttr.get("OtherState"),
                (String) contactsAttr.get("OtherPostalCode"),
                (String) contactsAttr.get("OtherCountry"),
                (String) contactsAttr.get("OtherLatitude"),
                (String) contactsAttr.get("OtherLongitude"),
                (LinkedHashMap) contactsAttr.get("OtherAddress"),
                (String) contactsAttr.get("MailingStreet"),
                (String) contactsAttr.get("MailingCity"),
                (String) contactsAttr.get("MailingState"),
                (String) contactsAttr.get("MailingPostalCode"),
                (String) contactsAttr.get("MailingCountry"),
                (String) contactsAttr.get("MailingLatitude"),
                (String) contactsAttr.get("MailingLongitude"),
                (LinkedHashMap) contactsAttr.get("MailingAddress"),
                (String) contactsAttr.get("Phone"),
                (String) contactsAttr.get("Fax"),
                (String) contactsAttr.get("MobilePhone"),
                (String) contactsAttr.get("HomePhone"),
                (String) contactsAttr.get("OtherPhone"),
                (String) contactsAttr.get("AssistantPhone"),
                (String) contactsAttr.get("ReportsToId"),
                (String) contactsAttr.get("Email"),
                (String) contactsAttr.get("Title"),
                (String) contactsAttr.get("Department"),
                (String) contactsAttr.get("AssistantName"),
                (String) contactsAttr.get("LeadSource"),
                (String) contactsAttr.get("Birthdate"),
                (String) contactsAttr.get("Description"),
                (String) contactsAttr.get("LastViewedDate"),
                (String) contactsAttr.get("EmailBoundDate"),
                (String) contactsAttr.get("IsEmailBound"),
                (String) contactsAttr.get("EmailBoundReason"),
                (String) contactsAttr.get("PhotoUrl"));

        return contact;
    }

    /**
     * pass in the map of attributes and they'll be sysout to the console to review
     *
     * @param contactAttr Map
     */
    public static void debugFields(Map contactAttr) {
        String[] starr = {"Id",
                "AccountId",
                "isDeleted",
                "MasterRecordId",
                "LastName",
                "FirstName",
                "Salutation",
                "Name",
                "OtherStreet",
                "OtherCity",
                "OtherState",
                "OtherPostalCode",
                "OtherCountry",
                "OtherLatitude",
                "OtherLongitude",
                "OtherAddress",
                "MailingStreet",
                "MailingCity",
                "MailingState",
                "MailingPostalCode",
                "MailingCountry",
                "MailingLatitude",
                "MailingLongitude",
                "MailingAddress",
                "Phone",
                "Fax",
                "MobilePhone",
                "HomePhone",
                "OtherPhone",
                "AssistantPhone",
                "ReportsToId",
                "Email",
                "Title",
                "Department",
                "AssistantName",
                "LeadSour",
                "Birthdate",
                "Desiption",
                "LastViewedDate",
                "EmailBoundDate",
                "IsEmailBound",
                "EmailBoundReason",
                "PhotoUrl"};

        LOGGER.info("NEW CONTACT\n");
        for (int i = 0; i < starr.length; i++) {
            String s = starr[i];
            Object obj = contactAttr.get(s);
            
            LOGGER.info(String.format("name %s -- className is %s for %s", s, obj != null ? obj.getClass().toString() : "null", obj));
        }

        LOGGER.info("END OF NEW CONTACT\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
