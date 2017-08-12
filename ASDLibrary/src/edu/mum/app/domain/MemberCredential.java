package edu.mum.app.domain;

import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.Role;

public class MemberCredential extends ACredential{

	
	private static final long serialVersionUID = 1L;

	public MemberCredential(String userName, String password, Role userRole) {
		super(userName, password, userRole);
		
	}
	   
	
}
