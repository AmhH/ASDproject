package edu.mum.framework.dao;

public interface UserDao<T> extends Dao<T> {
	public void remove(String id);
	public void update(T user);
	public T findOne(String id);	
	public T findByUserName(String userName);
	
}
