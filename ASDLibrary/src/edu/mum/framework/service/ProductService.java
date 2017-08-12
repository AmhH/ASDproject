package edu.mum.framework.service;

import java.util.List;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.concrete.Product;

public interface ProductService<T> {
	public void saveProduct(T product);
	public void deleteProduct(T product);
	public void updateProductById(T product);
	public T findOneProduct(String id);
	public T findProductByName(String productName);
	public List<T> findAllProduct();
	
}
