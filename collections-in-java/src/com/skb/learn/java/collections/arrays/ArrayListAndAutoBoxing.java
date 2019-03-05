package com.skb.learn.java.collections.arrays;

import java.util.ArrayList;

// List and ArrayList as it handles resizing (reduces and increases) automatically
// It has other easy methods like contains and indexOf which avoids looping through arrays
public class ArrayListAndAutoBoxing {

	// Four most important methods of ArrayList
	
	// 1. add(item)
	// 2. set(int, item)
	// 3. get(int position)
	// 4. remove(int position)
	// 5. size()
	// 6. contains()
	// 7. indexOf

	public static void main(String[] args) {
		ArrayList<String> stringList = new ArrayList<>();
		stringList.add("Item1");
		stringList.add("Item2");
		// To copy AL. this creates a shallow copy
		ArrayList<String> copyOfStringList = new ArrayList<>(stringList);
	
		System.out.println("From Copy: " + copyOfStringList.get(1));
		
		stringList.add("Item3");
		
		ArrayList<String> copy2OfStringList = new ArrayList<>();
		copy2OfStringList.addAll(stringList);
		
		System.out.println("From Copy2: " + copyOfStringList.get(1));
		
		// Converting to an Array
		String[] stringArray = new String[stringList.size()];
		stringArray = stringList.toArray(stringArray);
		
		System.out.println("From Array: " + stringArray[1]);
		
		
		ArrayList<Integer> integerAL = new ArrayList<>();
		
		// Auto Boxing – Converting a primitive type to Wrapper class type
		// Java automatically creates Integer object wrapping 10
		Integer intVal = 10;
		integerAL.add(intVal);
		
		// Unboxing – Converting the Wrapper class type to primitive type
		// Java it automatically converting the wrapper object to primitive
		int i = integerAL.get(0);
		System.out.println("int value returned = " + i);
	}
}
