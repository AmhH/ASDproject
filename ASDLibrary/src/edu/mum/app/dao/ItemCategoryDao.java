package edu.mum.app.dao;

import edu.mum.app.domain.ItemCategory;
import edu.mum.framework.dao.impl.ACategoryDaoImpl;

public class ItemCategoryDao extends ACategoryDaoImpl<ItemCategory>{

	public ItemCategoryDao() {
		super(ItemCategory.class, ItemCategory.class.getSimpleName());
	}
}
