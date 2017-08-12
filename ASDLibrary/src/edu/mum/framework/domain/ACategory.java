package edu.mum.framework.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ACategory implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String categoryId;
	private String categoryName;
	private List<AProduct> productList;

	public ACategory(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.productList = new ArrayList<AProduct>();
	}

	public void addProduct(AProduct product) {
		productList.add(product);
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<AProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<AProduct> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", productList=" + productList
				+ "]";
	}
	
	
}
