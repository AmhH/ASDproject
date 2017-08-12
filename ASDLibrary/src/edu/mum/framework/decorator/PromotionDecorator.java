package edu.mum.framework.decorator;
import edu.mum.framework.domain.Promotion;
import edu.mum.framework.service.RentService;


public class PromotionDecorator<T,Y> implements PriceDecorator<T,Y>  {

	@Override
	public double getPrice(Y rentservice,T rent) {
		double orginalPrice=((RentService)rentservice).totalRentPrice(rent);
		return  orginalPrice -((orginalPrice *10)/100);
		
	}

	

}
