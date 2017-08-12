package edu.mum.framework.dao.impl.concrete;

import edu.mum.framework.dao.impl.ACategoryDaoImpl;
import edu.mum.framework.domain.concrete.Category;

public class CategoryDaoImpl extends ACategoryDaoImpl<Category>{

	public CategoryDaoImpl() {
		super(Category.class, Category.class.getSimpleName());
	}

	
}
