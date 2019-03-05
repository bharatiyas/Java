package com.skb.learn.java.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise2_UsingCondition {

	public static void main(String[] args) {
		
		// Arrays.asList takes inline elements and creates a list. So we do not need
		// to create an ArrayList and call add method on it
		List<Person> people = Arrays.asList(
					new Person("Mahendra", "Dhoni", 35),
					new Person("Virat", "Kohli", 30),
					new Person("Shikhar", "Dhawan", 30),
					new Person("Kuldeep", "Singh", 24),
					new Person("Rohit", "Sharma", 28),
					new Person("Ishant", "Sharma", 32)
				);
		
		// Print people with Last name "Sharma"
		printAllWithCondition(people, new Condition() {

			@Override
			public boolean test(Person p) {
				if(p.getLastName().equals("Sharma"))
					return true;
				else
					return false;
			}
			
		});
		
		System.out.println("\n----------People having age more than 30---------\n");
		// Print people with age >= 30
		
		printAllWithCondition(people, new Condition() {

			@Override
			public boolean test(Person p) {
				if(p.getAge() >= 30)
					return true;
				else
					return false;
			}
			
		});
		
		System.out.println("\n----------Using Lambda expressing with condition---------\n");
		// Here Java understands that p is an instance of Person because printAllWithCondition()
		// Accepts and instance of the Condition and Condition's test() accepts a Person as an
		// input parameter. Therefore when we are calling printAllWithCondition() we are providing
		// an implementation (as second parameter) of the abstract test() 
		printAllWithCondition(people, p -> {
			if(p.getAge() >= 30)
				return true;
			else
				return false;
		});
	}
	
	
	private static void printAllWithCondition(List<Person> people, Condition condition) {
		for(Person p: people) 
			if(condition.test(p))
				System.out.println(p.toString());
	}
}
