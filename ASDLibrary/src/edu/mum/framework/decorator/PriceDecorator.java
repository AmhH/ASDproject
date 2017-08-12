package edu.mum.framework.decorator;
import edu.mum.framework.service.RentService;

public interface PriceDecorator<T,Y>{
   public  double getPrice(Y rentservice,T rent);
}
