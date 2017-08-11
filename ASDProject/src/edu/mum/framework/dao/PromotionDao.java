package edu.mum.framework.dao;

import edu.mum.framework.domain.APromotion;

public interface PromotionDao<T> extends Dao<T>{
	void update(APromotion promotion);
	T findPromotionByCode(String code);
}
