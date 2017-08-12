package edu.mum.framework.controller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

//import edu.mum.app.controller.MemberLoginController;
import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Role;
import edu.mum.framework.domain.Unit;
import edu.mum.framework.domain.concrete.User;

public class Main {
	public static void main(String[] str){
		UserController<User> uc = new UserController<User>(User.class);
		UserDirector ud = uc.getUserDirector();
		
		
			ud.userInfo(LocalDate.of(1981, 12, 18), "name3","name3", "22222222");
			ud.userAddress("22222", "addisAbaba", "Checkos", 2345);
			ud.userCredential("meron", "tolosa", Role.ADMIN);
			User user = ud.createFullUser();
			System.out.println(user);	
			System.out.println(uc.getUserServices().findOneUser(user.getId()));
			
			
			/*
			 * 
		
			ProductController  productController = new ProductController();
			Product product = productController.buildProduct("book", "ASD", true, 9, "book", Unit.HOURLY);
			ProductController  productController = new ProductController();
			Product product = productController.buildProduct("book1", "Sport", true, 10, "Megazine", Unit.DAILY);
		
			ProductService<Product> productService = productController.getProductServices();
			System.out.println(productService.findOneProduct(product.getProductId()));
			System.out.println(productService.findAllProduct());
		
		*/
			LoginController<User> lc = new LoginController<User>(User.class);
			System.out.println(lc.authenticateUser("meron", "tolosa"));
			
			/*MemberLoginController mc = new MemberLoginController();
			System.out.println(mc.authenticateUser("aman", "estifanos"));*/
			
	}
}








