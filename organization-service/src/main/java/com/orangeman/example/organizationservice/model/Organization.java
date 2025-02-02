package com.orangeman.example.organizationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization {

	@Id
	@Column(name = "organization_id", nullable = false)
	String organizationId;
	
	@Column(name = "name", nullable = false)
	String organizationName;
	
	@Column(name = "contact_name", nullable = false)
	String contactName;
	
	@Column(name = "contact_email", nullable = false)
	String contactEmail;
	
	@Column(name = "contact_phone", nullable = false)
	String contactPhone;

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	
	
	
	
	
}
