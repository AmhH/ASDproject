package edu.mum.framework.service;

import java.util.List;

import edu.mum.framework.domain.AProduct;
import edu.mum.framework.domain.AUser;


public interface RentService<T> {
	public void saveRental(T rent);
	public void deleteRent(T rent);
	public void updateCategor(T rent);
	public T findOneRent(String id);
	public List<T> findAllRent();
	public double totalRentPrice(T rent);
	public boolean checkOut(T rent);
	public boolean checkIn(T rent);
	public List<AProduct> borrowedItemByUser(AUser user);
	public List<AProduct> returnedItemByUser(AUser user);
	public List<AProduct> ItemNotReturnedByUser(AUser user);
	public List<AProduct> AllNotReturned();
  
}
