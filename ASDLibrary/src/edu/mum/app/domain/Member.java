package edu.mum.app.domain;


import java.time.LocalDate;

import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.Address;
import edu.mum.framework.domain.UserStatus;

public class Member extends AUser{
	   
public Member(String id, LocalDate dob, String firstName, String lastName, String phoneNumber) {
		super(id, dob, firstName, lastName, phoneNumber);
		
	}

private static final long serialVersionUID = 1L;

	
}
