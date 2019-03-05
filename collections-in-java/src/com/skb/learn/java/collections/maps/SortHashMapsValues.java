package com.skb.learn.java.collections.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortHashMapsValues {

	public static void main(String[] args) {
		
		HashMap<Integer, String> hmap = new HashMap<>();
		
	      hmap.put(5, "A");
	      hmap.put(11, "C");
	      hmap.put(4, "Z");
	      hmap.put(77, "Y");
	      hmap.put(9, "P");
	      hmap.put(66, "Q");
	      hmap.put(0, "R");
	      System.out.println("Original Map: \n");
	      hmap.forEach((k,v) -> System.out.println(k + ":" + v));
	      
	      List<Map.Entry<Integer, String>> entryList = new ArrayList(hmap.entrySet());
	      Collections.sort(entryList, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				System.out.println("Comparing....");
				return o1.getValue().compareTo(o2.getValue());
			}
	    	  
	      });
	    
	      HashMap<Integer, String> sortedMap = new HashMap<>();
	      
	      entryList.forEach((e) -> {
	    	  Map.Entry<Integer, String> entry = (Map.Entry) e;
	    	  System.out.println("Value = " + e.getValue());
	    	  System.out.println("Key = " + e.getKey());
	    	  sortedMap.put(e.getKey(), e.getValue());
	      });
	    	  
	     System.out.println("\n\nSorted by Value-- \n");
	     //sortedMap.forEach((k,v) -> System.out.println(k + ":" +v));
	     
	     for(Integer key: sortedMap.keySet()) {
	    	 
	    	 System.out.println("Key = " + key);
	    	 System.out.println("Value = " + sortedMap.get(key));
	     }
	    
	}
}
