package com.some.puzzle.flowerbouquet;

public class CombinationFinder {

	static int quotientOf8;
	static int remainderOf8;
	
	public static void main(String[] args) {
		
		int inputNumber = 28;
		
		int quotientOf3 = 0;
		int quotientOf5 = 0;
		
		if(inputNumber < 3) 
			System.out.println("Cannot provide");
		
		if(inputNumber == 3) {
			System.out.println("Combination is: 8 * 0; 5 * 0 ; 3 * 1");
		}
			
		if(inputNumber == 4) {
			System.out.println("Combination is: 8 * 0; 5 * 0 ; 3 * 1; + 1");
		}
		
		if(inputNumber == 5) {
			System.out.println("Combination is: 8 * 0; 5 * 1 ; 3 * 0");
		}
		
		if(inputNumber == 6) {
			System.out.println("Combination is: 8 * 0; 5 * 0 ; 3 * 2");
		}
		
		if(inputNumber == 7) {
			System.out.println("Combination is: 8 * 0; 5 * 0 ; 3 * 2; + 1");
		}
		
		multiplesOfEight(inputNumber);		
		
		//System.out.println("quotientOf8 = " + quotientOf8);
		//System.out.println("remainderOf8 = " + remainderOf8);
		
		switch (remainderOf8) {
		
			case 9: quotientOf3 = 3;
					break;
			case 10: quotientOf5 =2;
					 break;
			case 3: quotientOf3 = 1;
					break;
			case 12: quotientOf3 = 4;
					break;
			case 5: quotientOf5 = 1;
					break;
			case 6: quotientOf3 = 1;
					break;
			case 15: quotientOf5 = 3;
					break;
				
		}
		
		System.out.println("Combination is: 8 * " + quotientOf8 + "; 5 * " + quotientOf5 + "; 3 * " + quotientOf3);
	}
	
	private static void multiplesOfEight(int number) {
		
		if(number < 8) {
			System.out.println("Number less than 8");
			return;
		}
		
		quotientOf8 = number / 8;
		remainderOf8 = number % 8;
		
		switch (remainderOf8) {
		
			case 1: quotientOf8--;
					remainderOf8=9;
					break;
			case 2: quotientOf8--;
					remainderOf8=10;
					break;
			case 3: break;
			case 4: quotientOf8--;
					remainderOf8=12;
					break;
			case 5: break;
			case 6: break;
			case 7: quotientOf8--;
					remainderOf8=15;
					break;
					
		}
		
		return;
	}
	
}
