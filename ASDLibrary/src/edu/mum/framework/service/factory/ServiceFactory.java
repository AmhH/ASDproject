package edu.mum.framework.service.factory;

import edu.mum.framework.dao.impl.util.DaoFactory;
import edu.mum.framework.service.CategoryService;
import edu.mum.framework.service.CredentialService;
import edu.mum.framework.service.ProductService;
import edu.mum.framework.service.RentService;
import edu.mum.framework.service.UserService;
import edu.mum.framework.service.impl.CategoryServiceImpl;
import edu.mum.framework.service.impl.CredentialServiceImpl;
import edu.mum.framework.service.impl.ProductServiceImpl;
import edu.mum.framework.service.impl.RentServiceImpl;
import edu.mum.framework.service.impl.UserServiceImpl;

public class ServiceFactory<T> {
	private static volatile ProductService productService;
	private static volatile UserService userService;
	private static volatile CategoryService categoryService;
	private static volatile CredentialService credentialService;
	private static volatile RentService rentService;
	
	public static <T> ProductService createProductService(Class<T> daoType, String className) {
		if(null == productService) {
			synchronized(ServiceFactory.class) {
				if(null == productService) {
					
					ProductService productServiceImpl = new ProductServiceImpl(DaoFactory.getProductDao(daoType, className));
					productService = productServiceImpl;
				}
			}
		}
		
		return productService;
	}
	
	public static <T> UserService createUserService(Class<T> daoType, String className) {
		if(null == userService) {
			synchronized(ServiceFactory.class) {
				if(null == userService) {
					UserService userServiceImpl =new UserServiceImpl(DaoFactory.getUserDao(daoType, className));
				userService = userServiceImpl;

		    }
		}
	}
		return userService;
  }
	
	
	/*public static <T> CategoryService createCategoryService(Class<T> daoType, String className) {
		if(null == categoryService) {
			synchronized(ServiceFactory.class) {
				if(null == categoryService) {
			           CategoryService categoryServiceImpl = new CategoryServiceImpl(DaoFactory.getCategoryDao(daoType, className));
					categoryService = categoryServiceImpl;
				}
			}
		}
		return categoryService;
	}*/
	
	public static <T> CredentialService  createCredentialService(Class<T> daoType, String className) {
		if(null == credentialService) {
			synchronized(ServiceFactory.class) {
				if(null == credentialService) {
					   CredentialService categoryServiceImpl = new CredentialServiceImpl(DaoFactory.getCredentialDao(daoType, className));
			            credentialService = categoryServiceImpl;
				}
			}
		}
		return credentialService;
	}
	
	public static <T> RentService createRenttService(Class<T> daoType, String className) {
		if(null == rentService) {
			synchronized(ServiceFactory.class) {
				if(null == rentService) {
					
					RentService rentServiceImpl = new RentServiceImpl(DaoFactory.getRentDao(daoType, className));
					rentService =rentServiceImpl;
				}
			}
		}
		
		return rentService;
	}
}
