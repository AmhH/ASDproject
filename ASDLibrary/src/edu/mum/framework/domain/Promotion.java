package edu.mum.framework.domain;

import java.time.LocalDate;
import java.util.List;

public abstract class Promotion {
	private String code;
	private String name;
	private double  discount;
	private LocalDate startDate;
    private LocalDate endDate;
    private List<AProduct> product;
    
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public List<AProduct> getProduct() {
		return product;
	}
	public void setProduct(List<AProduct> product) {
		this.product = product;
	}
    
}
