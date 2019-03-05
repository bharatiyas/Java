package com.skb.learn.java.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise4_PrintUsingConsumer {

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
		
		
		System.out.println("\n----------Using Lambda expressing with Predicate---------\n");
		// Using Consumer interface we can pass different implementation a function returning void, therefore we can
		// provide different implementations of sysout
		printAllWithPredicate(people, p -> {
			if(p.getAge() >= 30)
				return true;
			else
				return false;
		}, p -> System.out.println(p.getFirstName()));
		
		// Print age of all players whose name starts with 'S'
		
		printAllWithPredicate(people, p -> {
			if(p.getLastName().startsWith("S"))
				return true;
			else
				return false;
		}, p -> {
			System.out.println("Age of " + p.getFirstName() + " is: " + p.getAge());
		});
	}
	
	
	// Using Predicate interface defined by Java (java.util.function)
	// Predicate - defines the CONDITION TO BE TESTED on the Person objects being passed
	// Consumer  defines the ACTION to be performed 
	private static void printAllWithPredicate(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p: people) 
			if(predicate.test(p))
				consumer.accept(p);
	}
}
