package edu.mum.framework.domain.concrete;

import java.time.LocalDate;

import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.Address;
import edu.mum.framework.domain.UserStatus;

public class User extends AUser {

	public User(String id, LocalDate dob, String firstName, String lastName, String phoneNumber) {
		super(id, dob, firstName, lastName, phoneNumber);
		
	}

	
}
