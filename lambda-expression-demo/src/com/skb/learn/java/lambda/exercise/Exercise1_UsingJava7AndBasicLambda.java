package com.skb.learn.java.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise1_UsingJava7AndBasicLambda {

	public static void main(String[] args) {
		
		// Arrays.asList takes inline elements and creates a list. So we do not need
		// to create an ArrayList and call add method on it
		List<Person> people = Arrays.asList(
					new Person("Mahendra", "Dhoni", 35),
					new Person("Virat", "Kohli", 30),
					new Person("Shikhar", "Dhawan", 30),
					new Person("Kuldeep", "Singh", 24)
				);
		
		
		// Sort list by last name
		people.sort(new Comparator<Person>() {

			@Override
			public int compare(Person arg0, Person arg1) {
				return arg0.getLastName().compareTo(arg1.getLastName());
			}
			
		});
		
		// Print all elements using Java 7 way
		System.out.println("-----------------------\n");
		System.out.println("Java 7 way \n");
		System.out.println("-----------------------\n");
		printAll(people);
		
		// Print all elements in the list using Lambda
		people.forEach(s -> System.out.println(s));
		
		System.out.println("-----------------------\n");
		
		// Print all element with lastname starting with D
		people.forEach(s -> {
			if(s.getLastName().startsWith("D"))
				System.out.println(s);
		});
	}
	

	private static void printAll(List<Person> people) {
		
		for(Person p: people)
			System.out.println(p.toString());
	}
}
