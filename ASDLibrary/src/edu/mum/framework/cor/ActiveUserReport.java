package edu.mum.framework.cor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.UserStatus;


public class ActiveUserReport extends Handler{

	@Override
	public void handleRequest(List<AUser> req) {
		List<AUser> activeUser=req.stream().filter(x->x.getUserStatus().equals(UserStatus.ACTIVE)).collect(Collectors.toList());
		System.out.println("activeUser : "+activeUser);
		if(nextAgent!=null)
	    	  nextAgent.handleRequest(activeUser);
		
	}

	

}
