package com.skb.learn.java.lambda;

public class Greeter {

	public static void main(String[] args) {
		
		// We have 3 ways of using foo()
		Greeting lambdaExpr = () -> System.out.println("Hello Lambda!!");
		Greeting implClass = new GreetingImpl();
		
		// This is an anonymous inner class. So we are not defining a separate class
		// implementing Greeting interface. Instead we are defining it and not giving 
		// any class name. We are directly assigning it to a variable of type Greeting
		Greeting inlineImpl= new Greeting() {
					public void perform() {
						System.out.println("Hello from inline implementation!!");
					}
				};

		// Now we can use all the three implementations
		lambdaExpr.perform();
		implClass.perform();
		inlineImpl.perform();

		System.out.println(">>>>>>Passing lambda as input<<<<<<<");
		Greeter greeter = new Greeter();
		greeter.greet(() -> System.out.println("Hello Lambda!!"));
	}
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}
}
