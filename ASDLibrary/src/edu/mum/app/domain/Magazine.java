package edu.mum.app.domain;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;
public class Magazine extends AProduct{
	   
	public Magazine() {
		super();
	}
	public Magazine(String productName, String productId, String productDesc, boolean status, double unitPrice,
			String category, Unit unit, String edition) {
		super(productName, productId, productDesc, status, unitPrice, category, unit);
		this.edition = edition;
		
	}

	private static final long serialVersionUID = 1L;
	private String edition;

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	@Override
	public String toString() {
		return super.toString() + " Magazine [edition=" + edition + "]";
	}
	
	

}
