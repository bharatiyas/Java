package com.skb.learn.java.collections.arrays;

// Comparable is needed in order to perform Binary Search
// Binary Search is very fast because it divides the collection every time in half it the element it is 
// searching lies in upper or lower half. For comparing it executes the compareTo()
public class Seat implements Comparable<Seat>{

	private String seatNumber;
	
	
	public Seat(String seatNumber) {
		super();
		this.seatNumber = seatNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public int compareTo(Seat seatToComapare) {
		return this.getSeatNumber().compareTo(seatToComapare.getSeatNumber());
	}

}
