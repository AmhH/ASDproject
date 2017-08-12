package edu.mum.framework.cor;

public class ChainBuilder {
	private Handler handler;
	public Handler getHandler() {
		chainBuilder();
		return handler;
	}
	public void setHandler(Handler handler) {
		
		this.handler = handler;
	}
	public void chainBuilder(){
	  Handler validUser=new ValidUserReport();
	  Handler activeUserReport=new ActiveUserReport();
	  Handler UserAgeReport=new UserAgeReport();
	  validUser.nextAgent=activeUserReport;
	  activeUserReport.nextAgent=UserAgeReport;
	  handler=validUser;
	}
}
