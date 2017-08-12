package edu.mum.framework.service.impl;

import java.util.List;

import edu.mum.framework.dao.CategoryDao;
import edu.mum.framework.domain.ACategory;
import edu.mum.framework.domain.concrete.Category;
import edu.mum.framework.service.CategoryService;

public class  CategoryServiceImpl<T> implements CategoryService {
   
     private CategoryDao  categoryDao;

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategor(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findOneCategory(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}
     
    
}
