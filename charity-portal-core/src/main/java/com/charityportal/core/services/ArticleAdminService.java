package com.charityportal.core.services;

import java.util.List;

import com.charityportal.core.dao.ArticleAdminDAO;
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
	
	public String create(Article article, String actorAccountId) throws ServiceException {
		article.setAccountId(actorAccountId);
		validate(article);
		String id = Utilities.randomUUID();
		articleAdminDAO.create(id, article);
		return id;
	}

	public Article get(String id, String actorAccountId) throws ServiceException {
		Article article = articleAdminDAO.get(id);
		checkPermission(article, actorAccountId);
		return article;
	}
	
	public List<Article> getAll(Integer fromIndex, Integer itemCount, String actorAccountId) throws ServiceException {
		return articleAdminDAO.getAll(actorAccountId, fromIndex, itemCount);
	}
	
	public void update(String id, Article article, String actorAccountId) throws ServiceException {
		get(id, actorAccountId); // implicitly performs permission check
		article.setAccountId(actorAccountId);
		validate(article);
		articleAdminDAO.update(id, article);
	}
	
	public void delete(String id, String actorAccountId) throws ServiceException {
		get(id, actorAccountId); // implicitly performs permission check
		articleAdminDAO.delete(id);
	}
	
	private void validate(Article article) throws ArticleValidationException {
		ValidationResult result = articleValidator.validate(article);
		if (!result.isValid()) {
			throw new ArticleValidationException(result);
		}
	}
	
	private void checkPermission(Article article, String actorAccountId) {
		if (actorAccountId.equals(article.getAccountId())) {
			throw new PermissionViolationException(article.getAccountId(), actorAccountId);
		}
	}

}
