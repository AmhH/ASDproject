package edu.mum.framework.generator.id;



public class Book {
	private String id;
	AutoGenerate autoGenerate;
	public Book(){
		autoGenerate = IDGenerator.getInstance();
		id = autoGenerate.getUniqueId(Book.class.getSimpleName());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
