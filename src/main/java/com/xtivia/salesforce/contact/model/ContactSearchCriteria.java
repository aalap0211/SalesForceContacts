package com.xtivia.salesforce.contact.model;

import com.liferay.portal.kernel.util.StringPool;

import org.apache.commons.lang3.StringUtils;

public class ContactSearchCriteria {


    private final String lastName;
    private final String id;

    public static final ContactSearchCriteria EMPTY_CRITERIA = new ContactSearchCriteria(StringPool.BLANK, StringPool.BLANK);

    public ContactSearchCriteria(String lastName, String id) {
        this.lastName = lastName;
        this.id = id;
    }

    public String getLastName() {
        return StringUtils.isEmpty(lastName) ? "%" : "%" + lastName + "%";
    }

    public String getId() {
        return StringUtils.isEmpty(id) ? "%" : "%" + id + "%";
    }

    @Override
    public String toString() {
        return "SearchCriteria [name=" + getLastName() + ", id=" + getId() + "]";
    }

    public String searchQuery() {
        return String.format("SELECT c.Id, c.AccountId, c.isDeleted, "
        		+ "c.MasterRecordId, c.LastName, c.FirstName, c.Salutation, c.Name, c.OtherStreet, c.OtherCity, c.OtherState, c.OtherPostalCode, "
        		+ "c.OtherCountry, c.OtherLatitude, c.OtherLongitude, c.OtherAddress, c.MailingStreet, c.MailingCity, "
        		+ "c.MailingState, c.MailingPostalCode, c.MailingCountry, c.MailingLatitude, c.MailingLongitude, c.MailingAddress, "
        		+ "c.Phone, c.Fax, c.MobilePhone, c.HomePhone, c.OtherPhone, c.AssistantPhone, c.ReportsToId, c.Email, c.Title, "
        		+ "c.Department, c.AssistantName, c.LeadSource, c.Birthdate, c.Description, c.LastViewedDate, c.EmailBouncedDate, "
        		+ "c.IsEmailBounced, c.EmailBouncedReason, c.PhotoUrl FROM Contact c", getLastName(), getId());
    }

}
