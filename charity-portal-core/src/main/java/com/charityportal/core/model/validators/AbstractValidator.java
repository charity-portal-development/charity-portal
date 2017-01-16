package com.charityportal.core.model.validators;

public class AbstractValidator {

	private static final String UUID_REGEX = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";
	
	public static boolean isValidUUID(String value) {
		return value != null && value.matches(UUID_REGEX);
	}
	
}
