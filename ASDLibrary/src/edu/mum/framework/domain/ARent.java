package edu.mum.framework.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public abstract class ARent implements Serializable{
	   
private static final long serialVersionUID = 1L;
	private String rentId;
	private LocalDate checkoutDate;
	private LocalDate returnDate;
	private List<AProduct> rentedProducts;
	private  double totalRentPrice;
	private AUser user;
	
	
	public double getTotalRentPrice() {
		return totalRentPrice;
	}

	public void setTotalRentPrice(double totalRentPrice) {
		this.totalRentPrice = totalRentPrice;
	}

	public ARent(String rentId, LocalDate checkoutDate, LocalDate returnDate, AUser user) {
		this.rentId = rentId;
		this.checkoutDate = checkoutDate;
		this.returnDate = returnDate;
		this.user = user;
	}

	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public AUser getUser() {
		return user;
	}
	public void setUser(AUser user) {
		this.user = user;
	}
	public void addProduct(AProduct product)
	{
		rentedProducts.add(product);
	}

	public List<AProduct> getRentedProducts() {
		return rentedProducts;
	}

	public void setRentedProducts(List<AProduct> rentedProducts) {
		this.rentedProducts = rentedProducts;
	}
	
}
