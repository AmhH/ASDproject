package edu.mum.framework.dao;

import edu.mum.framework.domain.AProduct;

public interface ProductDao<T> extends Dao<T> {
	public void remove(String id);
	public void update(AProduct product);
	public T findOne(String id);
	public T findByProductName(String name);
}
