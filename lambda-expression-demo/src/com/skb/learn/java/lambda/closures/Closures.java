package com.skb.learn.java.lambda.closures;

public class Closures {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		
		doProcess(10, new Processor() {

			@Override
			public void process(int i) {
				// Inner classes are able to access only final variable of the parent class
				// In Java 8 we do not need to exclusively declare b as final. Java automatically assumes it to be
				// final (closed variables). If you try to modify b then it will through an error
				System.out.println(a + b);
				
			}
			
		});
		
		// Same thing applies to Lambda expressions too
		// Lambda expressions can access the final variables of the parent class. T
		doProcess(a, c -> System.out.println( a+b));

	}

	private static void doProcess(int i, Processor processor) {
		processor.process(i);
	}
}


