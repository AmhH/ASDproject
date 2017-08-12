package edu.mum.framework.dao.impl.concrete;

import edu.mum.framework.dao.impl.AProductDaoImpl;
import edu.mum.framework.domain.concrete.Product;

public class ProductDaoImpl extends AProductDaoImpl<Product>{

	public ProductDaoImpl() {
		super(Product.class, Product.class.getSimpleName());
	}

	
}
