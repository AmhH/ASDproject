package edu.mum.framework.ui;

import java.io.File;

import edu.mum.framework.domain.concrete.Credential;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController implements InitLoader {

	@FXML
	private Button btn_signin;

	@FXML
	private PasswordField input_password;

	@FXML
	private TextField input_idnumber;
	
	@FXML
	private Label apptitle;

	@FXML
	private Label msg_error;
	
	@FXML
	private ImageView bg_image;
	

	@FXML
	void input_idnumber(ActionEvent event) {

	}

	@FXML
	void input_password(ActionEvent event) {

	}

	@FXML
	void btn_signin(ActionEvent event) {
		edu.mum.framework.controller.LoginController<Credential> lc = new edu.mum.framework.controller.LoginController<Credential>(Credential.class);
		
		if(input_idnumber.getText().length() < 6 || input_password.getText().length() < 6 ) {
			msg_error.setText("Please type complete username and password");
			return;
		}
		
		if(lc.authenticateUser(input_idnumber.getText(), input_password.getText())) {
			clean_form();
			Navigator.getInstance().goHome(this);
		} else {
			msg_error.setText("Username and password not correct");
		}
			
	}
	
	void clean_form() {
		input_password.setText("");
		input_idnumber.setText("");
		msg_error.setText("");
	}
	
	@FXML
    public void initialize() {
		loadInitialData();
    }

	@Override
	public void loadInitialData() {
		this.apptitle.setText(Loader.getInstance().getAppname());
		File file = new File(Loader.getInstance().getLoginBGImage());
        Image image = new Image(file.toURI().toString());
        this.bg_image.setImage(image);
		
	}

}
