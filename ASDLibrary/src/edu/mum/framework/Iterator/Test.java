package edu.mum.framework.Iterator;

import java.util.Arrays;
import java.util.List;

public class Test {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<String> list=Arrays.asList("A","B","C","D");
		Iterator it=new ItemConcreteAggregate(list).getIterator();
		while(it.hasNext())
			System.out.println(it.next());
		
	}

}
