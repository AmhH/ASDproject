package edu.mum.framework.domain;

import java.io.Serializable;

public abstract class ACredential implements Serializable{
	   
private static final long serialVersionUID = 1L;
private String userName;
private String password;
private Role userRole;

public String getUserName() {
	return userName;
}

@Override
public String toString() {
	return "Credential [userName=" + userName + ", password=" + password + ", userRole=" + userRole + "]";
}

public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public ACredential(String userName, String password,Role userRole) {
	this.userName = userName;
	this.password = password;
	this.userRole=userRole;
}

public Role getUserRole() {
	return userRole;
}

public void setUserRole(Role userRole) {
	this.userRole = userRole;
}



}
