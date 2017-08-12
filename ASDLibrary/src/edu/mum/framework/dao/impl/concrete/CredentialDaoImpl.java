package edu.mum.framework.dao.impl.concrete;

import edu.mum.framework.dao.impl.ACredentialDaoImpl;
import edu.mum.framework.domain.concrete.Credential;

public class CredentialDaoImpl extends ACredentialDaoImpl<Credential>{

	public CredentialDaoImpl() {
		super(Credential.class, Credential.class.getSimpleName());
	}

	
}
