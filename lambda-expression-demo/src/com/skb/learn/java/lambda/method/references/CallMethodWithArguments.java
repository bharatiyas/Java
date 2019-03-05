package com.skb.learn.java.lambda.method.references;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.skb.learn.java.lambda.exercise.Person;

public class CallMethodWithArguments {

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
		
		
				
		printAllWithPredicate(people, p -> {
			if(p.getLastName().startsWith("S"))
				return true;
			else
				return false;
		}, p -> System.out.println(p) // This will use the List.toString(). This is a pass through function
		);
		
		System.out.println("\n----------Printing with Method References---------\n");
		printAllWithPredicate(people, p -> true, System.out::println); 
								 // In this case we are using a static reference to get the "out" instance
								 // out is an (static) instance and we are calling println() on the instance
								 // So we then have instanceName::methodName
								 // The complier will know the parameter based on the signature of the called method
	}
	
	
	// Using Predicate interface defined by Java (java.util.function)
	private static void printAllWithPredicate(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p: people) 
			if(predicate.test(p))
				consumer.accept(p);
	}
}
