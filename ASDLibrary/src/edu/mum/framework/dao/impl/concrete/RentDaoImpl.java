package edu.mum.framework.dao.impl.concrete;

import edu.mum.framework.dao.impl.ARentDaoImpl;
import edu.mum.framework.domain.concrete.Rent;

public class RentDaoImpl extends ARentDaoImpl<Rent>{

	public RentDaoImpl() {
		super(Rent.class, Rent.class.getSimpleName());
	}

	
}
