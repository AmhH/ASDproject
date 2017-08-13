package edu.mum.framework.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import edu.mum.framework.dao.ProductDao;
import edu.mum.framework.dao.RentDao;
import edu.mum.framework.decorator.PastDueFee;
import edu.mum.framework.decorator.PriceDecorator;
import edu.mum.framework.decorator.PromotionDecorator;
import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.Unit;
import edu.mum.framework.domain.concrete.Product;
import edu.mum.framework.domain.concrete.Rent;
import edu.mum.framework.service.RentService;
import edu.mum.framework.domain.concrete.Rent;

@SuppressWarnings({ "unused", "unchecked" })
public class RentServiceImpl<T> implements RentService<T> {

	private RentDao<T> rentDao;
	private ProductDao<T> productDao;
	private RentService<T> rentService;

	public RentServiceImpl(RentDao<T> rentDao) {
		this.rentDao = rentDao;
	}

	@Override
	public void saveRental(T rent) {
		List<AProduct> listRentProduct = ((Rent) rent).getRentedProducts();
		for (AProduct p :listRentProduct) {
			p.setStatus(false);
			productDao.update((T) p);
		}
		rentDao.add(rent);

	}

	
	private List<AProduct> Rent(T rent) {
		return (List<AProduct>) ((Rent)rent).getRentedProducts();
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
		return rentDao.findRentById(id);
	}

	@Override
	public List<T> findAllRent() {
		return (List<T>) rentDao.findAll();
	}

	@Override
	public double totalRentPrice(T rent) {
		List<AProduct> listRentProduct = ((Rent) rent).getRentedProducts();
		double cost = 0;
		int rentLenght = 0;
		for (AProduct p : listRentProduct) {

			rentLenght = (LocalDate.now().getDayOfYear() - ((Rent) rent).getCheckoutDate().getDayOfYear());
			if (p.getUnit() == Unit.DAILY) {
				cost += p.getUnitPrice() * rentLenght;

			}
			if (p.getUnit() == Unit.HOURLY)
				cost += p.getUnitPrice() * (rentLenght * 8);
		}
		PriceDecorator<Rent> rentDueFee;
		if(((Rent) rent).getReturnDate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0){
			   rentDueFee=new PastDueFee<Rent>((PriceDecorator<Rent>)rent);
			    return  rentDueFee.getPrice(rentDueFee,20);
		}
		else 
			rentDueFee=new PromotionDecorator<Rent>((PromotionDecorator<Rent>)rent);
	        return  rentDueFee.getPrice(rentDueFee,20);
	}

	@Override
	public boolean checkOut(T rent) {
		List<AProduct> listRentProduct = ((Rent) rent).getRentedProducts();
		if(listRentProduct.size()>0){
		for (AProduct p :listRentProduct) {
			p.setStatus(true);
			productDao.update((T) p);
		}
		return true;
		}
		return false;
	}

	@Override
	public boolean checkIn(T rent) {
		return false;
	}
	
	@Override
	public 	List<AProduct> borrowedItemByUser(AUser user) {
		List<AProduct> list = new ArrayList<>();
		((List<Rent>) rentDao.findAll()).stream()
										.filter(x->x.getUser().equals(user))
				                        .forEach(y->y.getRentedProducts().forEach(p->list.add(p)));
		return list;
	} 

	@Override
	public List<AProduct> returnedItemByUser(AUser user) {
		return borrowedItemByUser(user).stream()
								.filter(p->p.isStatus()==true)
								.collect(Collectors.toList());
		 
		
		}

	@Override
	public List<AProduct> ItemNotReturnedByUser(AUser user) {
		return borrowedItemByUser(user).stream()
				.filter(p->p.isStatus()==false)
				.collect(Collectors.toList());
	}

	@Override
	public List<AProduct> AllNotReturned() {
		List<AProduct> list = new ArrayList<>();
		((List<Rent>) rentDao.findAll())
							 .forEach(r->list.addAll(ItemNotReturnedByUser(r.getUser())));
		return list;
	}
    
}
