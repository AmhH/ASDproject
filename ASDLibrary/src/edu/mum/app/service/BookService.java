package edu.mum.app.service;

import edu.mum.app.dao.BookDao;
import edu.mum.app.domain.Book;
import edu.mum.framework.service.impl.ProductServiceImpl;

public class BookService extends ProductServiceImpl<Book> {

	public BookService(BookDao bookDao) {
		super(bookDao);
		
	}

}
