package edu.mum.app.test;

import java.util.List;

import edu.mum.app.dao.BookDao;
import edu.mum.app.domain.Book;
import edu.mum.app.service.BookService;
import edu.mum.framework.domain.Unit;

public class MainTest {
 
	public static void main(String[] args) {
		BookService bookService=new BookService(new BookDao());
		Book book=new Book("productName12","productId2", "productDesc2", true, 4, "Category2", Unit.DAILY);
		bookService.saveProduct(book);
		
		List<Book> listBook=bookService.findAllProduct();
		//System.out.println(listBook);
		listBook.forEach(System.out::println);
		System.out.println(listBook.size());
		//add userCredential		
	}
}
