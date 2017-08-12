package edu.mum.framework.controller;

import edu.mum.framework.domain.concrete.User;
import edu.mum.framework.service.UserService;
import edu.mum.framework.service.factory.ServiceFactory;

public class UserController<T> {
	
	
	UserDirector userDirector = new UserDirector(new UserCreator());
	Class<T> classType;
	public UserController(Class<T> classType) {
		this.classType = classType;
	}
	
	public UserDirector getUserDirector(){
		return userDirector;
	}
	
	@SuppressWarnings("unchecked")
	public UserService<T> getUserServices(){
		return ServiceFactory.createUserService(classType.getClass(), 
				classType.getClass().getSimpleName());
	}

	public static UserController getUserController() {
		return new UserController<>(User.class);
	}
}
