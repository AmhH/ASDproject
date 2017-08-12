package edu.mum.app.dao;

import edu.mum.app.domain.Member;
import edu.mum.framework.dao.impl.AUserDaoImpl;

public class MemberDao extends AUserDaoImpl<Member>{

	public MemberDao() {
		super(Member.class, Member.class.getSimpleName());
	}
}
