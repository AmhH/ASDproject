package edu.mum.framework.dao.impl.util;

import edu.mum.framework.dao.CategoryDao;
import edu.mum.framework.dao.CredentialDao;
import edu.mum.framework.dao.ProductDao;
import edu.mum.framework.dao.RentDao;
import edu.mum.framework.dao.UserDao;
import edu.mum.framework.dao.impl.ACategoryDaoImpl;
import edu.mum.framework.dao.impl.ACredentialDaoImpl;
import edu.mum.framework.dao.impl.AProductDaoImpl;
import edu.mum.framework.dao.impl.ARentDaoImpl;
import edu.mum.framework.dao.impl.AUserDaoImpl;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class DaoFactory {
	private static volatile CategoryDao categoryDao = null;
	private static volatile CredentialDao credentialDao = null;
	private static volatile ProductDao productDao = null;
	private static volatile RentDao rentDao = null;
	private static volatile UserDao userDao = null;
	
	private DaoFactory(){}
	public static<T> CategoryDao getCategoryDao(Class<T> daoType, String className) {
		if(categoryDao == null)
			categoryDao = new ACategoryDaoImpl(daoType, className);
		return categoryDao;
	}

	public static<T> CredentialDao getCredentialDao(Class<T> daoType, String className) {
		if(credentialDao == null)
			credentialDao = new ACredentialDaoImpl(daoType, className);
		return credentialDao;
	}

	public static<T> ProductDao getProductDao(Class<T> daoType, String className) {
		if(productDao == null)
			productDao = new AProductDaoImpl(daoType, className);
		return productDao;
	}

	public static<T> RentDao getRentDao(Class<T> daoType, String className) {
		if(rentDao == null)
			rentDao = new ARentDaoImpl(daoType, className);
		return rentDao;
	}
	
	public static<T> UserDao getUserDao(Class<T> daoType, String className) {
		if(userDao == null)
			userDao = new AUserDaoImpl(daoType, className);
		return userDao;
	}
}