package edu.mum.framework.controller;

import java.time.LocalDate;

import edu.mum.framework.domain.Address;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.UserStatus;
import edu.mum.framework.domain.concrete.Credential;
import edu.mum.framework.domain.concrete.User;
import edu.mum.framework.generator.id.AutoGenerate;
import edu.mum.framework.generator.id.IDGenerator;
import edu.mum.framework.service.CredentialService;
import edu.mum.framework.service.UserService;
import edu.mum.framework.service.factory.ServiceFactory;


public class UserCreator implements UserBuilder{
	AutoGenerate autoGenerate;
	User user;
	@SuppressWarnings("unchecked")
	UserService<User> userService = ServiceFactory.createUserService(User.class, User.class.getSimpleName());
	@SuppressWarnings("unchecked")
	CredentialService<Credential> credentialService = ServiceFactory.createCredentialService
			(Credential.class, Credential.class.getSimpleName());
	public void userInfo(LocalDate dob, String firstName, String lastName, String phoneNumber){
		autoGenerate = IDGenerator.getInstance();
		String id = autoGenerate.getUniqueId(User.class.getSimpleName());
		user = new User(id, dob,firstName, lastName, phoneNumber);
		
	}
	
	@Override
	public void buildAddress(String address, String city, String state, int zip) {
		user.setAddress(new Address(address, city, state, zip));	
	}
	
	@Override
	public void buildCredential(String userName, String password, Role role) {
		Credential credential = new Credential(userName, password, role);
		credentialService.saveCredential(credential);
		user.setCredentialA(credential);;
	}
	
	@Override
	public User createFullUser() {
		userService.saveUser(user);
		return user;
	}

	@Override
	public void buildStatus(UserStatus userStatus) {
		user.setUserStatus(userStatus);	
	}
}
