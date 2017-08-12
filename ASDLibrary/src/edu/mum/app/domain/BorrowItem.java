package edu.mum.app.domain;

import java.time.LocalDate;

import edu.mum.framework.domain.ARent;
import edu.mum.framework.domain.AUser;

public class BorrowItem extends ARent{


	private static final long serialVersionUID = 1L;

	public BorrowItem(String rentId, LocalDate checkoutDate, LocalDate returnDate, AUser user) {
		super(rentId, checkoutDate, returnDate, user);
	
	}


}
