package edu.mum.framework.dao;

import edu.mum.framework.domain.ACategory;

public interface CategoryDao<T> extends Dao<T>{
	void update(ACategory category);
	T findCategoryByBame(String name);
	T findCategoryById(String id);
}
