package edu.mum.framework.controller;

import java.time.LocalDate;

import edu.mum.framework.domain.concrete.User;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.UserStatus;

public interface UserBuilder {
	public void buildAddress(String address, String city, String state, int zip);
	public void buildCredential(String userName, String password, Role role);
	public void buildStatus(UserStatus userStatus);
	public void userInfo(LocalDate dob, String firstName, String lastName, String phoneNumber);
	public User createFullUser();
}
