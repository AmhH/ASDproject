package edu.mum.framework.dao.impl;

import edu.mum.framework.dao.UserDao;
import edu.mum.framework.domain.AUser;

public class AUserDaoImpl<T> extends DaoImpl<T> implements UserDao<T>{

	public AUserDaoImpl(Class<T> daoType, String className) {
		super(daoType, className);
	}

	@Override
	public void remove(String id) {
		this.findAll().remove(findOne(id));
		write();
	}

	@Override
	public void update(T user) {
		//this.findAll().remove(findOne(((AUser) user).getId()));
		remove(((AUser) user).getId());
		this.add((T) user);
	}

	@Override
	public T findOne(String id) {
		return this.findAll().stream()
				  .filter(p -> ((AUser)p).getId().equals(id))
				  .findFirst()
				  .orElse(null);
	}

	@Override
	public T findByUserName(String name) {
		return this.findAll().stream()
				  .filter(p -> ((AUser)p).getFirstName().equals(name))
				  .findFirst()
				  .orElse(null);
	}
}
