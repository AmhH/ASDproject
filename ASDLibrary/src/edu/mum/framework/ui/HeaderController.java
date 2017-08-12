package edu.mum.framework.ui;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeaderController implements InitLoader {
	
    @FXML
    private Label label_loggeduser;

    @FXML
    private Menu menu_home;

    @FXML
    private MenuItem menu_listoverdues;

    @FXML
    private MenuItem menu_exit;

    @FXML
    private MenuItem menu_newuser;
    
    @FXML
    private MenuItem menu_list_users;
    
    @FXML
    private MenuItem menu_checkout;
    
    @FXML
    private MenuItem menu_checkin;
    
    @FXML
    private MenuItem menu_home_item;
    
    @FXML
    private MenuItem menu_add_product;
    
    @FXML
    private MenuItem menu_list_products;
    
    @FXML
    private ImageView bg_h_image;

	@Override
	public void loadInitialData() {
		File file = new File(Loader.getInstance().getLoginBGHeaderImage());
        Image image = new Image(file.toURI().toString());
        this.bg_h_image.setImage(image);	
	}
	
	public void goAddProduct(){
		Navigator.getInstance().goAddProduct(this);
	}
	
	public void goAddUser(){
		Navigator.getInstance().goAddUser(this);
	}
	
	public void goHome(){
		Navigator.getInstance().goHome(this);
	}
	
	public void goUserList(){
		Navigator.getInstance().goUserList(this);
	}
	
	public void goProductList(){
		Navigator.getInstance().goProductList(this);
	}
	
	public void closeApp(){
		Navigator.getInstance().exitProgram(Navigator.getInstance());;
	}

	@FXML
    public void initialize() {
		loadInitialData();
    }
}
