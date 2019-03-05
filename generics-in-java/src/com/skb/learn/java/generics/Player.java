package com.skb.learn.java.generics;

public abstract class Player {

	private String gameType;
	private String firstName;
	private String lastName;
	private int age;
	
	public Player(String firstName, String lastName,  int age, String gameType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gameType = gameType;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getGameType() {
		return gameType;
	}
	
	
}
