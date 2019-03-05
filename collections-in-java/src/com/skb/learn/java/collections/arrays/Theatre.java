package com.skb.learn.java.collections.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {

	private List<Seat> seats = new ArrayList<>();

	public void populateSeats() {
		for (char row = 'A'; row <= 'Z'; row++) {
			for (int i = 1; i <= 01; i++) {
				seats.add(new Seat(Character.toString(row).concat(Integer.toString(i))));
			}
		}
	}
	
	public boolean reserveSeat(String requestedSeatNumber) {
		Seat requestSeat = new Seat(requestedSeatNumber);
		// It is the fastest way to find an item in a sorted list
		int foundSeat = Collections.binarySearch(seats, requestSeat);
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("Hello");
		al.add("World");
		al.add("Lambda");
		al.add("java");
		
		// Uses Merge Sort
		Collections.sort(al);
		
		al.forEach(p -> System.out.println(p));
		
		System.out.println("----------------------\n");
		
		ArrayList<String> alNew = new ArrayList<>();
		alNew.add("Hello");
		alNew.add("World");
		alNew.add("Lambda");
		alNew.add("java");
		alNew.add("Collections");
		
		alNew.stream()
		.sorted()
		.forEach(p -> System.out.println(p));
		
		Collections.reverse(alNew);
		
		// Shuffles the List in random order
		Collections.shuffle(alNew);
		
		Collections.min(alNew); // Uses compareTo()
		Collections.max(alNew); // Uses compareTo()
		
		Collections.swap(alNew, 2, 4); // This can be used in simple and buble sort
		
		//Collections.copy(); // Creates a deep copy
		
	}
}
