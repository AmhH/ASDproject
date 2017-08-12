package edu.mum.framework.generator.id;

public class Main {
	public static void main(String[] args){
		Book book = new Book();
		System.out.println(book.getId());
		Book book1 = new Book();
		System.out.println(book1.getId());
		Book book3 = new Book();
		System.out.println(book3.getId());
		Book book4 = new Book();
		System.out.println(book4.getId());
		
		System.out.println("=================================");
		
		Category category = new Category();
		System.out.println(category.getId());
		Category category1 = new Category();
		System.out.println(category1.getId());
		Category category2 = new Category();
		System.out.println(category2.getId());
		Category category3 = new Category();
		System.out.println(category3.getId());
		
		
	}
}
