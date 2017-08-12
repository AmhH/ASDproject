package edu.mum.framework.domain.concrete;

import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.Role;

public class Credential extends ACredential {

	private static final long serialVersionUID = 1L;

	public Credential(String userName, String password, Role userRole) {
		super(userName, password, userRole);
		
	}

	
}
