package edu.mum.framework.ui;

import java.time.LocalDate;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.concrete.User;

public class UserUpdate implements StrategyUser {

	@Override
	public boolean saveObject(User u, LocalDate dob, String fn, String ln, String pn, String address, String city,
			String state, int zip, String username, String password, Role role) {
		
		try {
			edu.mum.framework.controller.UserController uc = edu.mum.framework.controller.UserController.getUserController();
			
			User user = u;
			
			user.setDob(dob);
			user.setFirstName(fn);
			user.setLastName(ln);
			user.setPhoneNumber(pn);
			
			user.getAddress().setAddress(address);
			user.getAddress().setCity(city);
			user.getAddress().setState(state);
			user.getAddress().setZip(zip);
			
			user.getCredentialA().setUserName(username);
			user.getCredentialA().setPassword(password);
			user.getCredentialA().setUserRole(role);
			
	   		uc.getUserServices().updateUser(user);
	   		return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

}
