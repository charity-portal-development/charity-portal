package com.charityportal.core.model.validators;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArticleValidator {

	@Test
	public void uuidMatcher() throws Exception {
		assertTrue(ArticleValidator.isValidUUID("544a1eba-1851-4258-9165-747ba952cfc1"));
		assertFalse(ArticleValidator.isValidUUID(" 544a1eba-1851-4258-9165-747ba952cfc1"));
		assertFalse(ArticleValidator.isValidUUID("544a1eba-1851-4258-9165-747ba952cfc1 "));
		assertFalse(ArticleValidator.isValidUUID("-544a1eba-1851-4258-9165-747ba952cfc1"));
		assertFalse(ArticleValidator.isValidUUID("544a1eba-1851-4258-9165-747ba952cfc")); // shorter
		assertFalse(ArticleValidator.isValidUUID("544a1eba-1851-4258-9165-747ba952cfg")); // non hex character
		assertFalse(ArticleValidator.isValidUUID("544a1eba-1851-0258-9165-747ba952cff")); // invalid type
		assertFalse(ArticleValidator.isValidUUID("544a1eba-1851-6258-9165-747ba952cff")); // invalid type
		assertFalse(ArticleValidator.isValidUUID("\n544a1eba-1851-6258-9165-747ba952cff"));
		assertFalse(ArticleValidator.isValidUUID("\\544a1eba-1851-6258-9165-747ba952cff"));
		assertFalse(ArticleValidator.isValidUUID("asdf"));
		assertFalse(ArticleValidator.isValidUUID(""));
		assertFalse(ArticleValidator.isValidUUID(null));
	}
	
}
