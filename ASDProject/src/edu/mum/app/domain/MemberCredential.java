package edu.mum.app.domain;

import java.io.Serializable;

import edu.mum.framework.domain.ACredential;

public class MemberCredential extends ACredential  implements  Serializable{
	   
	
/**
* 
*/
private static final long serialVersionUID = 1L;

	public MemberCredential(String userName, String password) {
		super(userName, password);
		
	}

	public MemberCredential() {
		
	}
	

}
