package com.bbva.aaaa.dto.customers;

import java.util.Date;

import com.bbva.apx.dto.AbstractDTO;

public class CustomerDTO extends AbstractDTO {
	
    private static final long serialVersionUID = 2931699728946609876L;
    
    private String customerId;
    private String fristName;
    private String lastName;
    private String nationality;
    private String personalTitle;
    private String generarId;
    private String identityDocumentType;
    private String identityDocumentNumber;
    private Date   birthDate;
    private String maritalStatus;
    
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPersonalTitle() {
		return personalTitle;
	}
	public void setPersonalTitle(String personalTitle) {
		this.personalTitle = personalTitle;
	}
	public String getGenerarId() {
		return generarId;
	}
	public void setGenerarId(String generarId) {
		this.generarId = generarId;
	}
	public String getIdentityDocumentType() {
		return identityDocumentType;
	}
	public void setIdentityDocumentType(String identityDocumentType) {
		this.identityDocumentType = identityDocumentType;
	}
	public String getIdentityDocumentNumber() {
		return identityDocumentNumber;
	}
	public void setIdentityDocumentNumber(String identityDocumentNumber) {
		this.identityDocumentNumber = identityDocumentNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((fristName == null) ? 0 : fristName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		CustomerDTO other = (CustomerDTO) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (fristName == null) {
			if (other.fristName != null)
				return false;
		} else if (!fristName.equals(other.fristName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", fristName=" + fristName + ", lastName=" + lastName + "]";
	}
	
	
}
