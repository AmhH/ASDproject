package edu.mum.framework.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;
import edu.mum.framework.domain.concrete.Product;
import edu.mum.framework.domain.concrete.User;
import edu.mum.framework.generator.id.AutoGenerate;
import edu.mum.framework.generator.id.IDGenerator;
import edu.mum.framework.service.ProductService;
import edu.mum.framework.service.UserService;
import edu.mum.framework.service.factory.ServiceFactory;

public class ProductController<T> {
	
	AutoGenerate autoGenerate;
	
	
	

	public boolean buillProduct(Class<AProduct> currentClass, List<Field> filteredParams, List<String> listOfArguments,
			String productName, String productDesc, double unitPrice, Unit unit){
	
			autoGenerate = IDGenerator.getInstance();
			String productId = autoGenerate.getUniqueId(Product.class.getSimpleName());
			try {
				AProduct obj = currentClass.newInstance();
				
				obj.setProdcutName(productName);
				obj.setProductId(productId);
				obj.setProductDesc(productDesc);
				obj.setStatus(true);
				obj.setUnitPrice(unitPrice);
				obj.setCategory(currentClass.getSimpleName());
				obj.setUnit(unit);
				
				//filteredParams
				
				for(int j = 0; j < listOfArguments.size(); j++) {
					for(int i = 0; i < currentClass.getMethods().length; i++){
						if(currentClass.getMethods()[i].getName().toLowerCase().contains(filteredParams.get(j).getName().toLowerCase())
								&& currentClass.getMethods()[i].getParameterCount() == 1
								&& currentClass.getMethods()[i].getParameters()[0].getType().equals(filteredParams.get(j).getType())) {
							currentClass.getMethods()[i].invoke(obj, listOfArguments.get(j));
						}
						
					}
					
					
				}			
				@SuppressWarnings("unchecked")
				ProductService<AProduct> productService = ServiceFactory.createProductService(AProduct.class, AProduct.class.getSimpleName());
				productService.saveProduct(obj);
				System.out.println(obj);
				System.out.println(obj.getClass().getSimpleName());
				
				
			} catch (SecurityException e) {		
				e.printStackTrace();
				return false;
			} catch (InstantiationException e) {		
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return false;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				return false;
			} 
			return true;
			
		}
		

	
	
	
	
/*	public Product buildProduct(String productName, String productDesc, boolean status, double unitPrice,
			String category, Unit unit, Class<Product> cls ){
		
	
		
		autoGenerate = IDGenerator.getInstance();
		ProductService<Product> productService = getProductServices();
		String productId = String.valueOf(autoGenerate.getUniqueId(Product.class.getSimpleName()));
		Product product = new Product(productName, productId, productDesc, status, unitPrice,
				category, unit);
		productService.saveProduct(product);
		return product;
	}*/
	
	@SuppressWarnings("unchecked")
	public ProductService<Product> getProductServices(){
		return ServiceFactory.createProductService(Product.class, Product.class.getSimpleName());
	}
}
