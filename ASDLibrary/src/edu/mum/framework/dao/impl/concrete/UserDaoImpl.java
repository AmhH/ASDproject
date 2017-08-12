package edu.mum.framework.dao.impl.concrete;

import edu.mum.framework.dao.impl.AUserDaoImpl;
import edu.mum.framework.domain.concrete.User;

public class UserDaoImpl extends AUserDaoImpl<User>{

	public UserDaoImpl() {
		super(User.class, User.class.getSimpleName());
	}

	
}
