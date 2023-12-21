package leetcodeproblems;

public class NumberOfMatches {
	
	public void countMatches(int teams) {
	
		int inpTeams = teams;
		int matches = 0;
		int outputMatches = 0;
		int j = 1;
		
		while(inpTeams > 1) {
			
			System.out.println("Round " + j);
		 
			if(inpTeams % 2 == 0) {
				System.out.println("No of teams playing in Round" + " " + j + " is" + " " + inpTeams );
				matches = inpTeams/2;
				inpTeams = matches;
				System.out.println("No of matches in Round" + " " + j + " is" + " " + matches );
			}
			
			else{
				System.out.println("No of teams playing in Round" + " " + j + " is" + " " + inpTeams );
				matches = (inpTeams - 1) / 2;
				inpTeams = matches + 1;
				System.out.println("No of matches in Round" + " " + j + " is" + " " + matches );
			}
			
			outputMatches = outputMatches + matches;
			j++;
		}
		
		System.out.println("Total no of matches in the tournament is " + outputMatches);
	}

	public static void main(String[] args) {
		
		int noOfTeams = 14;
		
		NumberOfMatches obj1 = new NumberOfMatches();
		obj1.countMatches(noOfTeams);
	}
}
