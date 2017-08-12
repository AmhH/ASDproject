package edu.mum.app.dao;

import edu.mum.app.domain.MemberCredential;
import edu.mum.framework.dao.impl.ACredentialDaoImpl;

public class MemberCredentialDao extends ACredentialDaoImpl<MemberCredential>{

	public MemberCredentialDao() {
		super(MemberCredential.class, MemberCredential.class.getSimpleName());
	}
}
