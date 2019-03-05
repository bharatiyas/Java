package com.skb.learn.java.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Exercise3_UsingPredicate {

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
		// This one works without any changes from previous implementation in Unit1ExerciseUsingCondition
		// because Lambda expressions do not care about the name of the Interface used.
		// Lambda expressions only care about the signature of the abstract method being
		// implemented. Therefore, the signature of the method implemented below should match
		// the signature of Predicate<Person>'s test()
		printAllWithCondition(people, p -> {
			if(p.getAge() >= 30)
				return true;
			else
				return false;
		});
	}
	
	
	// Using Predicate interface defined by Java (java.util.function)
	private static void printAllWithCondition(List<Person> people, Predicate<Person> predicate) {
		for(Person p: people) 
			if(predicate.test(p))
				System.out.println(p.toString());
	}
}
