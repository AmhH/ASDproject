package edu.mum.framework.dao.impl.proxy;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteImpl<T> extends ReadWrite<T> {

	private List<T> list = new ArrayList<>();
	protected Class<T> daoType;

	public ReadWriteImpl(Class<T> daoType) {
		this.daoType = daoType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> read(String className) {		
		boolean check = true;
		ObjectInputStream input = FileInstace.inputConnection(className);
		if(input == null) return list;
		try {
			Object object = input.readObject();
			while (check) {
				list.add((T) object);
				object = input.readObject();
			}

		} catch (EOFException ex) {
			check = false;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void write(List<T> writeList, String className) {
		ObjectOutputStream output = FileInstace.outputConnection(className);
		for (T t : writeList) {
			try {
				output.writeObject(t);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
