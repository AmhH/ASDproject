package edu.mum.framework.controller;

import edu.mum.framework.service.CredentialService;
import edu.mum.framework.service.factory.ServiceFactory;

public class LoginController<T>{
	
	private Class<T> classType;
	
	public LoginController(Class<T> classType) {
		this.classType = classType;
	}

	public boolean authenticateUser(String userName, String password){
		
		/*Any class can extend this class and use the authenticate method by passing a 
		 * concrete class*/		
		@SuppressWarnings("unchecked")
		CredentialService<T> cs = ServiceFactory.createCredentialService(classType, 
				classType.getSimpleName());
		return  cs.login(userName, password);	
	}	
}
