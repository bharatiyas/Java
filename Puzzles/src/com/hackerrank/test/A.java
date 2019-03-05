package com.hackerrank.test;

class Two {
	byte x;
	
}

public class A {

	public final int getSum(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		
		Two t = new Two();
		System.out.println(t.x + " ");
		Two tt = fix(t);
		System.out.println(t.x + " ");
		System.out.println(tt.x + " ");
	}
	
	public static Two fix(Two tt) {
		tt.x = 42;
		
		return tt;
	}
}
