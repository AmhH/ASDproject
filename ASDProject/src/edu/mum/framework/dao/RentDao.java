package edu.mum.framework.dao;

public interface RentDao<T> extends Dao<T>{
	T findRentById(String rentId);
	void update(T rent);
	T findOneById(String id);
	void remove(String id);
}
