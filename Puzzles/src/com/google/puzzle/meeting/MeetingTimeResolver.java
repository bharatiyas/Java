package com.google.puzzle.meeting;

public class MeetingTimeResolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MeetingTimeResolver meetingResolver = new MeetingTimeResolver();
		int[][] meetings = new int[12][2];
		
		meetings[0][0] = 9;
		meetings[0][1] = 12;
		
		meetings[1][0] = 1;
		meetings[1][1] = 4;
		
		meetings[2][0] = 2;
		meetings[2][1] = 7;
		
		meetings[3][0] = 4;
		meetings[3][1] = 5;
		
		meetings[4][0] = 13;
		meetings[4][1] = 15;
		
		meetings[5][0] = 9;
		meetings[5][1] = 10;
		
		meetings[6][0] = 2;
		meetings[6][1] = 3;
		
		meetings[7][0] = 3;
		meetings[7][1] = 4;
		
		meetings[8][0] = 7;
		meetings[8][1] = 12;
		
		meetings[9][0] = 2;
		meetings[9][1] = 3;
		
		meetings[10][0] = 2;
		meetings[10][1] = 3;
		
		meetings[11][0] = 9;
		meetings[11][1] = 10;
		
		
		/*meetings[0][0] = 9;
		meetings[0][1] = 12;
		
		meetings[1][0] = 1;
		meetings[1][1] = 5;
		
		meetings[2][0] = 7;
		meetings[2][1] = 10;*/
		
		/*
		
		meetings[0][0] = 1;
		meetings[0][1] = 2;
		
		meetings[1][0] = 2;
		meetings[1][1] = 5;
		
		meetings[2][0] = 5;
		meetings[2][1] = 9;
		
		meetings[3][0] = 1;
		meetings[3][1] = 8;
		
		meetings[4][0] = 2;
		meetings[4][1] = 3;
		
		meetings[5][0] = 4;
		meetings[5][1] = 5;
		
		meetings[6][0] = 12;
		meetings[6][1] = 1000;*/
		
		meetingResolver.meetingOptimizer(meetings);
	}
	
	// This function assumes the following function:
	// f(x) = meetings[x][0] < meetings[x][1] for all 0<= x <= meetings.length
	// Hence it does not validates the data
	
	void meetingOptimizer(int[][] meetings) {
		
		//printArray(meetings);
		
		sortTwoDimArrary(meetings);
		
		//System.out.println("Array After sorting...... \n");
		
		//printArray(meetings);
		
		int[] keepValidityTrace = new int[meetings.length];
		
		for(int i=0; i < keepValidityTrace.length; i++)
			keepValidityTrace[i] = 1;
	
		int validity;
		
		for(int i=0;i<meetings.length-1;i++) {
			
			if(keepValidityTrace[i] == 1) {
				for(int j=i+1;j<meetings.length;j++) {
					if(keepValidityTrace[j] == 1) {
						validity = determineValidity(meetings[i][0], meetings[i][1], meetings[j][0], meetings[j][1]);
						if(validity == 0) {
							keepValidityTrace[i] = 0;
							break;
						} else if (validity == 11) {
							continue;
						} else if (validity == 10) {
							keepValidityTrace[j] = 0;
						}
					}
				}
			}
		}
		
		// Print and Get Validity
		System.out.println("Valid meetings are:: ");
		int validCounter = 0;
		for(int i=0; i < keepValidityTrace.length; i++) {
			if(keepValidityTrace[i] == 1) {
				validCounter++;
				System.out.println(meetings[i][0] + "," + meetings[i][1]);
			}
		}
		
		System.out.println("Hence total valid meetings = " + validCounter);
	}
	
	void printArray(int[][] twoDimArray) {
		
		System.out.println("Array Length = " + twoDimArray.length);
		for(int i=0;i<twoDimArray.length;i++) 
			System.out.println(i + ". " + twoDimArray[i][0] + " - " + twoDimArray[i][1]);
	}
	
	void sortTwoDimArrary(int[][] meetings) {
		
		int swapVar_0, swapVar_1;
		
		for(int i=0;i<meetings.length-1;i++) {
			for(int j=i+1;j<meetings.length;j++) {
				if(meetings[i][0] > meetings[j][0]) {
					swapVar_0 = meetings[i][0];
					swapVar_1 = meetings[i][1];
					
					meetings[i][0] = meetings[j][0];
					meetings[i][1] = meetings[j][1];
					
					meetings[j][0] = swapVar_0;
					meetings[j][1] = swapVar_1;
				}
				if(meetings[i][0] == meetings[j][0]) {
					
					if(meetings[i][1] > meetings[j][1]) {
						swapVar_1 = meetings[i][1];
						meetings[i][1] = meetings[j][1];
						meetings[j][1] = swapVar_1;
					}
				}
			}
			//printArray(meetings);
		}
		
	}
	
	// validity = 11 => both the pairs i.e. (ai, aj) and (bx, by) are valid. For TypeOfCase = 1, 2, 3
	// validity = 10 => (ai, aj) is valid and (bx, by) are invalid. For TypeOfCase = 5
	// validity = 0 => (ai, aj) is invalid. For TypeOfCase = 6, 7
	
	int determineValidity(int ai, int aj, int bx, int by) {
		int validity=0;
		
		if((ai == bx) && (aj > by)) { // For TypeOfCase = 4
			System.out.println("Invalid input - (" + ai + "," + aj + "),   (" + bx + ", " + by + ")");
			System.out.println(("This arrangement of data implies that meeting matrix has not been sorted. Exiting...."));
			System.exit(1);
			
		}
		if((ai < bx) && (aj < bx)) // TypeOfCase = 1  
			validity = 11;
		
		if((ai < bx) && (aj == bx)) // TypeOfCase = 2  
			validity = 11;
		
		if((ai < bx) && (aj > bx)) // TypeOfCase = 3  
			validity = 11;
		
		if((ai == bx) && (aj < by)) // TypeOfCase = 5
			validity = 10;
		
		if((ai < bx) && (aj > bx)) // TypeOfCase = 6
			validity = 0;
		
		if((ai < bx) && (aj == by)) // TypeOfCase = 7  
			validity = 0;
		
		if((ai == bx) && (aj == by)) // TypeOfCase = 8
			validity = 10;
		
		return validity;
	}

}
