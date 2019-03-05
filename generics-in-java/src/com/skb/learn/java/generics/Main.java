package com.skb.learn.java.generics;

public class Main {

	public static void main(String[] args) {
		
		FootballPlayer baichung = new FootballPlayer("Baichung", "Bhutia", 28);
		FootballPlayer sunil = new FootballPlayer("Sunil", "Chetri", 24);
		FootballPlayer im = new FootballPlayer("I M", "Vijayan", 28);
		
		CricketPlayer dhoni = new CricketPlayer("Mahendra", "Dhoni", 35);
		CricketPlayer bhubneshwar = new CricketPlayer("Bhubneshwar", "Kumar", 25);
		CricketPlayer virat = new CricketPlayer("Virat", "Kohli", 30);
		CricketPlayer gautam = new CricketPlayer("Gautam", "Gambhir", 36);
		
		HockeyPlayer sardar = new HockeyPlayer("Sardar", "Singh", 32);
		HockeyPlayer gagan = new HockeyPlayer("Gagandeep", "Singh", 26);
		HockeyPlayer akash = new HockeyPlayer("Akashdeep", "Singh", 24);
		
		Team<FootballPlayer> manipurFootballClub = new Team<>("Manipur Football Club");
		Team<FootballPlayer> delhiFootballClub = new Team<>("Delhi Football Club");
		
		
		Team<CricketPlayer> chennaiSuperKings = new Team<>("Chennai Super Kings");
		Team<CricketPlayer> bangaloreRoyalChallengers = new Team<>("Bangalore Royal Challengers");
		Team<CricketPlayer> kolkataNightRiders = new Team<>("Kolkata Night Riders");
		
		Team<HockeyPlayer> indianHockeyTeam = new Team<>("Indian Hockey Team");
		
		manipurFootballClub.addPlayer(baichung);
		delhiFootballClub.addPlayer(sunil);
		delhiFootballClub.addPlayer(im);
		
		chennaiSuperKings.addPlayer(dhoni);
		chennaiSuperKings.addPlayer(bhubneshwar);
		bangaloreRoyalChallengers.addPlayer(virat);
		kolkataNightRiders.addPlayer(gautam);
		
		indianHockeyTeam.addPlayer(sardar);
		indianHockeyTeam.addPlayer(akash);
		indianHockeyTeam.addPlayer(gagan);
		
		manipurFootballClub.printMatchResult(delhiFootballClub, 3, 4);
		System.out.println("Score " + manipurFootballClub.getScore());
		
		chennaiSuperKings.printMatchResult(bangaloreRoyalChallengers, 3, 3);
		
		chennaiSuperKings.setRanking(6);
		bangaloreRoyalChallengers.setRanking(4);
		kolkataNightRiders.setRanking(1);
		
		League<Team<CricketPlayer>> cricketLeague = new League<>("Cricket League");
		cricketLeague.addTeam(kolkataNightRiders);
		cricketLeague.addTeam(bangaloreRoyalChallengers);
		cricketLeague.addTeam(chennaiSuperKings);
		
		League<Team<HockeyPlayer>> hockeyLeague = new League<>("Hockey League");
		hockeyLeague.addTeam(indianHockeyTeam);
		
		cricketLeague.printOrderedTeamList();
		
		cricketLeague.showLeagueTable();
	}

}
