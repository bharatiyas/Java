package com.skb.learn.java.collections.arrays;

import java.util.Arrays;
import java.util.Scanner;

// Default values of numeric arrays are set to 0.
// String and other objects are by default initialized to null.
// Boolean array is initialized to false.
public class ArrayDemo {

	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] intArray = new int[10];
		String[] stringArray = new String[20];
		
		intArray[3] = 8;
		stringArray[2] = "Hello!!";
		
		// Inline initilization. Tells Java about the size required
		int[] intArray2 = {1,2,3,3,4,4,4,4,55,5,5};
		
		String[] strArray = {"one", "two", "three"};
	
		int[] userIntArray = getIntegers(5);
		
		System.out.println("Numbers entered are: \n");
		for(int i=0; i < userIntArray.length;i++)
			System.out.println(userIntArray[i]);
		
		// Copy an Array
		int[] newIntArray = new int[userIntArray.length]; 
		newIntArray = Arrays.copyOf(userIntArray, userIntArray.length);
		
		
		System.out.println("Copied array is: \n");
		for(int i=0; i < newIntArray.length;i++)
			System.out.println(newIntArray[i]);
		
		
		// Resize an array
		int[] resizedIntArray = new int[userIntArray.length + 5]; 
		resizedIntArray = Arrays.copyOf(userIntArray, userIntArray.length + 5);
		userIntArray = resizedIntArray;
		
		System.out.println("Resized Array array is: \n");
		for(int i=0; i < userIntArray.length;i++)
			System.out.println(userIntArray[i]);
		
		// To void this resizing of arrays we use List and ArrayList as it handles resizing automatically
		
	}

	private static int[] getIntegers(int i) {
		int[] ints = new int[i];
		
		System.out.println("Please enter " + i + "values \n -- ");
		for(int j=0; j < i ; j++)
			ints[j] = scanner.nextInt();
			// To read whole line (String)
			// String entry  scanner.nextLine();
		
		return ints;
	}
	
	

}
