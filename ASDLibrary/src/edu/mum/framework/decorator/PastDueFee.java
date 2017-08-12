package edu.mum.framework.decorator;

import edu.mum.framework.service.RentService;

public class PastDueFee<T,Y> implements PriceDecorator<T,Y>{

	@Override
	public double getPrice(Y rentservice,T rent) {
		double price=((RentService)rentservice).totalRentPrice(rent);
		return price + ((price * 20) / 100);
	}

}
