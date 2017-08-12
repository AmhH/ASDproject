package edu.mum.framework.controller;

import java.time.LocalDate;

import edu.mum.framework.domain.AUser;
import edu.mum.framework.domain.concrete.Rent;
import edu.mum.framework.domain.concrete.User;
import edu.mum.framework.generator.id.AutoGenerate;
import edu.mum.framework.generator.id.IDGenerator;
import edu.mum.framework.service.RentService;
import edu.mum.framework.service.factory.ServiceFactory;


public class RentController {
AutoGenerate autoGenerate;
	
	public Rent buildRent(LocalDate checkoutDate, LocalDate returnDate, AUser user){
		
		autoGenerate = IDGenerator.getInstance();
		String rentId = String.valueOf(autoGenerate.getUniqueId(Rent.class.getSimpleName()));
		return new Rent(rentId, checkoutDate, returnDate, user);
	}
	
	@SuppressWarnings("unchecked")
	public RentService<Rent, User> getRentServices(){
		return ServiceFactory.createRenttService(Rent.class, Rent.class.getSimpleName());
		
	}
}
