package coreJavaprac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hashMapExample {
	
	public static void main(String [] args)
	{
		//HashSet treeset, LinkedHashset implements Set interface 
		//does not accept duplicate values 
		// There is no guarantee elements stored in sequential order..Random order
		HashMap<Integer,String> Hm=new HashMap<Integer,String>();
		Hm.put(0,"Hello");
		Hm.put(1,"Hi");
		Hm.put(2,"Bye");
		Hm.put(3,"Hello");
	 System.out.println(Hm.get(2));
	 Set sn= Hm.entrySet();
	 Iterator it =sn.iterator(); //hashtable -pass table set collections 

	 while(it.hasNext()) 
	 { System.out.println(it.next());
	 Map.Entry mp=(Map.Entry)it.next();
	 System.out.print(mp.getKey()); 
	 System.out.print(mp.getValue());
	 System.out.println("");
	 }
	
	 }
	}

	

	


