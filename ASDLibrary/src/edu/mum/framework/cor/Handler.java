package edu.mum.framework.cor;

import java.util.List;

import org.omg.CORBA.Request;

import edu.mum.framework.domain.AUser;

public abstract class Handler {
   protected Handler nextAgent;
  

abstract public void handleRequest(List<AUser> req);
   boolean canHandleRequest(Request req)
   {
	return false;
	 
   }
}
