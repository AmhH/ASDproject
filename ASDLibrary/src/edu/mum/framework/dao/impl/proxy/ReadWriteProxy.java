package edu.mum.framework.dao.impl.proxy;

import java.util.List;

public class ReadWriteProxy<T> extends ReadWrite<T>{
	
	protected Class<T> daoType;
	
	private ReadWriteImpl<T> readWriteImpl;
	
	public ReadWriteProxy(Class<T> daoType) {
		this.daoType = daoType;
		readWriteImpl = new ReadWriteImpl<>(daoType);
	}
		
	public void setDaoType(Class<T> daoType) {
		this.daoType = daoType;
	}

	public ReadWriteImpl<T> getReadWriteImpl() {
		return readWriteImpl;
	}

	public void setReadWriteImpl(ReadWriteImpl<T> readWriteImpl) {
		this.readWriteImpl = readWriteImpl;
	}

	@Override
	public List<T> read(String className) {		
		return readWriteImpl.read(className);
	}

	@Override
	public void write(List<T> writeList, String className) {		
		readWriteImpl.write(writeList, className);
	}

}
