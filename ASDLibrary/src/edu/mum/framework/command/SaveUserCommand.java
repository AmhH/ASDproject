package edu.mum.framework.command;

import edu.mum.framework.service.UserService;

public class SaveUserCommand<T>implements Command<T> {
  private UserService<T> userService;
  private T objectToBESaved;
  public SaveUserCommand(UserService<T> userService,T objectToBESaved){
	  this.userService=userService;
	  this.objectToBESaved=objectToBESaved;
 }
@Override
public void execute() {
	userService.saveUser(objectToBESaved);
	
}
@Override
public void undo() {
	userService.deleteUser(objectToBESaved);
	
}
}
//Invoker class is not define