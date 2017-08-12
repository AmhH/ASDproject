package edu.mum.app.service;

import edu.mum.app.dao.MemberDao;
import edu.mum.framework.service.impl.UserServiceImpl;

public class MemberService extends UserServiceImpl{

	public MemberService(MemberDao memberDao) {
		super(memberDao);
		
	}

}
