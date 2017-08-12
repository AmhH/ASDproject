package edu.mum.framework.service.impl;

import java.util.List;

import edu.mum.framework.dao.UserDao;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.service.UserService;

public class  UserServiceImpl<T> implements UserService<T>{
     private UserDao userDao;
     
     public UserServiceImpl(UserDao userDao){
    	 this.userDao=userDao;
     }

	@Override
	public void saveUser(T user) {
		userDao.add(user);
	}

	@Override
	public void deleteUser(T user) {
		userDao.remove(user);
	}

	@Override
	public void updateUserById(String id) {
		//userDao.update(T);
	}

	@Override
	public void updateUser(T user) {
	   //userDao.update(user)
		
	}

	@Override
	public T findOneUser(String id) {
	    return  (T) userDao.findOne(id);
	}

	@Override
	public T findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllUser() {
		return (List<T>) userDao.findAll();
	}
	
}
