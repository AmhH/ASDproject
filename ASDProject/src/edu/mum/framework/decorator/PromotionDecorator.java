package edu.mum.framework.decorator;
import edu.mum.framework.domain.concrete.Rent;



public class PromotionDecorator<T> extends PriceDecorator<T>  {
    
	private static final long serialVersionUID = 1L;
	private PriceDecorator<T> priceDecorator;
	
	public PromotionDecorator(PriceDecorator<T> priceDecorator)
	{
		this.priceDecorator=priceDecorator;
	}
	
	@Override
	public double getPrice( Rent rent,double promotion) {
		return priceDecorator.getTotalRentPrice() - (((priceDecorator.getTotalRentPrice() * promotion)/100));
	}

}
