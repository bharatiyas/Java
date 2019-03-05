package com.skb.learn.java.lambda.thisreference;

import com.skb.learn.java.lambda.closures.Processor;

public class ThisReference {

	public static void main(String[] args) {
		
		ThisReference thisRef = new ThisReference();
		
		// new Processor() creates an implementation of the Processor interface but it is an inner class inside
		// ThisReference, hence its (new Processor()) parent class is ThisReference 
		thisRef.doProcess(10, new Processor() {

			@Override
			public void process(int i) {
				System.out.println("Integer received is: " + i);
				// this will work here since it is executing in the process method of the inner class which is not a 
				// static method like main. In main() you will not be able to refer to this because it is static, and
				// static does not belong to any object, its at the class level. 
				// Will print something like: com.skb.learn.java.lambda.thisreference.ThisReference$1@15db9742
				// $1 in above shows that this is an Inner class object
				System.out.println(this);
		
			}
			
		});
		
		
		thisRef.doProcess(10, i -> {
			
			System.out.println(i);
			// Lambda expressions does not override "this". So the value of "this" inside a lambda expression is as the
			// value outside it or the function in which it is used, in this case main(). 
			// Here main() will not have access to this because main() is static there for the lambda expressions inside
			// main() will also not have access to this
			
			// >>>>>>>>>  System.out.println(this);
		});
		
		thisRef.testThis();
	}

	
	private void testThis() {
	
		this.doProcess(10, i -> {
			System.out.println("\n----------\n" + i);
			// Here this can be accessed by lambda expression because testThis() has access to "this"
			// It will print something like: com.skb.learn.java.lambda.thisreference.ThisReference@3e3abc88
			// It point to an instance of ThisReference
			System.out.println(this);
		});
		
		
	}
	
	private void doProcess(int i, Processor processor) {
		processor.process(i);
	}

		
}
