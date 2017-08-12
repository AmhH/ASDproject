package edu.mum.framework.generator.id;

public class Category {
	private String id;
	AutoGenerate autoGenerate;
	public Category(){
		autoGenerate = IDGenerator.getInstance();
		id = autoGenerate.getUniqueId(Category.class.getSimpleName());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
