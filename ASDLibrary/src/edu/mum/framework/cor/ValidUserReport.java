package edu.mum.framework.cor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.omg.CORBA.Request;

import edu.mum.framework.domain.AUser;

public class ValidUserReport extends Handler {
  
	@Override
	public void handleRequest(List<AUser> req) {
		/*List<User> validUser=req.stream()
				.filter(x->x.getAge() > 4 
				              && x.getUserStatus()!=null &&
					          ( x.getFirstName().equals("")!=true || x.getLastName().equals("")!=true))
				 .collect(Collectors.toList());
		System.out.println("validUser  :"+  validUser);
		if(nextAgent!=null)
			nextAgent.handleRequest(validUser);*/
		
	}



}
