package com.skb.learn.java.lambda;

public class RunnableExample {

	public static void main(String[] args) {

		// This is an example of passing anonymous inner class as an argument. 
		// So we are not defining a separate class implementing Runnable interface 
		// passing it to Thread's constructor. Instead we are defining an implementation
		// of Runnable interface (function interface) inline and not giving any class name. 
		// We are directly assigning it to a variable of type Greeting
		Thread annonymourInnerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Running inside anonymous inner class");
				
			}
			
		});
		
		annonymourInnerThread.run();
		
		// In this case, by the virtue of Type Inference the compiler knows that
		// the constructor of Thread class takes an implementation of Runnable
		// Therefore, compiler understands that whatever lambda expression we provide inside
		// () of "new Thread()" is an implementation class of Runnable and the body of
		// the lambda expression is an implementation of the run() of Runnable
		// We could avoid the bioler plate code of implementing Runnable
		Thread lambdaThread = new Thread( () -> {
			System.out.println("Running inside Lamdba expression!!!!");
		});

		lambdaThread.run();
	}

}
