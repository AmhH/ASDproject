package edu.mum.framework.service.impl;

import java.util.List;

import edu.mum.framework.dao.ProductDao;
import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.concrete.Product;
import edu.mum.framework.service.ProductService;

public class ProductServiceImpl<T> implements ProductService<T>{
     private ProductDao productDao;
     
     public ProductServiceImpl(ProductDao productDao)
     {
    	 this.productDao=productDao;
     }

	@Override
	public void saveProduct(T product) {
		productDao.add(product);
	}

	@Override
	public void deleteProduct(T product) {
		productDao.remove(product);
		
	}

	@Override
	public T findOneProduct(String id) {
		return (T) productDao.findOne(id);
	}

	@Override
	public T findProductByName(String productName) {
		return (T) productDao.findByProductName(productName);
	}

	@Override
	public List<T> findAllProduct() {
		List<T> list=productDao.findAll();
		return list;
	}

	@Override
	public void updateProductById(T product) {
		// TODO Auto-generated method stub
		
	}
	
}
