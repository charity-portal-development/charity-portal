package com.charityportal.core.model.entities;

import java.util.List;

public class Account {
	
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String emailAddress;
	
	private String encryptedPassword;
	
	private Status status;
	
	private Long lastStatusChange;

	private List<String> contactDetailsIds;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getLastStatusChange() {
		return lastStatusChange;
	}

	public void setLastStatusChange(Long lastStatusChange) {
		this.lastStatusChange = lastStatusChange;
	}

	public List<String> getContactDetailsIds() {
		return contactDetailsIds;
	}

	public void setContactDetailsIds(List<String> contactDetailsIds) {
		this.contactDetailsIds = contactDetailsIds;
	}

	public static enum Status {
		Pending_Activation, Active, Inactive, Blocked, Deleted
	}

}
