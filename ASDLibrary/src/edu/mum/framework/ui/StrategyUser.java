package edu.mum.framework.ui;

import java.time.LocalDate;

import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.concrete.User;

public interface StrategyUser {
	public boolean saveObject(User u, LocalDate dob, String fn, String ln, String pn, String address, String city, String state, int zip, String username, String password, Role role);
	
}
