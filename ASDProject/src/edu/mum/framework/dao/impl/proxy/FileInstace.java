package edu.mum.framework.dao.impl.proxy;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum FileInstace {
	FILE;
	private static String directory = System.getProperty("user.dir") + "\\dataStorage\\";

	public static ObjectInputStream inputConnection(String className) {
		ObjectInputStream input = null;
		try {
			File file = new File(directory + className + ".txt");
			File dir = new File(file.getParentFile().getAbsolutePath());
			if(!file.exists()){
				dir.mkdirs();
				file.createNewFile();
				return null;
			}
			FileInputStream fileInputStream = new FileInputStream(new File(directory + className + ".txt"));
			input = new ObjectInputStream(fileInputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	public static ObjectOutputStream outputConnection(String className) {
		try {
			File file = new File(directory + className + ".txt");
			File dir = new File(file.getParentFile().getAbsolutePath());
			if(!file.exists()){
				dir.mkdirs();
				file.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(new File(directory + className + ".txt"));
			// ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			return new ObjectOutputStream(fileOutputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
