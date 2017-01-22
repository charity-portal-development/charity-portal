package com.charityportal.core.services;

import java.util.List;

import com.charityportal.core.dao.ArticleAdminDAO;
import com.charityportal.core.model.context.Context;
import com.charityportal.core.model.entities.Article;
import com.charityportal.core.model.validators.ArticleValidator;
import com.charityportal.core.model.validators.ValidationResult;
import com.charityportal.core.services.exceptions.ArticleValidationException;
import com.charityportal.core.services.exceptions.PermissionViolationException;
import com.charityportal.core.services.exceptions.ServiceException;
import com.charityportal.core.util.Utilities;

public class ArticleAdminService {
	
	private ArticleAdminDAO articleAdminDAO;
	
	private ArticleValidator articleValidator;
	
	public String create(Article article, Context context) throws ServiceException {
		setImplicitFields(article, context);
		article.setCreatedAt(context.getActionTimestamp());
		
		validate(article);
		
		String id = Utilities.randomUUID();
		articleAdminDAO.create(id, article);
		
		return id;
	}

	public Article get(String id, Context context) throws ServiceException {
		Article article = articleAdminDAO.get(id);
		checkPermission(article, context);
		return article;
	}
	
	public List<Article> getAll(Integer fromIndex, Integer itemCount, Context context) throws ServiceException {
		return articleAdminDAO.getAll(context.getActorAccountId(), fromIndex, itemCount);
	}
	
	public void update(String id, Article article, Context context) throws ServiceException {
		get(id, context); // implicitly performs permission check
		
		setImplicitFields(article, context);
		
		validate(article);
		
		articleAdminDAO.update(id, article);
	}
	
	public void delete(String id, Context context) throws ServiceException {
		get(id, context); // implicitly performs permission check
		
		articleAdminDAO.delete(id);
	}
	
	private void validate(Article article) throws ArticleValidationException {
		ValidationResult result = articleValidator.validate(article);
		if (!result.isValid()) {
			throw new ArticleValidationException(result);
		}
	}
	
	private void setImplicitFields(Article article, Context context) {
		article.setAccountId(context.getActorAccountId());
		article.setLastModifiedAt(context.getActionTimestamp());
	}
	
	private void checkPermission(Article article, Context context) {
		if (context.getActorAccountId().equals(article.getAccountId())) {
			throw new PermissionViolationException(article.getAccountId(), context.getActorAccountId());
		}
	}

}
