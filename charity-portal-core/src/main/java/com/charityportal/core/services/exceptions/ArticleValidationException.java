package com.charityportal.core.services.exceptions;

import com.charityportal.core.model.validators.ValidationResult;

public class ArticleValidationException extends ServiceException {
	
	private static final long serialVersionUID = 1L;
	
	private ValidationResult validationResult;

	public ArticleValidationException(ValidationResult validationResult) {
		super("Article validation exception.");
		this.validationResult = validationResult;
	}

	public ValidationResult getValidationResult() {
		return validationResult;
	}
	
}
