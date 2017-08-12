package edu.mum.app.test;

import java.time.LocalDate;
import java.util.List;

import edu.mum.app.dao.BookDao;
import edu.mum.app.dao.MemberDao;
import edu.mum.app.domain.Book;
import edu.mum.app.domain.Member;
import edu.mum.app.service.BookService;
import edu.mum.app.service.MemberService;
import edu.mum.framework.domain.Unit;

public class MainTest {
 
	public static void main(String[] args) {
		BookService bookService=new BookService(new BookDao());
		MemberService memberService = new MemberService(new MemberDao());
		Member member = (Member) memberService.findOneUser("1");//new Member();
		member.setDob(LocalDate.now());
		/*member.setId("1");
		member.setFirstName("Aman");*/
		memberService.updateUser(member);
		System.out.println(memberService.findAllUser());
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
