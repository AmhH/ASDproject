package edu.mum.framework.decorator;

import edu.mum.framework.domain.concrete.Rent;


public abstract class PriceDecorator<T> extends Rent{
	
    
	private static final long serialVersionUID = 1L;

	public abstract double getPrice(Rent rent,double promotion);
}
