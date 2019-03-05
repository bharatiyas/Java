package com.android.app.friends.transaction;

public class Transactions {

	int amount;
	String payer;
	String []participatingMembers;
	
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getPayer() {
		return payer;
	}
	
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	public String[] getParticipatingMembers() {
		return participatingMembers;
	}
	
	public void setParticipatingMembers(String[] participatingMembers) {
		this.participatingMembers = participatingMembers;
	}
	
}
