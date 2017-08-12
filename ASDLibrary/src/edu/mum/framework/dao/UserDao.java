package edu.mum.framework.dao;

import edu.mum.framework.domain.AUser;

public interface UserDao<T> extends Dao<T> {
	public void remove(String id);
	public void update(AUser user);
	public T findOne(String id);	
	public T findByUserName(String userName);
	
}
