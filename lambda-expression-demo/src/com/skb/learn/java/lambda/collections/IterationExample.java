package com.skb.learn.java.lambda.collections;

import java.util.Arrays;
import java.util.List;

import com.skb.learn.java.lambda.exercise.Person;

public class IterationExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Mahendra", "Dhoni", 35),
				new Person("Virat", "Kohli", 30),
				new Person("Shikhar", "Dhawan", 30),
				new Person("Kuldeep", "Singh", 24),
				new Person("Rohit", "Sharma", 28),
				new Person("Ishant", "Sharma", 32)
			);

		System.out.println("---------Using for loop--------\n");
		// Iterating using for loop
		for(int i=0; i < people.size();i++)
			System.out.println(people.get(i).toString());
		
		System.out.println("\n---------Using for-in loop--------\n");
		// Iterating using for-in loop
		for(Person p : people)
			System.out.println(p.toString());
		
		System.out.println("\n---------Using forEach and Lambda--------\n");
		// Both of the two ways are External Iterators. It is imerative way. We are controlling the iteration
		// Now the declaritively. It will use internal iterators
		people.forEach(p -> System.out.println(p));
		
		// It becomoes very easy for the processor to run in multiple threads because it is controlled by the JVM
		// and it may be printed in parallel by two different cores. This may not be sequential
		System.out.println("\n---------Using forEach and Lambda Method reference--------\n");
		people.forEach(System.out::println);
	}

}
