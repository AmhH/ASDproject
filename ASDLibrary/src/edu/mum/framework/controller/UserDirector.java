package edu.mum.framework.controller;

import java.time.LocalDate;

import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.UserStatus;
import edu.mum.framework.domain.concrete.User;

public class UserDirector {
	UserBuilder userBuilder = null;
	public UserDirector(UserBuilder userBuilder){
		this.userBuilder = userBuilder;
	}
	
	public void userInfo(LocalDate dob, String firstName, String lastName, String phoneNumber){
		userBuilder.userInfo(dob, firstName, lastName, phoneNumber);
	}
	
	public void userAddress(String address, String city, String state, int zip){
		userBuilder.buildAddress(address, city, state, zip);
	}
	public void userCredential(String userName, String password, Role role){
		userBuilder.buildCredential(userName, password, role);
	}
	public void userStatus(UserStatus userStatus){
		userBuilder.buildStatus(userStatus);;
	}
	public User createFullUser(){
		return userBuilder.createFullUser();
	}
}
