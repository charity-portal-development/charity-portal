package com.charityportal.core.dao;

import java.util.List;

import com.charityportal.core.dao.exceptions.DataAccessException;
import com.charityportal.core.model.entities.Article;

public interface ArticleAdminDAO {
	
	void create(String id, Article article) throws DataAccessException;

	Article get(String id) throws DataAccessException;
	
	List<Article> getAll(String accountId, Integer fromIndex, Integer itemCount) throws DataAccessException;
	
	void update(String id, Article article) throws DataAccessException;
	
	void delete(String id) throws DataAccessException;

}
