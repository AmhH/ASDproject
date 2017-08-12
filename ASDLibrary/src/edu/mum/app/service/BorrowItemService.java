package edu.mum.app.service;

import edu.mum.framework.dao.RentDao;
import edu.mum.framework.service.impl.RentServiceImpl;

public class BorrowItemService extends RentServiceImpl {

	public BorrowItemService(RentDao rentDao) {
		super(rentDao);
		
	}

}
