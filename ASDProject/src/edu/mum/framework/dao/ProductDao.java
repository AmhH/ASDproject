package edu.mum.framework.dao;

public interface ProductDao<T> extends Dao<T> {
	public void remove(String id);
	public void update(T product);
	public T findOne(String id);
	public T findByProductName(String name);
}
