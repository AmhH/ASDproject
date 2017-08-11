package edu.mum.app.domain;

import java.io.Serializable;
import java.time.LocalDate;

import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.Address;
import edu.mum.framework.domain.UserStatus;

public class Member extends AUser implements  Serializable{
	   
	
/**
* 
*/
private static final long serialVersionUID = 1L;
	public Member() {
	}

	public Member(String id, LocalDate dob, String firstName, String lastName, String phoneNumber, Address address,
			UserStatus userStatus, ACredential credential) {
		super(id, dob, firstName, lastName, phoneNumber, address, userStatus, credential);
		// TODO Auto-generated constructor stub
	}

}
