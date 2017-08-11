package edu.mum.framework.dao.impl.concrete;

import edu.mum.framework.dao.impl.APromotionDaoImpl;
import edu.mum.framework.domain.concrete.Promotion;

public class PromotionDaoImpl extends APromotionDaoImpl<Promotion>{

	public PromotionDaoImpl() {
		super(Promotion.class, Promotion.class.getSimpleName());
	}

	
}
