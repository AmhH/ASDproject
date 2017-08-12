package edu.mum.framework.ui;

import java.util.ArrayList;
import java.util.List;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.AUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Navigator implements InitLoader {
	
	private static Navigator instance = new Navigator();
	
	private Navigator(){
		
	}
	
	private Stage primaryStage;
	private Stage navigationStage;
	private Role role;
	private AUser currentuser;
	private Object currentJob;
	
	
	// TEST PURPOSE
	public List<AProduct> temporaryProdList = new ArrayList<>();
	
	
	public static Navigator getInstance(){
		return instance;
	}
	
	public void setPrimaryStage(Stage st){
		instance.primaryStage = st;
	}
	
	public Role getRole(){
		return role;
	}
	

	protected void createStage(){
		this.primaryStage.hide();
		this.navigationStage = new Stage();
		this.navigationStage.setTitle(Loader.getInstance().getAppname());
	}
	
	protected void checkIfOpenedLogin(){
		if(instance.primaryStage.isShowing()) instance.primaryStage.hide();
	}
	
	protected void goHome(Object o){
		setCurrentJob(null);
		goTo(o,"/edu/mum/framework/ui/Home.fxml");
	}
	
	protected void goAddProduct(Object o){
		setCurrentJob(null);
		goTo(o,"/edu/mum/framework/ui/Product.fxml");
	}
	
	protected void goUpdateProduct(Object o, AProduct p){
		setCurrentJob(p);
		goTo(o,"/edu/mum/framework/ui/Product.fxml");
	}
	
	protected void goProductList(Object o){
		setCurrentJob(null);
		goTo(o,"/edu/mum/framework/ui/ProductList.fxml");
	}
	
	protected void goAddUser(Object o){
		setCurrentJob(null);
		goTo(o,"/edu/mum/framework/ui/User.fxml");
	}
	
	protected void goUserList(Object o){
		setCurrentJob(null);
		goTo(o,"/edu/mum/framework/ui/UserList.fxml");
	}
	
	protected void goUpdateUser(Object o, AUser u){
		setCurrentJob(u);
		goTo(o,"/edu/mum/framework/ui/User.fxml");
	}
	
	private void goTo(Object o, String st){
		try{
            FXMLLoader fxmlLoader = new FXMLLoader(o.getClass().getResource(st));
            Parent root1 = (Parent) fxmlLoader.load();
            checkIfOpenedLogin();
            if(navigationStage == null) createStage();
            navigationStage.setScene(new Scene(root1));  
            navigationStage.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	
	public void setCurrentJob(Object cj){
		this.currentJob = cj;
	}
	
	public Object getCurrentJob(){
		return currentJob;
	}
	
	public void clearCurrentJob(){
		this.currentJob = null;
	}
	
	protected void exitProgram(Object o){
		navigationStage.close();
		// should clean any variables
		primaryStage.show();
	}

	@Override
	public void loadInitialData() {
		this.primaryStage.setTitle(Loader.getInstance().getAppname());
	}
	
	
	
	

}
