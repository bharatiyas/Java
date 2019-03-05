package com.android.app.friends.transaction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResolvePayments {

	static String [] globalMembers = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	
	public static void main(String[] args) {
		
		ResolvePayments resolver = new ResolvePayments();
		resolver.readTransactionDetails();
	}
	
	public void readTransactionDetails() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Enter number of members: ");
			int numOfMembers = Integer.parseInt(br.readLine());
			
			String [] members = new String[numOfMembers];
			
			System.out.print("\n Your Transaction members are: ");
			for(int memNum=0;memNum < numOfMembers;memNum++) {
				members[memNum] = globalMembers[memNum];
				System.out.print(members[memNum] + " ");
			}
			
			//System.out.println("Number of members are:  " + numOfMem);
			System.out.println("Enter number of Transactions: ");
			int numOfTransactions = Integer.parseInt(br.readLine());
			Transactions[] transactions = new Transactions[numOfTransactions];
			
			for(int i=0; i < numOfTransactions; i++) {
				transactions[i] = new Transactions();
				System.out.println("Enter data for Transaction #" + i);
				System.out.print("Total amount spent - ");
				transactions[i].setAmount(Integer.parseInt(br.readLine()));
				
				int numOfAttempts = 0;
				while(numOfAttempts < 3) {
					System.out.print("Who made the payment - ");
					transactions[i].setPayer(br.readLine());
					if(validateMember(members, transactions[i].getPayer()))
						break;
					else
						numOfAttempts++;
				}
				
				if(numOfAttempts == 3) {
					System.out.println("Invalid member entered in all the attempts hence exiting....");
					System.exit(1);
				}
					
				String participation;
				String [] participatingMembers
				for(int memNum=0;memNum < numOfMembers;memNum++) {
					System.out.print("Member " + members[memNum] + " participated in transaction[Y/N  Default=N] : ");
					participation = br.readLine();
					if(participation.equals("Y"))
						transactions[i].setParticipatingMembers()
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private boolean validateMember(String [] members, String memberToValidate) {
		
		boolean valid = false;
		
		for(String member : members) {
			if(memberToValidate.equals(member)) {
				valid = true;
				break;
			}
		}
			
		return valid;
	}

}
