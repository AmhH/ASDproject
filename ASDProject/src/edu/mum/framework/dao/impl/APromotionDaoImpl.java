package edu.mum.framework.dao.impl;

import edu.mum.framework.dao.PromotionDao;
import edu.mum.framework.domain.APromotion;

public class APromotionDaoImpl<T> extends DaoImpl<T> implements PromotionDao<T>{

	public APromotionDaoImpl(Class<T> daoType, String className) {
		super(daoType, className);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(APromotion promotion) {
		this.findAll().remove(findPromotionByCode(promotion.getCode()));
		this.add((T) promotion);
	}

	@Override
	public T findPromotionByCode(String code) {
		return this.findAll().stream()
				  .filter(p -> ((APromotion)p).getCode().equals(code))
				  .findFirst()
				  .orElse(null);
	}
}
