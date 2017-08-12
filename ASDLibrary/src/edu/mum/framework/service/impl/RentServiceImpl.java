package edu.mum.framework.service.impl;

import java.time.LocalDate;
import java.util.List;

import edu.mum.framework.dao.ProductDao;
import edu.mum.framework.dao.RentDao;
import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.Unit;
import edu.mum.framework.domain.concrete.Rent;
import edu.mum.framework.service.RentService;

public class RentServiceImpl<T,U> implements RentService<T,U> {

    private RentDao rentDao;
    private ProductDao productDao;
    public RentServiceImpl(RentDao rentDao){
    	this.rentDao=rentDao;
    }
	@Override
	public void saveRental(T rent) {
		for(AProduct p :((Rent)rent).getRentedProducts()){
			p.setStatus(false);
			productDao.update(p);
		}
		rentDao.add(rent);
		
	}
	@Override
	public void deleteRent(T rent) {
		rentDao.remove(rent);
		
	}
	@Override
	public void updateCategor(T rent) {

		
	}
	@Override
	public T findOneRent(String id) {
		return (T) rentDao.findRentById(id);
	}
	@Override
	public List<T> findAllRent() {
	return (List<T>) rentDao.findAll();
	}
	@Override
	public double totalRentPrice(T rent) {
		List<AProduct> listRentProduct=((Rent)rent).getRentedProducts();
		double cost=0;
		int rentLenght=0;
		int overRentTime=0;
		for(AProduct p:listRentProduct)
		{
			
			rentLenght=(LocalDate.now().getDayOfYear()- ((Rent)rent).getCheckoutDate().getDayOfYear());
		    if(p.getUnit()==Unit.DAILY){
		    	    cost+=p.getUnitPrice()* rentLenght;
		    	   
		    }
		     if(p.getUnit()==Unit.HOURLY) 
		    	 cost+=p.getUnitPrice()* (rentLenght*8);
		   }
		
	if(((Rent)rent).getReturnDate().getDayOfYear()- LocalDate.now().getDayOfYear()>0);
		    return 0;//
	}
	@Override
	public boolean checkOut(U user, T rent) {
		 
		return false;
	}
	@Override
	public boolean checkIn(U user, T rent) {
	   return false;
	}
	
    
}
