package edu.mum.app.service;

import edu.mum.app.domain.BorrowItem;
import edu.mum.framework.dao.RentDao;
import edu.mum.framework.service.impl.RentServiceImpl;

public class BorrowItemService extends RentServiceImpl{

	@SuppressWarnings("rawtypes")
	public BorrowItemService(RentDao rentDao) {
		super(rentDao);
		
	}

}
