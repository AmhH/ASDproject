package edu.mum.framework.generator.id;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.HashMap;
import java.util.Map;

public class IDGenerator implements AutoGenerate{

	private static IDGenerator fileConnection= new IDGenerator();
	
	private IDGenerator(){}
	
	public static IDGenerator getInstance(){
		return fileConnection;
	}
	
	private void writeUniqueIdOnMap(Map<String, Integer> map){
		FileOutputStream f= null;
		ObjectOutputStream s = null;
		try{
			File file = new File("fileId.txt");
			f = new FileOutputStream(file);
	        s = new ObjectOutputStream(f);
	        s.writeObject(map);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
			
		}finally {
		    try {
				f.close();
		    	s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getUniqueId(String className){
		
		Map<String, Integer> uniquIdsMap =new HashMap<String, Integer>();
		FileInputStream f=null;
		ObjectInputStream s =null;

		int num = 10;
		
				
			try{
			File file = new File("fileId.txt");
			if(file.createNewFile()){
				int random = (int )(Math.random() * 100 + 1);
				uniquIdsMap.put(className, random);
				writeUniqueIdOnMap(uniquIdsMap);
				return String.valueOf(random);
			}
			
	        f = new FileInputStream(file);
	        s = new ObjectInputStream(f);

	 
			@SuppressWarnings("unchecked")	
			Map<String, Integer> readMap = (Map<String, Integer>) s.readObject();
			if(readMap.containsKey(className)){
				num = readMap.get(className);
				num = num +1;
				readMap.put(className, num);
			}else{
				num = (int )(Math.random() * 100 + 1);
				readMap.put(className, num);
	
			}
			writeUniqueIdOnMap(readMap);
			
		}catch(EOFException efe){
			
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
		    try {
		    	if(f!=null)
				f.close();
		    	//s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	return String.valueOf(num);		
	}
}
