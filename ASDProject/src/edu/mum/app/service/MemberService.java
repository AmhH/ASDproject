package edu.mum.app.service;

import edu.mum.app.dao.MemberDao;
import edu.mum.app.domain.Member;
import edu.mum.framework.service.impl.UserServiceImpl;

public class MemberService extends UserServiceImpl<Member>{

	public MemberService(MemberDao memberDao) {
		super(memberDao);
		
	}

}
