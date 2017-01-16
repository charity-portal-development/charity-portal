package com.charityportal.core.model.entities;

import java.util.List;
import java.util.Set;

public class Article {
	
	private Type type;
	
	private String title;
	
	private String description;
	
	private Long effectiveFrom;
	
	private Long effectiveUntil;
	
	private Set<String> tags;
	
	private List<String> contactDetailsIds;
	
	private String accountId;
	
	private Long createdAt;
	
	private Long lastModifiedAt;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Long effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public Long getEffectiveUntil() {
		return effectiveUntil;
	}

	public void setEffectiveUntil(Long effectiveUntil) {
		this.effectiveUntil = effectiveUntil;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public List<String> getContactDetailsIds() {
		return contactDetailsIds;
	}

	public void setContactDetailsIds(List<String> contactDetailsIds) {
		this.contactDetailsIds = contactDetailsIds;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Long lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public static enum Type {
		Need, Offer
	}

}
