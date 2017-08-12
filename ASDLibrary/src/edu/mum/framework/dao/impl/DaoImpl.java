package edu.mum.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.mum.framework.dao.Dao;
import edu.mum.framework.dao.impl.proxy.ReadWrite;
import edu.mum.framework.dao.impl.proxy.ReadWriteProxy;

public abstract class DaoImpl<T> implements Dao<T>{
    
	protected Class<T> daoType;
	private volatile List<T>  list = new ArrayList<>();
	private String className;
	private ReadWrite<T> readWrite = new ReadWriteProxy<>(daoType);
	
	public DaoImpl(Class<T> daoType, String className) {
		this.daoType = daoType;
		this.className = className;
		findAll();
	}

	public void write(){
		readWrite.write(this.list, className);
	}
	
	public void setDaoType(Class<T> daoType) {
		this.daoType = daoType;
	}
	
	@Override
	public void add(T t) {
		list.add(t);
		write();
	}

	@Override
	public void remove(T t) {
		list.remove(t);
		write();
	}

	@Override
	public List<T> findAll() {
		if(list.size()>0){
			return list;
		}
		//System.out.println(className);
		this.readWrite = new ReadWriteProxy<>(daoType);
		this.list = readWrite.read(className);
		return list;
	}
	
}
