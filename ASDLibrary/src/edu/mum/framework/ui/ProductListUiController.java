package edu.mum.framework.ui;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import edu.mum.app.domain.Book;
import edu.mum.app.domain.Magazine;
import edu.mum.app.domain.Member;
import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Address;
import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.Unit;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.UserStatus;
import edu.mum.framework.domain.concrete.Category;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductListUiController implements InitLoader, Initializable {

	@FXML
	private TextField input_search;

	@FXML
	private Button btn_search;

	@FXML
	private TableView<AProduct> products_table;

	@FXML
	private TableColumn<AProduct, String> col_id;
	
	@FXML
	private TableColumn<AProduct, String> col_name;

	@FXML
	private TableColumn<AProduct, AProduct> col_type;
	
	@FXML
	private TableColumn<AProduct, AProduct> col_action;
	

	private List<AProduct> productlist;


	public void search(){
		loadInitialProductlist();
		CharSequence textToSearch = input_search.getText().toLowerCase();
		
		List<AProduct> toRet = productlist.stream()
				.filter(x -> x.getProductId().toLowerCase().contains(textToSearch) || x.getProdcutName().toLowerCase().contains(textToSearch))
				.collect(Collectors.toList());
		loadUserlist(toRet);
	}

	@Override
	public void loadInitialData() {

	}


	private void loadInitialProductlist(){
    	// Test code
		
//		AProduct p1 = new Book("Book1", "idbo1", "Description", true, 10, "Category" , Unit.DAILY, "publisher", "2010", "1", "ISBN 008",
//    			1, "Author");
//		AProduct p2 = new Book("Book2", "idbo2", "Description", true, 10, "Cat1" , Unit.DAILY, "Hill", "2010", "1", "ISBN 008",
//    			1, "Author");
//		AProduct m1 = new Magazine("Mag1", "m001", "Mag desc", true, 40, "Cat2", Unit.HOURLY);
//

    	// Consume controller responds with an User List.
//
//    	productlist = Arrays.asList(p1,p2,m1);

    	//productlist = new ControllerUser().getCompleteList();

    	this.loadUserlist(productlist);
    }


	private void loadUserlist(List<AProduct> productlist2) {
		products_table.getColumns().remove(col_action);
		
	    ObservableList<AProduct> prodList = FXCollections
                .observableArrayList(productlist2);
	    
    	col_id.setSortable(true);
    	col_id.setCellValueFactory(new PropertyValueFactory<>("productId"));
    	//col_name.setSortable(true);
    	col_name.setCellValueFactory(new PropertyValueFactory<>("productName"));
    	
    	
    	col_action = new TableColumn<>("View");
    	col_action.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
    	col_action.setCellFactory(param -> new TableCell<AProduct, AProduct>() {
    	    //System.out.println(this);
            private final Button viewButton = new Button("View");
            @Override
            protected void updateItem(AProduct user, boolean empty) {
                super.updateItem(user, empty);
                if (user == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(viewButton);
                viewButton.setOnAction(event -> System.out.println("Something happened " + user.getProdcutName()));
            }
        });

    	col_type.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));

    	col_type.setCellFactory(param -> new TableCell<AProduct, AProduct>() {
            @Override
            protected void updateItem(AProduct prod, boolean empty) {
                super.updateItem(prod, empty);
                if (prod == null) {
                	setText(null);
                    return;
                }
                setText(prod.getClass().getSimpleName());
                
            }
        });

    	
    	products_table.getColumns().add(col_action);
    	
    	products_table.getItems().setAll(prodList);

	}

	public void clearTable() {
		for (int i = 0; i < products_table.getItems().size(); i++) {

			products_table.getItems().clear();

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loadInitialProductlist();

	}


}
