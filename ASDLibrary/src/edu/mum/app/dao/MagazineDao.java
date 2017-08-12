package edu.mum.app.dao;

import edu.mum.app.domain.Magazine;
import edu.mum.framework.dao.impl.AProductDaoImpl;

public class MagazineDao extends AProductDaoImpl<Magazine> {

	public MagazineDao() {
		super(Magazine.class, Magazine.class.getSimpleName());
	}
}
