package edu.mum.framework.service;

import java.util.List;

import edu.mum.framework.domain.ACategory;
import edu.mum.framework.domain.concrete.Category;

public interface CategoryService{
	public void saveCategory(Category category);
	public void deleteCategory(Category category);
	public void updateCategor(Category category);
	public Category findOneCategory(String id);
	public Category findCategoryByName(String categoryName);
	public List<Category> findAllCategory();

}
