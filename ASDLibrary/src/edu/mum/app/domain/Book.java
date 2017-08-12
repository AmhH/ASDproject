package edu.mum.app.domain;


import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;
import edu.mum.framework.domain.UserStatus;

public class Book extends AProduct {

	private static final long serialVersionUID = -5101693623665618963L;
	private String publisher;
	private String yearPub;
	private String shelfNo;
	private String isbn;
	private String author;
	
	public Book(){
		super();
	}

	public Book(String productName, String productId, String productDesc, boolean status, double unitPrice,
		String category, Unit unit, String publisher, String yearPub, String shelfNo, String isbn,
			String author) {
		super(productName, productId, productDesc, status, unitPrice, category, unit);
				this.publisher = publisher;
				this.yearPub = yearPub;
				this.shelfNo = shelfNo;
				this.isbn = isbn;
				this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYearPub() {
		return yearPub;
	}
	public void setYearPub(String yearPub) {
		this.yearPub = yearPub;
	}
	public String getShelfNo() {
		return shelfNo;
	}
	public void setShelfNo(String shelfNo) {
		this.shelfNo = shelfNo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Book [publisher=" + publisher + ", yearPub=" + yearPub + ", shelfNo=" + shelfNo + ", isbn=" + isbn
				+ ", author=" + author + "]";
	}

}
