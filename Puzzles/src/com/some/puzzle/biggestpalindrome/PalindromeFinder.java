package com.some.puzzle.biggestpalindrome;

public class PalindromeFinder {

	public static void main(String[] args) { 
		
		findSubPalindrome("swetyg");
	}
	
	
	public static void findSubPalindrome(String str) {
		
		int startPos=0, endPos=0;
		int palLen=0;
		String substr;
		
		boolean found = false;
		for(int i=0; i<(str.length() - 1); i++) {
			for(int j=(str.length());j>i;j--) {
				substr = str.substring(i, j);
				found = isPalindrome(substr);
				System.out.println("i = " + i + ", j= "+ j + ": " + substr + ": "+ found);
				if(found) {
					if((j-i) > palLen) {
						startPos = i;
						endPos = j;
						palLen = j-i;
					}
					
				}
			}
		}
		if(palLen > 1) {
			System.out.println("Start Pos = " + startPos);
			System.out.println("End Pos = " + endPos);
			System.out.println("Pal Length= " + palLen);
			System.out.println("Palindrome String = " + str.substring(startPos, endPos));
		} else
			System.out.println("There is no palindrome in the string");
		
	}
	
	public static boolean isPalindrome(String str) {
		
		int strLen = str.length();
		int strMid = strLen/2;
		
		for(int i=0;i<strMid;i++)
			if(str.charAt(i) != str.charAt(strLen-1-i))
				return false;
		
		return true;
	}
}
