package edu.mum.framework.ui;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;
import edu.mum.framework.generator.id.IDGenerator;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProductUiController implements InitLoader, BuilderController {
	
	
	@FXML
	private Label msg_error;
	
	@FXML
	private TextField input_productname;
	
	@FXML
	private TextField input_priceunit;
	
	@FXML
	private ChoiceBox<Unit> input_rentalunit;
	
	@FXML
	private TextArea input_description;
	
	@FXML
	private Button btn_createproduct;
	
	@FXML
	private ScrollPane ConcreteProd;
	
	@FXML
	private AnchorPane productLayout;
	
	@FXML
	private ChoiceBox<String> concrete_prod_list;
	
	private List<TextField> dynamicInputs = new ArrayList<>();
	
	private Class<AProduct> currentClass;
	
	private List<Field> filteredParams;
	
	
	
	@SuppressWarnings("unchecked")
	public void loadConcreteProdList() {
		input_rentalunit.getItems().addAll(Unit.values());
		for(Class<AProduct> cl:Loader.getInstance().getProductClasses()) {
			concrete_prod_list.getItems().add(cl.getSimpleName());
		}
		
		concrete_prod_list.getSelectionModel()
	    .selectedItemProperty()
	    .addListener( (ObservableValue<? extends String> observable, String oldValue, String newValue) -> loadCurrentType());
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadCurrentType(){
		for(Class cl:Loader.getInstance().getProductClasses()) {
			if(concrete_prod_list.getValue().equals(cl.getSimpleName())) {
				currentClass = cl;
				break;
			}
		}
		
		
		for(TextField rm: dynamicInputs)
			productLayout.getChildren().remove(rm);
		
		dynamicInputs.clear();
		UIBuildObserver formbuilder1 = new ProductFormUIBuild();
		
		filteredParams = Arrays.asList(currentClass.getDeclaredFields()).stream()
				.filter(x -> !Modifier.isFinal(x.getModifiers()))
				.collect(Collectors.toList());
		formbuilder1.buildForm(this, filteredParams);
	}
	
	public AnchorPane getPorductLayout(){
		return productLayout;
	}
	
	public List<TextField> getDynamicInputs(){
		return dynamicInputs;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void createProduct(){
		if(validateForm()){
			
			System.out.println("Saving..");
		
	
			List<Object> listOfArguments = new ArrayList<>();
			
			for(TextField tf : dynamicInputs) {
				listOfArguments.add(tf.getText());
			}
			
			try {
				AProduct obj = currentClass.newInstance();
				
				obj.setProdcutName(input_productname.getText());
				obj.setProductId(""+IDGenerator.getInstance().getUniqueId(currentClass.getSimpleName()));
				obj.setProductDesc(input_description.getText());
				obj.setStatus(true);
				obj.setUnitPrice(Double.valueOf(input_priceunit.getText()).doubleValue());
				obj.setCategory(currentClass.getSimpleName());
				obj.setUnit(input_rentalunit.getValue());
				
				//filteredParams
				
				for(int j = 0; j < filteredParams.size(); j++) {
					for(int i = 0; i < currentClass.getMethods().length; i++){
						if(currentClass.getMethods()[i].getName().toLowerCase().contains(filteredParams.get(j).getName().toLowerCase())
								&& currentClass.getMethods()[i].getParameterCount() == 1
								&& currentClass.getMethods()[i].getParameters()[0].getType().equals(filteredParams.get(j).getType())) {
							currentClass.getMethods()[i].invoke(obj, dynamicInputs.get(j).getText());
						}
						
					}
					
					
				}
				
				
				System.out.println(obj);
				System.out.println(obj.getClass().getSimpleName());
				
				
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
	}
	
	public boolean validateForm(){
		
		if(input_productname.getText().length() < 3 
				|| input_priceunit.getText().equals("")
				|| !input_priceunit.getText().matches("[0-9]+")
				|| input_rentalunit.getValue() == null
				|| concrete_prod_list.getValue() == null
				) {
			
			msg_error.setText("Please complete all the fields and check the values.");			
			
			return false;
		} else {
			msg_error.setText("");
			return true;
		}
	}
	
	public void cleanForm(){
		input_productname.setText("");
		input_priceunit.setText("");
		input_rentalunit.setValue(null);
		concrete_prod_list.setValue(null);
		for(TextField rm: dynamicInputs)
			productLayout.getChildren().remove(rm);
		dynamicInputs.clear();
		msg_error.setText("");
	}
	
	@Override
	public void loadInitialData() {
		loadConcreteProdList();

	}

	@FXML
    public void initialize() {
		loadInitialData();
    }
	
}
