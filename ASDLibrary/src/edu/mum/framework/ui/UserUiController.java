package edu.mum.framework.ui;

import java.time.LocalDate;

import edu.mum.framework.controller.UserDirector;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.concrete.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

//import library.businesslogic.Address;
//import library.businesslogic.Member;
//import library.businesslogic.Person;
//import library.businesslogic.PersonDao;

public class UserUiController implements InitLoader {
	
	@FXML
    private AnchorPane header;
	
    @FXML
    private TextField input_phonenumber;

    @FXML
    private TextField input_address;

    @FXML
    private Label msg_error;
    
    @FXML
    private Label title;


    @FXML
    private TextField input_lastname;

    @FXML
    private TextField input_firstname;

    @FXML
    private TextField input_state;

    @FXML
    private TextField input_zipcode;

    @FXML
    private Button btn_submit;

    @FXML
    private TextField input_city;
    
    @FXML
    private TextField input_username;
    
    @FXML
    private DatePicker input_dob;
    
    @FXML
    private PasswordField input_password;
    
    @FXML
    private ChoiceBox<Role> input_role;
    
    private boolean editing = false;
    
    private User editingUser = null;
    
    
    @FXML
    void btn_createmember(ActionEvent event) {
    	if(validateForm()) {
	    	StrategyUser cu = editing ? new UserUpdate() : new UserSave();
	    	
	    	cu.saveObject(editingUser, input_dob.getValue(), input_firstname.getText(),input_lastname.getText(), input_phonenumber.getText(),
	    			input_address.getText(), input_city.getText(), input_state.getText(), Integer.parseInt(input_zipcode.getText()),
	    			input_username.getText(), input_password.getText(), input_role.getValue());
    		
    		clearFields();
    		if(editing){
    			editing = false;
    			input_username.setDisable(false);
    			editingUser = null;
    			Navigator.getInstance().setCurrentJob(null);
    		}
    		Navigator.getInstance().goUserList(this);
    		
    	}
    }
    
    public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	void clearFields(){
    	LocalDate today = LocalDate.now();
    	input_password.setText("");
    	input_username.setText("");
    	input_address.setText("");
    	input_lastname.setText("");
    	input_firstname.setText("");
    	input_state.setText("");
    	input_city.setText("");
    	input_zipcode.setText("");
    	input_phonenumber.setText("");
    	input_dob.setValue(today);
    }
    
    private boolean validateForm(){
    	
    	if(input_username.getText().length() < 6
    			|| input_password.getText().length() < 6
    			|| input_firstname.getText().length() < 1
    			|| input_lastname.getText().length() < 1
    			|| input_phonenumber.getText().length() < 1
    			)
    	{ 
    		displayErrorMsg(); return false; 
    	}
    	
    	if(input_zipcode.getText().equals("")){
    		input_zipcode.setText("00000");
    	}
    	
    	if(!input_zipcode.getText().matches("[0-9]+")){
    		msg_error.setText("Please check the ZipCode Field (Only numbers)");
    		return false;
        }
    	
    	
    	return true;
    }
    
    void displayErrorMsg(){
    	msg_error.setText("There is an error on the form");
    }
    
    
    
    private void loadLists(){
    	input_role.getItems().addAll(Role.values());
    }
    
	@Override
	public void loadInitialData() {
		loadLists();

	}

	@FXML
    public void initialize() {
		loadInitialData();
		if(Navigator.getInstance().getCurrentJob() != null 
				&& Navigator.getInstance().getCurrentJob() instanceof AUser){
			editingUser = (User) Navigator.getInstance().getCurrentJob();
			loadUsertoEdit();
			
		} else {
			title.setText("Add User");
			btn_submit.setText("Create User");
		}
		
    }
	
	private void loadUsertoEdit(){
		editing = true;
		AUser toEdit = (AUser) Navigator.getInstance().getCurrentJob();
		
		title.setText("Editing user " + toEdit.getId());
		btn_submit.setText("Save changes");
		input_password.setText(toEdit.getCredentialA().getPassword());
    	input_username.setText(toEdit.getCredentialA().getUserName());
    	input_username.setDisable(true);
    	input_role.setValue(toEdit.getCredentialA().getUserRole());
    	input_address.setText(toEdit.getAddress().getAddress());
    	input_lastname.setText(toEdit.getLastName());
    	input_firstname.setText(toEdit.getFirstName());
    	input_state.setText(toEdit.getAddress().getState());
    	input_city.setText(toEdit.getAddress().getCity());
    	input_zipcode.setText(Integer.toString(toEdit.getAddress().getZip()));
    	input_phonenumber.setText(toEdit.getPhoneNumber());
    	input_dob.setValue(toEdit.getDob());
		
	}
    



}

