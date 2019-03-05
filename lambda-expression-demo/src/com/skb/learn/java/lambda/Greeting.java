package com.skb.learn.java.lambda;

@FunctionalInterface
public interface Greeting {

	public void perform();
	
	public default void newMethod() {
		System.out.println("");
	}
}
