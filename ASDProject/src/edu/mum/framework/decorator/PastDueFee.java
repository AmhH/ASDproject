package edu.mum.framework.decorator;

import edu.mum.framework.domain.concrete.Rent;

public class PastDueFee<T> extends PriceDecorator<T>{
	
	private static final long serialVersionUID = 1L;
	private PriceDecorator<T> priceDecorator;
	public PastDueFee(PriceDecorator<T> priceDecorator)
	{
		this.priceDecorator=priceDecorator;
	}
	@Override
	public double getPrice(Rent rent, double dueFee) {
		return priceDecorator.getTotalRentPrice()+(( (priceDecorator.getTotalRentPrice() *dueFee)/100));
	}

	

	
}
