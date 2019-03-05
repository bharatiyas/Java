package com.skb.learn.java.collections.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class SortHashMapsKeys {

	public static void main(String[] args) {
		
		HashMap<Integer, String> hmap = new HashMap<>();
		hmap.forEach((k,v) -> System.out.println(k + ":" + v));
	      hmap.put(5, "A");
	      hmap.put(11, "C");
	      hmap.put(4, "Z");
	      hmap.put(77, "Y");
	      hmap.put(9, "P");
	      hmap.put(66, "Q");
	      hmap.put(0, "R");
	      
	      // Treemap will automatically put entries sorted by keys. 
	      TreeMap<Integer, String> tmap = new TreeMap<>(hmap);
	    
	    tmap.forEach((k,v) -> System.out.println(k + ":" + v));
	    
	      
	}
}
