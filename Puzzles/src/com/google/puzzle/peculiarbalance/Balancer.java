package com.google.puzzle.peculiarbalance;

public class Balancer {

	static int[] weightsAvailable = new int[20];
	
	static {
		for(int i=0; i < 20; i++)
			weightsAvailable[i] = (int) Math.pow(3, i);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int x = 0;
		try {
			x = Integer.parseInt(args[0]);
		}catch(NumberFormatException e) {
			System.out.println("Input not a number");
			System.exit(1);
		}
		
		if(x < 1 || x > 1000000000) {
			System.out.println("Invalid number. It cannot be balanced");
			System.exit(1);
		}
		System.out.println("Answer(x) = " + answer(x));
	}
	
	private static String answer(int x) {
		String leftWeights = "";
		String rightWeights = "";
		
		int l = 0, r = 0, modOfX = 0;
		int sumOfWeights, setLength;
		
		while(x != 0) {
			sumOfWeights = 0;
			modOfX = Math.abs(x);
			for(setLength=0; setLength<20; setLength++) {
				sumOfWeights += weightsAvailable[setLength];
				if(modOfX > sumOfWeights) 
					continue;
				else
					break;
			}
			
			if(x > 0) {
				x = x - weightsAvailable[setLength];
				r += weightsAvailable[setLength];
				rightWeights = rightWeights.concat(",").concat(Integer.toString(weightsAvailable[setLength]));
			} else if(x < 0) {
				x = x + weightsAvailable[setLength];
				l += weightsAvailable[setLength];
				leftWeights = leftWeights.concat(",").concat(Integer.toString(weightsAvailable[setLength]));
			} 
		}
		
		if(leftWeights.length() == 0)
			leftWeights = ", ";
		
		System.out.println(leftWeights.substring(1) + " - " + rightWeights.substring(1));
		
		String balancedWeight = Integer.toString(l).concat(" - ").concat(Integer.toString(r));
		return balancedWeight;
	}
}