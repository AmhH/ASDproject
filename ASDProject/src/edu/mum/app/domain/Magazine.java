package edu.mum.app.domain;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;
public class Magazine extends AProduct{
	   
	public Magazine(String productName, String productId, String productDesc, boolean status, double unitPrice,
			String category, Unit unit) {
		super(productName, productId, productDesc, status, unitPrice, category, unit);
		
	}

	private static final long serialVersionUID = 1L;
	private String edition;

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

}
