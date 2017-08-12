package edu.mum.app.dao;

import edu.mum.app.domain.Book;
import edu.mum.framework.dao.impl.AProductDaoImpl;

public class BookDao extends AProductDaoImpl<Book> {

	public BookDao() {
		super(Book.class, Book.class.getSimpleName());
	}
}
