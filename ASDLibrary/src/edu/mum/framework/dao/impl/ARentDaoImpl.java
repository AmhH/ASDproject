package edu.mum.framework.dao.impl;

import edu.mum.framework.dao.RentDao;
import edu.mum.framework.domain.ARent;

public class ARentDaoImpl<T> extends DaoImpl<T> implements RentDao<T>{

	public ARentDaoImpl(Class<T> daoType, String className) {
		super(daoType, className);
	}

	@Override
	public T findRentById(String rentId) {
		return this.findAll().stream()
				  .filter(r -> ((ARent)r).getRentId().equals(rentId))
				  .findFirst()
				  .orElse(null);
	}

}
