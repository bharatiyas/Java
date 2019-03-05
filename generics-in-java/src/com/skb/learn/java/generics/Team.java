package com.skb.learn.java.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Team <T extends Player> implements Comparable<Team<T>> {

	private String name;
	private int score;
	private int ranking;
	private List<T> players;
	
	public Team(String name) {
		this.name = name;
		score = 0;
		ranking = 0;
		players = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<T> getPlayers() {
		return players;
	}

	public void addPlayer(T player) {
		if(!players.contains(player))
			players.add(player);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public void printMatchResult(Team<T> oponent, int ourScore, int theirScore) {
		
		if(this.getName() != oponent.getName()) {
			if(ourScore > theirScore) {
				score += ourScore;
				System.out.println(this.name + " won the game!!");
			}else if(theirScore > ourScore) {
				System.out.println(oponent.name + " won the game!!");
			}else
				System.out.println("Match was a draw");
		
		}
	}

	@Override
	public int compareTo(Team<T> otherTeam) {
		if(this.ranking > otherTeam.getRanking())
			return -1;
		else if(this.ranking < otherTeam.getRanking())
			return 1;
		else 
			return 0;
		
	}
}
