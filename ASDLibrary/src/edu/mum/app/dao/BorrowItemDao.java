package edu.mum.app.dao;

import edu.mum.app.domain.BorrowItem;
import edu.mum.framework.dao.impl.ARentDaoImpl;

public class BorrowItemDao extends ARentDaoImpl<BorrowItem>{

	public BorrowItemDao() {
		super(BorrowItem.class, BorrowItem.class.getSimpleName());
	}
}
