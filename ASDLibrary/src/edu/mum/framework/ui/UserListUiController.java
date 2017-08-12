package edu.mum.framework.ui;


import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import edu.mum.app.domain.Member;
import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.Address;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.concrete.Credential;
import edu.mum.framework.domain.concrete.Product;
import edu.mum.framework.domain.concrete.User;
import edu.mum.framework.service.ProductService;
import edu.mum.framework.service.UserService;
import edu.mum.framework.domain.UserStatus;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserListUiController implements Initializable {

    @FXML
    private TableView<AUser> users_table;
    
    @FXML
    private TableColumn<AUser, String> col_lastname;

    @FXML
    private TableColumn<AUser, String> col_userid;

    @FXML
    private TableColumn<AUser, String> col_firstname;

    @FXML
    private TableColumn<AUser, String> col_phone;
    
    @FXML
    private TableColumn<AUser, AUser> col_action1;
    
    @FXML
    private TableColumn<AUser, AUser> col_action;
    
    

    @FXML
    private Label current_booktitle;

    @FXML
    private Button btn_search;

    @FXML
    private TextField input_search;
    
    private List<User> userlist;


   


    @FXML
    void search(ActionEvent event) {
    	loadInitialUserlist();
    	
    	CharSequence textToSearch = input_search.getText().toLowerCase();
		
		List<User> toRet = userlist.stream()
				.filter(x -> x.getId().toLowerCase().contains(textToSearch) 
						|| x.getCredentialA().getUserName().toLowerCase().contains(textToSearch)
						|| x.getFirstName().toLowerCase().contains(textToSearch)
						|| x.getLastName().toLowerCase().contains(textToSearch))
				.collect(Collectors.toList());
		loadUserlist(toRet);
    	
    }



    private void loadUserlist(List<User> list){
  
    	ObservableList<AUser> usersList = FXCollections
				.observableArrayList(list);
    	
    	users_table.getColumns().remove(col_action);
		users_table.getColumns().remove(col_action1);

    	col_firstname.setSortable(true);
    	col_userid.setSortable(true);
    	col_userid.setCellValueFactory(new PropertyValueFactory<AUser, String>("id"));
		col_firstname.setCellValueFactory(new PropertyValueFactory<AUser, String>("firstName"));
		col_lastname.setCellValueFactory(new PropertyValueFactory<AUser, String>("lastName"));
		col_phone.setCellValueFactory(new PropertyValueFactory<AUser, String>("phoneNumber"));
		//col_action.setCellValueFactory(new PropertyValueFactory<User,EditButton>(this));

		
		col_action = new TableColumn<>("View");
		col_action.setMinWidth(40);
		col_action.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));

		col_action.setCellFactory(param -> new TableCell<AUser, AUser>() {
            private final Button viewButton = new Button("View");
            @Override
            protected void updateItem(AUser user, boolean empty) {
                super.updateItem(user, empty);
                if (user == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(viewButton);
                viewButton.setOnAction(event -> System.out.println("Something happened " + user.getFirstName()));
            }
        });
		
		
		col_action1 = new TableColumn<>("Edit");
		col_action1.setMinWidth(40);
		col_action1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));

		col_action1.setCellFactory(param -> new TableCell<AUser, AUser>() {
            private final Button editButton = new Button("Edit");
            @Override
            protected void updateItem(AUser user, boolean empty) {
                super.updateItem(user, empty);
                if (user == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(editButton);
                editButton.setOnAction(event -> Navigator.getInstance().goUpdateUser(this, user));
            }
        });
		
		users_table.getItems().setAll(usersList);
		users_table.getColumns().add(col_action);
		users_table.getColumns().add(col_action1);
		

    }
    
    private void loadInitialUserlist(){
    	edu.mum.framework.controller.UserController uc = edu.mum.framework.controller.UserController.getUserController();
    	UserService<User> userService = uc.getUserServices();
		
    
    	userlist = userService.findAllUser();
    	
    	this.loadUserlist(userlist);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadInitialUserlist();
		
	}
	
	public void clearTable() {
		for (int i = 0; i < users_table.getItems().size(); i++) {

			users_table.getItems().clear();

		}

	}
    
    


}
