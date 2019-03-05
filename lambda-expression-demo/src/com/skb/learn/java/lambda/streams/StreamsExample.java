package com.skb.learn.java.lambda.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.skb.learn.java.lambda.exercise.Person;

public class StreamsExample {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Mahendra", "Dhoni", 35),
				new Person("Virat", "Kohli", 30),
				new Person("Shikhar", "Dhawan", 30),
				new Person("Kuldeep", "Singh", 24),
				new Person("Rohit", "Sharma", 28),
				new Person("Ishant", "Sharma", 32)
			);
		
		// Print persons whose age >= 30 using streams
		
		// Print using Lambda expressions
		printPersons(people, p -> p.getAge() >= 30, p -> System.out.println(p));
		
		System.out.println("------- Print using Streams---------");
		
		// Using Streams
		// Returns a sequential Stream with this collection as its source
		people.stream()
		.filter(p -> p.getAge() >= 30) // Only the elements passing this Prediction test() will pass down to forEach()
		.forEach(p -> System.out.println(p));

		// Count the number of persons having last name = "Sharma" using Parallel Stream
		// Parallel stream enable parallel processing by spliting the stream into multiple streams
		long count = people.parallelStream()
		.filter(p -> p.getLastName().startsWith("Sharma"))
		.count();
		
		System.out.println("Count the number of persons having last name = \"Sharma\": " + count);
	}

	private static void printPersons(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		
		for(Person p : people)
			if(predicate.test(p))
				consumer.accept(p);
	}
}
