package com.skb.learn.java.collections.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Mahendra", "Dhoni", 35),
				new Person("Virat", "Kohli", 30),
				new Person("Shikhar", "Dhawan", 30),
				new Person("Kuldeep", "Singh", 24)
		);

		// This sort() method uses the compareTo() of Person class as Person implements Comparable
		Collections.sort(people);
		System.out.println("Sorted List based on compareTo(): ");
		people.forEach(p -> System.out.println(p));
		
		// The reverse() also uses the compareTo()
		Collections.reverse(people);
		System.out.println("Reverse List based on compareTo(): ");
		people.forEach(p -> System.out.println(p));
		
		System.out.println("\n\nDealing with men----------------------\n\n");
		List<Man> men = Arrays.asList(
				new Man("Mahendra", "Dhoni", 35),
				new Man("Virat", "Kohli", 30),
				new Man("Shikhar", "Dhawan", 30),
				new Man("Kuldeep", "Singh", 24)
		);
		
		// Sorting men list based on Comparator
		// Advantage of using Comparator like this is that you can provide different implementations at different times
		Collections.sort(men, new Comparator<Man>() {

			@Override
			public int compare(Man m1, Man m2) {
				return m1.getAge() - m2.getAge();
			}
		});
		

		
		Comparator<Man> mens = Collections.reverseOrder((m1, m2) -> m1.getAge() - m2.getAge());
		
		Collections.sort(men, (m1, m2) -> m1.getAge() - m2.getAge());
		
	}

}

class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public int getAge() {
		return age;
	}


	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}


	@Override
	public int compareTo(Person otherPerson) {
		
		return this.getAge() - otherPerson.getAge();
	}



	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
}

class Man {
	
	private String firstName;
	private String lastName;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public int getAge() {
		return age;
	}


	public Man(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Man [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
}