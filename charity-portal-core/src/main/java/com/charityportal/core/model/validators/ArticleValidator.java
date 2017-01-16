package com.charityportal.core.model.validators;

import java.util.List;
import java.util.Set;

import com.charityportal.core.model.entities.Article;

public class ArticleValidator extends AbstractValidator {
	
	private static final int DEFAULT_MIN_TITLE_LENGTH = 2;
	private static final int DEFAULT_MAX_TITLE_LENGTH = 256;
	
	private static final int DEFAULT_MIN_DESCRIPTION_LENGTH = 2;
	private static final int DEFAULT_MAX_DESCRIPTION_LENGTH = 1024;
	
	private static final int DEFAULT_MAX_NUMBER_OF_TAGS = 32;
	private static final int DEFAULT_MAX_LENGTH_OF_TAGS = 64;
	private static final String DEFAULT_TAG_REGEX = "^[\\p{L}]+$";
	
	private static final int DEFAULT_MAX_NUMBER_OF_CONTACT_DETAILS = 32;

	
	private int minTitleLength = DEFAULT_MIN_TITLE_LENGTH;
	private int maxTitleLength = DEFAULT_MAX_TITLE_LENGTH;
	
	private int minDescriptionLength = DEFAULT_MIN_DESCRIPTION_LENGTH;
	private int maxDescriptionLength = DEFAULT_MAX_DESCRIPTION_LENGTH;
	
	private int maxNumberOfTags = DEFAULT_MAX_NUMBER_OF_TAGS;
	private int maxLengthOfTags = DEFAULT_MAX_LENGTH_OF_TAGS;
	private String tagRegex = DEFAULT_TAG_REGEX;
	
	private int maxNumberOfContactDetails = DEFAULT_MAX_NUMBER_OF_CONTACT_DETAILS;
	
	public void setMinTitleLength(int minTitleLength) {
		this.minTitleLength = minTitleLength;
	}

	public void setMaxTitleLength(int maxTitleLength) {
		this.maxTitleLength = maxTitleLength;
	}

	public void setMinDescriptionLength(int minDescriptionLength) {
		this.minDescriptionLength = minDescriptionLength;
	}

	public void setMaxDescriptionLength(int maxDescriptionLength) {
		this.maxDescriptionLength = maxDescriptionLength;
	}

	public void setMaxNumberOfTags(int maxNumberOfTags) {
		this.maxNumberOfTags = maxNumberOfTags;
	}

	public void setMaxLengthOfTags(int maxLengthOfTags) {
		this.maxLengthOfTags = maxLengthOfTags;
	}

	public void setTagRegex(String tagRegex) {
		this.tagRegex = tagRegex;
	}

	public ValidationResult validate(Article article) {
		ValidationResult ret = new ValidationResult();
		
		if (!isValidUUID(article.getAccountId()))
			ret.addProblem(ValidationProblem.INVALID_ID_FORMAT);
		
		if (article.getType() == null)
			ret.addProblem(ValidationProblem.TYPE_IS_UNDEFINED);
		
		String title = article.getTitle();
		
		if (title == null || title.length() < minTitleLength)
			ret.addProblem(ValidationProblem.TITLE_TOO_SHORT);
		
		if (title != null && title.length() > maxTitleLength)
			ret.addProblem(ValidationProblem.TITLE_TOO_LONG);
		
		String description = article.getDescription();
		if (description == null || description.length() < minDescriptionLength)
			ret.addProblem(ValidationProblem.DESCRIPTION_TOO_SHORT);
		
		if (description != null && description.length() > maxDescriptionLength)
			ret.addProblem(ValidationProblem.DESCRIPTION_TOO_LONG);
		
		if (article.getEffectiveFrom() == null || article.getEffectiveUntil() == null)
			ret.addProblem(ValidationProblem.EFFECTIVE_DATES_MISSING);

		Set<String> tags = article.getTags();
		if (tags == null) {
			ret.addProblem(ValidationProblem.TAGS_MISSING);
		} else {
			if (tags.size() > maxNumberOfTags)
				ret.addProblem(ValidationProblem.TOO_MANY_TAGS);
			
			for (String t : tags) {
				if (t == null || t.length() > maxLengthOfTags || !t.matches(tagRegex)) {
					ret.addProblem(ValidationProblem.INVALID_TAGS);
					break; // if one is null or too long, we break
				}
			}
		}
		
		List<String> contactDetailsIds = article.getContactDetailsIds();
		if (contactDetailsIds == null || contactDetailsIds.isEmpty())
			ret.addProblem(ValidationProblem.MISSING_CONTACT_DETAILS);
		
		if (contactDetailsIds != null && contactDetailsIds.size() > maxNumberOfContactDetails)
			ret.addProblem(ValidationProblem.TOO_MANY_CONTACT_DETAILS);
		
		if (article.getAccountId() == null)
			ret.addProblem(ValidationProblem.MISSING_ACCOUNT_ID);
		
		return ret;
	}

}
