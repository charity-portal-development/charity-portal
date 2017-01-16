package com.charityportal.core.services.exceptions;

public class PermissionViolationException extends ServiceException {

	private static final long serialVersionUID = 1L;
	
	private String articleId;
	
	private String actorAccountId;

	public PermissionViolationException(String articleId, String actorAccountId) {
		super();
		this.articleId = articleId;
		this.actorAccountId = actorAccountId;
	}

	public String getArticleId() {
		return articleId;
	}

	public String getActorAccountId() {
		return actorAccountId;
	}
	
}
