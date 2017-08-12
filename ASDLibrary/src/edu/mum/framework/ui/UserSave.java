package edu.mum.framework.ui;

import java.time.LocalDate;

import edu.mum.framework.controller.UserDirector;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.concrete.User;

public class UserSave implements StrategyUser {

	@Override
	public boolean saveObject(User u, LocalDate dob, String fn, String ln, String pn, String address, String city, String state, int zip, String username, String password, Role role) {
		
		try {
			edu.mum.framework.controller.UserController uc = edu.mum.framework.controller.UserController.getUserController();
			UserDirector ud = uc.getUserDirector();
			
			ud.userInfo(dob, fn, ln, pn);
			ud.userAddress(address, city, state, zip);
			ud.userCredential(username, password, role);
			User user = ud.createFullUser();
			return true;
		} catch (Exception e){
			System.err.println(e.getMessage());
			return false;
		}
	}

}
