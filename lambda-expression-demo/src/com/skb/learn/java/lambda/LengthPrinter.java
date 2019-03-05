package com.skb.learn.java.lambda;

public class LengthPrinter {

	public static void main(String[] args) {

		LengthLamdba strLen = s -> s.length();
		System.out.println(strLen.getIntValue("Hello Lambda"));
		
		printInteger(s -> s.indexOf('L'));
	}

	private static void printInteger(LengthLamdba lengthLamdba ) {
		int intValue = lengthLamdba.getIntValue("Welcome to Lambda");
		System.out.println(intValue);
	}
}
