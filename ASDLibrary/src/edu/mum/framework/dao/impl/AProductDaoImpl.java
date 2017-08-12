package edu.mum.framework.dao.impl;

import edu.mum.framework.dao.ProductDao;
import edu.mum.framework.domain.AProduct;

@SuppressWarnings("unchecked")
public class AProductDaoImpl<T> extends DaoImpl<T> implements ProductDao<T> {

	public AProductDaoImpl(Class<T> daoType, String className) {
		super(daoType, className);
	}

	@Override
	public void remove(String id) {
		this.findAll().remove(findOne(id));
		write();
		}

	@Override
	public void update(AProduct product) {
		remove(product.getProductId());
		this.add((T)product);
	}

	@Override
	public T findOne(String id) {
		return this.findAll().stream()
				  .filter(p -> ((AProduct)p).getProductId().equals(id))
				  .findFirst()
				  .orElse(null);
	}

	@Override
	public T findByProductName(String name) {
		return this.findAll().stream()
				  .filter(p -> ((AProduct)p).getProdcutName().equals(name))
				  .findFirst()
				  .orElse(null);
	}

}