package edu.mum.framework.service;

import java.util.List;


public interface RentService<T,U> {
	public void saveRental(T rent);
	public void deleteRent(T rent);
	public void updateCategor(T rent);
	public T findOneRent(String id);
	public List<T> findAllRent();
	public double totalRentPrice(T Rent);
	public boolean checkOut(U user,T rent);
	public boolean checkIn(U user,T rent);
  
}
