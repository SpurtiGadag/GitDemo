package coreJavaprac;

import java.util.HashSet;
import java.util.Iterator;

public class hashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Hash Set, Tree Set, LinkedHashset implements Set interface
		//Does not accept dupicate values
		//No guarantee on the order the values are stored.
		
		HashSet<String> hs=new HashSet<String>(); 
		hs.add("USA");
		hs.add("UK");
		hs.add("India");
		System.out.println(hs);
		Iterator <String> it= hs.iterator();
		while(it.hasNext())

		{
			System.out.println(it.next());
		}
	}

}
