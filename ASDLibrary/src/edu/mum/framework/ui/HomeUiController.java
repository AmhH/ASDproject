package edu.mum.framework.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeUiController implements InitLoader {
	
	@FXML
	private Label app_name;
	
	@FXML
	private Label qty_products;
	
	@FXML
	private Label qty_users;
	
	@FXML
	private Label qty_available_products;
	
	@FXML
	private Label msg_error;
	
	@FXML
	private Button btn_checkin;
	
	@FXML
	private Button btn_checkout;
	
	@FXML
	private Button btn_listUsers;
	
	@FXML
	private Button btn_adduser;
	
	@FXML
	private Button btn_checkOverdue;
	
	@Override
	public void loadInitialData() {
		app_name.setText(Loader.getInstance().getAppname());
		qty_users.setText(""+
				edu.mum.framework.controller.UserController.getUserController().getUserServices().findAllUser().size());

	}
	
	public void btn_checkin(){
		
	}
	
	public void btn_checkout(){
		
	}
	public void btn_listUsers() {
		Navigator.getInstance().goUserList(this);
	}
	
	public void btn_listProducts() {
		Navigator.getInstance().goProductList(this);
	}
	
	public void btn_adduser(){
		Navigator.getInstance().goAddUser(this);
	}
	
	public void btn_listuser(){
		Navigator.getInstance().goUserList(this);
	}
	
	public void btn_checkOverdue(){
		
	}
	

	@FXML
    public void initialize() {
		loadInitialData();
    }
	
}
