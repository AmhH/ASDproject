package edu.mum.app.domain;


import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;

public class Audio extends AProduct{
	
	public Audio(){
		super();
	}
	   	
	@Override
	public String toString() {
		return super.toString() + " Audio [NoCDs=" + NoCDs + "]";
	}

	public Audio(String productName, String productId, String productDesc, boolean status, double unitPrice,
			String category, Unit unit, String NoCDs) {
		super(productName, productId, productDesc, status, unitPrice, category, unit);
		this.NoCDs = NoCDs;
		
	}
	private static final long serialVersionUID = 1L;
	private String NoCDs;
	
	public String getNoCDs() {
		return NoCDs;
	}
	
	public void setNoCDs(String noCDs) {
		NoCDs = noCDs;
	}
	
}
