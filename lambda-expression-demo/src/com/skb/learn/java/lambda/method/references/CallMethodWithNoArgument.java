package com.skb.learn.java.lambda.method.references;

public class CallMethodWithNoArgument {

	public static void main(String[] args) {

		// Using normal Lambda expressions, i.e. applying the syntax of Runnable.run() which is public void run()
		Thread t1 = new Thread(() -> doProcess());
		t1.start();

		// Now using Method References in the case where you do not need to pass any arguments to the method
		// So you have ClassName::methodName when you are calling a Static method i.e. doProcess()
		Thread t2 = new Thread(CallMethodWithNoArgument::doProcess);
		t2.start();
		
		// To call a non-static method we use:
		// objectName::methodName
		CallMethodWithNoArgument obj = new CallMethodWithNoArgument();
		Thread t3 = new Thread(obj::doProcessNonStatic);
		t3.start();
	}

	private static void doProcess() {
		System.out.println("Print to console");
	}
	
	private void doProcessNonStatic() {
		System.out.println("Print to console");
	}
}
