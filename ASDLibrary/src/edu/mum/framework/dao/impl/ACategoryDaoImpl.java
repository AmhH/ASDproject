package edu.mum.framework.dao.impl;

import edu.mum.framework.dao.CategoryDao;
import edu.mum.framework.domain.ACategory;

public class ACategoryDaoImpl<T> extends DaoImpl<T> implements CategoryDao<T>{

	public ACategoryDaoImpl(Class<T> daoType, String className) {
		super(daoType, className);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(ACategory category) {
		this.findAll().remove(findCategoryById(category.getCategoryId()));
		this.add((T) category);
	}

	@Override
	public T findCategoryByBame(String name) {
		return this.findAll().stream()
				  .filter(c -> ((ACategory)c).getCategoryName().equals(name))
				  .findFirst()
				  .orElse(null);
	}

	@Override
	public T findCategoryById(String id) {
		return this.findAll().stream()
				  .filter(c -> ((ACategory)c).getCategoryId().equals(id))
				  .findFirst()
				  .orElse(null);
	}
}
