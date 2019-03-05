package com.some.puzzle.strangecombination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CombinationFinder {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		long inputTime = in.nextLong();
		
		long value = 1;
		long secondValue = 1;
		long currValue = 3;
		long prevValue = 0;
		
		while(inputTime >= currValue) {
			prevValue = currValue;
			currValue = currValue*2;
		}
		
		if((inputTime - currValue) == -2) {
			System.out.println(currValue);
			System.exit(1);
		}
		
		secondValue = currValue - 1;
		if(inputTime == secondValue) {
			System.out.println(secondValue);
			System.exit(1);
		}
		
		secondValue = prevValue - 1;
		long timeDiff = inputTime - secondValue;
		value = secondValue - timeDiff;
		
		System.out.println(value);
		
	}
}
