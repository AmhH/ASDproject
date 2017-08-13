package edu.mum.app.test;

import edu.mum.app.dao.BookDao;
import edu.mum.app.domain.Book;
import edu.mum.app.service.BookService;

public class MainTest {
 
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BookService bookService=new BookService(new BookDao());
		//MemberService memberService = new MemberService(new MemberDao());
		Book book = bookService.findOneProduct("productId");//new Book("productName", "productId", "productDesc", true, 12.4, "Sports", Unit.DAILY);
		/*book.setProdcutName("Book");
		book.setCategory("Aman");
		bookService.updateProductById(book);*/
		//bookService.saveProduct(book);
		System.out.println(bookService.findAllProduct());
		/*Book book=bookService.findOneProduct("productId2");
		book.setProdcutName("Updated one");
		
		//new Book("productName","productId2", "productDesc2", true, 4, "Category2", Unit.DAILY);
		bookService.updateProductById(book);
		
		List<Book> listBook=bookService.findAllProduct();
		//System.out.println(listBook);
		listBook.forEach(System.out::println);
		System.out.println(listBook.size());
		//add userCredential		
*/	}
}
