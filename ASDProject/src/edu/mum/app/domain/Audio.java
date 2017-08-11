package edu.mum.app.domain;

import java.io.Serializable;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;

public class Audio extends AProduct{
	   	
	public Audio(String productName, String productId, String productDesc, boolean status, double unitPrice,
			String category, Unit unit) {
		super(productName, productId, productDesc, status, unitPrice, category, unit);
		
	}
	private static final long serialVersionUID = 1L;
	private double NoCDs;
	public double getNoCDs() {
		return NoCDs;
	}
	public void setNoCDs(double noCDs) {
		NoCDs = noCDs;
	}
	
}
