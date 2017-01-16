package com.charityportal.core.model.validators;

public enum ValidationProblem {

	INVALID_ID_FORMAT,
	TYPE_IS_UNDEFINED,
	TITLE_TOO_SHORT,
	TITLE_TOO_LONG,
	DESCRIPTION_TOO_SHORT,
	DESCRIPTION_TOO_LONG,
	EFFECTIVE_DATES_MISSING,
	TAGS_MISSING,
	TOO_MANY_TAGS,
	INVALID_TAGS,
	MISSING_CONTACT_DETAILS,
	TOO_MANY_CONTACT_DETAILS,
	MISSING_ACCOUNT_ID
	;
	
	private String messageId;
	
	private ValidationProblem() {
		this.messageId = this.name().toLowerCase().replaceAll("_", ".");
	}

	public String getMessageId() {
		return messageId;
	}
	
}
