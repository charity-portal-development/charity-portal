package com.charityportal.core.services;

import java.util.List;

import com.charityportal.core.dao.ArticleAdminDAO;
import com.charityportal.core.model.entities.Article;
import com.charityportal.core.model.validators.ArticleValidator;
import com.charityportal.core.model.validators.ValidationResult;
import com.charityportal.core.services.exceptions.ArticleValidationException;
import com.charityportal.core.services.exceptions.ServiceException;
import com.charityportal.core.util.Utilities;

public class ArticleAdminService {
	
	private ArticleAdminDAO articleAdminDAO;
	
	private ArticleValidator articleValidator;
	
	public String create(Article article) throws ServiceException {
		validate(article);
		String id = Utilities.randomUUID();
		articleAdminDAO.create(id, article);
		return id;
	}

	public Article get(String id) throws ServiceException {
		// FIXME check permission to get article
		return articleAdminDAO.get(id);
	}
	
	public List<Article> getAll(Integer fromIndex, Integer itemCount) throws ServiceException {
		// FIXME get only those articles which belong to the account
		return articleAdminDAO.getAll(fromIndex, itemCount);
	}
	
	public void update(String id, Article article) throws ServiceException {
		validate(article);
		// FIXME check permission to update article
		articleAdminDAO.update(id, article);
	}
	
	public void delete(String id) throws ServiceException {
		// FIXME check permission to delete article
		articleAdminDAO.delete(id);
	}
	
	private void validate(Article article) throws ArticleValidationException {
		ValidationResult result = articleValidator.validate(article);
		if (!result.isValid()) {
			throw new ArticleValidationException(result);
		}
	}

}
