package edu.mum.framework.dao;

public interface RentDao<T> extends Dao<T>{
	T findRentById(String rentId);
}
