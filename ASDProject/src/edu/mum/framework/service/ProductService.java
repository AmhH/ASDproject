package edu.mum.framework.service;

import java.util.List;

public interface ProductService<T> {
	public void saveProduct(T product);
	public void deleteProduct(T product);
	public void updateProductById(T product);
	public T findOneProduct(String id);
	public T findProductByName(String productName);
	public List<T> findAllProduct();
	
}
