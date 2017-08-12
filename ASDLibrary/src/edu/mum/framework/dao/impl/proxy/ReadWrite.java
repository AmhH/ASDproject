package edu.mum.framework.dao.impl.proxy;

import java.util.List;

public abstract class ReadWrite<T> {
	public abstract List<T> read(String className);
	public abstract void write(List<T> writeList, String className);
}
