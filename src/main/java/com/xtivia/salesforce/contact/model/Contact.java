package com.xtivia.salesforce.contact.model;

import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;
import java.util.HashMap;

public class Contact implements Serializable{

	private static final long serialVersionUID = -5201169470742630326L;
	private String id;
    private String accountId;
    private String accountName;
    private String isDeleted;
    private String masterRecordId;
    private String lastName;
    private String firstName;
    private String salutation;
    private String name;
    private String otherStreet;
    private String otherCity;
    private String otherState;
    private String otherPostalCode;
    private String otherCountry;
    private String otherLatitude;
    private String otherLongitude;
    private HashMap otherAddress;
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingPostalCode;
    private String mailingCountry;
    private String mailingLatitude;
    private String mailingLongitude;
    private HashMap mailingAddress;
    private String phone;
    private String fax;
    private String mobilePhone;
    private String homePhone;
    private String otherPhone;
    private String assistantPhone;
    private String reportsToId;
    private String email;
    private String title;
    private String department;
    private String assistantName;
    private String leadSource;
    private String birthdate;
    private String description;
    private String lastViewedDate;
    private String emailBoundDate;
    private String isEmailBound;
    private String emailBoundReason;
    private String photoUrl;

    public Contact() {
		super();
		this.id = StringPool.BLANK;
        this.accountId = StringPool.BLANK;
        this.accountName = StringPool.BLANK;
        this.isDeleted = StringPool.BLANK;
        this.masterRecordId = StringPool.BLANK;
        this.lastName = StringPool.BLANK;
        this.firstName = StringPool.BLANK;
        this.salutation = StringPool.BLANK;
        this.name = StringPool.BLANK;
        this.otherStreet = StringPool.BLANK;
        this.otherCity = StringPool.BLANK;
        this.otherState = StringPool.BLANK;
        this.otherPostalCode = StringPool.BLANK;
        this.otherCountry = StringPool.BLANK;
        this.otherLatitude = StringPool.BLANK;
        this.otherLongitude = StringPool.BLANK;
        this.otherAddress = null;
        this.mailingStreet = StringPool.BLANK;
        this.mailingCity = StringPool.BLANK;
        this.mailingState = StringPool.BLANK;
        this.mailingPostalCode = StringPool.BLANK;
        this.mailingCountry = StringPool.BLANK;
        this.mailingLatitude = StringPool.BLANK;
        this.mailingLongitude = StringPool.BLANK;
        this.mailingAddress = null;
        this.phone = StringPool.BLANK;
        this.fax = StringPool.BLANK;
        this.mobilePhone = StringPool.BLANK;
        this.homePhone = StringPool.BLANK;
        this.otherPhone = StringPool.BLANK;
        this.assistantPhone = StringPool.BLANK;
        this.reportsToId = StringPool.BLANK;
        this.email = StringPool.BLANK;
        this.title = StringPool.BLANK;
        this.department = StringPool.BLANK;
        this.assistantName = StringPool.BLANK;
        this.leadSource = StringPool.BLANK;
        this.birthdate = StringPool.BLANK;
        this.description = StringPool.BLANK;
        this.lastViewedDate = StringPool.BLANK;
        this.emailBoundDate = StringPool.BLANK;
        this.isEmailBound = StringPool.BLANK;
        this.emailBoundReason = StringPool.BLANK;
        this.photoUrl = StringPool.BLANK;
    }

    public Contact(String id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public Contact(String id, String accountId, String isDeleted, String masterRecordId, String lastName, String firstName, String salutation, String name, String otherStreet, String otherCity, String otherState, String otherPostalCode, String otherCountry, String otherLatitude, String otherLongitude, HashMap otherAddress, String mailingStreet, String mailingCity, String mailingState, String mailingPostalCode, String mailingCountry, String mailingLatitude, String mailingLongitude, HashMap mailingAddress, String phone, String fax, String mobilePhone, String homePhone, String otherPhone, String assistantPhone, String reportsToId, String email, String title, String department, String assistantName, String leadSour, String birthdate, String desiption, String lastViewedDate, String emailBoundDate, String isEmailBound, String emailBoundReason, String photoUrl) {
        this.id = id;
        this.accountId = accountId;
        this.isDeleted = isDeleted;
        this.masterRecordId = masterRecordId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.salutation = salutation;
        this.name = name;
        this.otherStreet = otherStreet;
        this.otherCity = otherCity;
        this.otherState = otherState;
        this.otherPostalCode = otherPostalCode;
        this.otherCountry = otherCountry;
        this.otherLatitude = otherLatitude;
        this.otherLongitude = otherLongitude;
        this.otherAddress = otherAddress;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingState = mailingState;
        this.mailingPostalCode = mailingPostalCode;
        this.mailingCountry = mailingCountry;
        this.mailingLatitude = mailingLatitude;
        this.mailingLongitude = mailingLongitude;
        this.mailingAddress = mailingAddress;
        this.phone = phone;
        this.fax = fax;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.otherPhone = otherPhone;
        this.assistantPhone = assistantPhone;
        this.reportsToId = reportsToId;
        this.email = email;
        this.title = title;
        this.department = department;
        this.assistantName = assistantName;
        this.leadSource = leadSour;
        this.birthdate = birthdate;
        description = desiption;
        this.lastViewedDate = lastViewedDate;
        this.emailBoundDate = emailBoundDate;
        this.isEmailBound = isEmailBound;
        this.emailBoundReason = emailBoundReason;
        this.photoUrl = photoUrl;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        if (accountName != null && !"".equals(accountName)) {
            this.accountName = accountName.replaceAll("%20", " ");
        } else {
            this.accountName = accountName;
        }
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public String getMasterRecordId() {
        return masterRecordId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getName() {
        return name;
    }

    public String getOtherStreet() {
        return otherStreet;
    }

    public String getOtherCity() {
        return otherCity;
    }

    public String getOtherState() {
        return otherState;
    }

    public String getOtherPostalCode() {
        return otherPostalCode;
    }

    public String getOtherCountry() {
        return otherCountry;
    }

    public String getOtherLatitude() {
        return otherLatitude;
    }

    public String getOtherLongitude() {
        return otherLongitude;
    }

    public HashMap getOtherAddress() {
        return otherAddress;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public String getMailingPostalCode() {
        return mailingPostalCode;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public String getMailingLatitude() {
        return mailingLatitude;
    }

    public String getMailingLongitude() {
        return mailingLongitude;
    }

    public HashMap getMailingAddress() {
        return mailingAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }

    public String getReportsToId() {
        return reportsToId;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getDescription() {
        return description;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public String getEmailBoundDate() {
        return emailBoundDate;
    }

    public String getIsEmailBound() {
        return isEmailBound;
    }

    public String getEmailBoundReason() {
        return emailBoundReason;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

	@Override
	public String toString() {
		return "Contact [id=" + id + ", accountId=" + accountId + ", accountName=" + accountName + ", isDeleted="
				+ isDeleted + ", masterRecordId=" + masterRecordId + ", lastName=" + lastName + ", firstName="
				+ firstName + ", salutation=" + salutation + ", name=" + name + ", otherStreet=" + otherStreet
				+ ", otherCity=" + otherCity + ", otherState=" + otherState + ", otherPostalCode=" + otherPostalCode
				+ ", otherCountry=" + otherCountry + ", otherLatitude=" + otherLatitude + ", otherLongitude="
				+ otherLongitude + ", otherAddress=" + otherAddress + ", mailingStreet=" + mailingStreet
				+ ", mailingCity=" + mailingCity + ", mailingState=" + mailingState + ", mailingPostalCode="
				+ mailingPostalCode + ", mailingCountry=" + mailingCountry + ", mailingLatitude=" + mailingLatitude
				+ ", mailingLongitude=" + mailingLongitude + ", mailingAddress=" + mailingAddress + ", phone=" + phone
				+ ", fax=" + fax + ", mobilePhone=" + mobilePhone + ", homePhone=" + homePhone + ", otherPhone="
				+ otherPhone + ", assistantPhone=" + assistantPhone + ", reportsToId=" + reportsToId + ", email="
				+ email + ", title=" + title + ", department=" + department + ", assistantName=" + assistantName
				+ ", leadSource=" + leadSource + ", birthdate=" + birthdate + ", description=" + description
				+ ", lastViewedDate=" + lastViewedDate + ", emailBoundDate=" + emailBoundDate + ", isEmailBound="
				+ isEmailBound + ", emailBoundReason=" + emailBoundReason + ", photoUrl=" + photoUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((assistantName == null) ? 0 : assistantName.hashCode());
		result = prime * result + ((assistantPhone == null) ? 0 : assistantPhone.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailBoundDate == null) ? 0 : emailBoundDate.hashCode());
		result = prime * result + ((emailBoundReason == null) ? 0 : emailBoundReason.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result + ((isEmailBound == null) ? 0 : isEmailBound.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((lastViewedDate == null) ? 0 : lastViewedDate.hashCode());
		result = prime * result + ((leadSource == null) ? 0 : leadSource.hashCode());
		result = prime * result + ((mailingAddress == null) ? 0 : mailingAddress.hashCode());
		result = prime * result + ((mailingCity == null) ? 0 : mailingCity.hashCode());
		result = prime * result + ((mailingCountry == null) ? 0 : mailingCountry.hashCode());
		result = prime * result + ((mailingLatitude == null) ? 0 : mailingLatitude.hashCode());
		result = prime * result + ((mailingLongitude == null) ? 0 : mailingLongitude.hashCode());
		result = prime * result + ((mailingPostalCode == null) ? 0 : mailingPostalCode.hashCode());
		result = prime * result + ((mailingState == null) ? 0 : mailingState.hashCode());
		result = prime * result + ((mailingStreet == null) ? 0 : mailingStreet.hashCode());
		result = prime * result + ((masterRecordId == null) ? 0 : masterRecordId.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((otherAddress == null) ? 0 : otherAddress.hashCode());
		result = prime * result + ((otherCity == null) ? 0 : otherCity.hashCode());
		result = prime * result + ((otherCountry == null) ? 0 : otherCountry.hashCode());
		result = prime * result + ((otherLatitude == null) ? 0 : otherLatitude.hashCode());
		result = prime * result + ((otherLongitude == null) ? 0 : otherLongitude.hashCode());
		result = prime * result + ((otherPhone == null) ? 0 : otherPhone.hashCode());
		result = prime * result + ((otherPostalCode == null) ? 0 : otherPostalCode.hashCode());
		result = prime * result + ((otherState == null) ? 0 : otherState.hashCode());
		result = prime * result + ((otherStreet == null) ? 0 : otherStreet.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((photoUrl == null) ? 0 : photoUrl.hashCode());
		result = prime * result + ((reportsToId == null) ? 0 : reportsToId.hashCode());
		result = prime * result + ((salutation == null) ? 0 : salutation.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (assistantName == null) {
			if (other.assistantName != null)
				return false;
		} else if (!assistantName.equals(other.assistantName))
			return false;
		if (assistantPhone == null) {
			if (other.assistantPhone != null)
				return false;
		} else if (!assistantPhone.equals(other.assistantPhone))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailBoundDate == null) {
			if (other.emailBoundDate != null)
				return false;
		} else if (!emailBoundDate.equals(other.emailBoundDate))
			return false;
		if (emailBoundReason == null) {
			if (other.emailBoundReason != null)
				return false;
		} else if (!emailBoundReason.equals(other.emailBoundReason))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDeleted == null) {
			if (other.isDeleted != null)
				return false;
		} else if (!isDeleted.equals(other.isDeleted))
			return false;
		if (isEmailBound == null) {
			if (other.isEmailBound != null)
				return false;
		} else if (!isEmailBound.equals(other.isEmailBound))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lastViewedDate == null) {
			if (other.lastViewedDate != null)
				return false;
		} else if (!lastViewedDate.equals(other.lastViewedDate))
			return false;
		if (leadSource == null) {
			if (other.leadSource != null)
				return false;
		} else if (!leadSource.equals(other.leadSource))
			return false;
		if (mailingAddress == null) {
			if (other.mailingAddress != null)
				return false;
		} else if (!mailingAddress.equals(other.mailingAddress))
			return false;
		if (mailingCity == null) {
			if (other.mailingCity != null)
				return false;
		} else if (!mailingCity.equals(other.mailingCity))
			return false;
		if (mailingCountry == null) {
			if (other.mailingCountry != null)
				return false;
		} else if (!mailingCountry.equals(other.mailingCountry))
			return false;
		if (mailingLatitude == null) {
			if (other.mailingLatitude != null)
				return false;
		} else if (!mailingLatitude.equals(other.mailingLatitude))
			return false;
		if (mailingLongitude == null) {
			if (other.mailingLongitude != null)
				return false;
		} else if (!mailingLongitude.equals(other.mailingLongitude))
			return false;
		if (mailingPostalCode == null) {
			if (other.mailingPostalCode != null)
				return false;
		} else if (!mailingPostalCode.equals(other.mailingPostalCode))
			return false;
		if (mailingState == null) {
			if (other.mailingState != null)
				return false;
		} else if (!mailingState.equals(other.mailingState))
			return false;
		if (mailingStreet == null) {
			if (other.mailingStreet != null)
				return false;
		} else if (!mailingStreet.equals(other.mailingStreet))
			return false;
		if (masterRecordId == null) {
			if (other.masterRecordId != null)
				return false;
		} else if (!masterRecordId.equals(other.masterRecordId))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (otherAddress == null) {
			if (other.otherAddress != null)
				return false;
		} else if (!otherAddress.equals(other.otherAddress))
			return false;
		if (otherCity == null) {
			if (other.otherCity != null)
				return false;
		} else if (!otherCity.equals(other.otherCity))
			return false;
		if (otherCountry == null) {
			if (other.otherCountry != null)
				return false;
		} else if (!otherCountry.equals(other.otherCountry))
			return false;
		if (otherLatitude == null) {
			if (other.otherLatitude != null)
				return false;
		} else if (!otherLatitude.equals(other.otherLatitude))
			return false;
		if (otherLongitude == null) {
			if (other.otherLongitude != null)
				return false;
		} else if (!otherLongitude.equals(other.otherLongitude))
			return false;
		if (otherPhone == null) {
			if (other.otherPhone != null)
				return false;
		} else if (!otherPhone.equals(other.otherPhone))
			return false;
		if (otherPostalCode == null) {
			if (other.otherPostalCode != null)
				return false;
		} else if (!otherPostalCode.equals(other.otherPostalCode))
			return false;
		if (otherState == null) {
			if (other.otherState != null)
				return false;
		} else if (!otherState.equals(other.otherState))
			return false;
		if (otherStreet == null) {
			if (other.otherStreet != null)
				return false;
		} else if (!otherStreet.equals(other.otherStreet))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (photoUrl == null) {
			if (other.photoUrl != null)
				return false;
		} else if (!photoUrl.equals(other.photoUrl))
			return false;
		if (reportsToId == null) {
			if (other.reportsToId != null)
				return false;
		} else if (!reportsToId.equals(other.reportsToId))
			return false;
		if (salutation == null) {
			if (other.salutation != null)
				return false;
		} else if (!salutation.equals(other.salutation))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
