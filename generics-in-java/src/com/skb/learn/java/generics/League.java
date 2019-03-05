package com.skb.learn.java.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class League <T extends Team> {

	private List<Team> teams;
	private String name;
	
	public League(String name) {
		this.name = name;
		teams = new ArrayList<>();
	}

	public List<Team> getTeams() {
		return teams;
	}

	public String getName() {
		return name;
	}
	
	public void addTeam(T team) {
		if(!teams.contains(team))
			teams.add(team);
	}
	
	public void printOrderedTeamList() {
		teams.sort(new Comparator<Team>() {

			@Override
			public int compare(Team t1, Team t2) {
				
				return (t1.getRanking() - t2.getRanking());
			}
			
		});
		
		teams.stream()
		.forEach(p -> System.out.println(p.getName()));
	}
	
	public void showLeagueTable() {
		Collections.sort(teams);
		teams.forEach(p -> System.out.println(p.getRanking() + " : " +p.getName()));
	}
}
