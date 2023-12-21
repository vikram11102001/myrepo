package leetcodeproblems;

public class Pangram {
	
	public static void main(String[] args) {
		
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		String givenSentence = "def";
		
		int lengthOfAlphabets = alphabets.length();
		int lengthOfGivenSentence = givenSentence.length();
		int count = 0;
		/*if(givenSentence.contains("abcdefghijklmnopqrstuvwxyz")) {
			System.out.println("pangram");
		}else {
			System.out.println("not pangram");
		}*/
		
		
		
		for(int i = 0; i < lengthOfAlphabets; i++) {
			
			char c = alphabets.charAt(i);
			
			int j = 0;
			while(j<lengthOfGivenSentence) {
				
				char d = givenSentence.charAt(j);
					if(c==d) {
						count++;
						break;
					}else {
						j++;
						continue;
					}
					
				}
				
			
			/*for(int j = 0; j < lengthOfGivenSentence; j++) {
				
				char d = givenSentence.charAt(j);
				
				while(c==d) {
					
				}
			}*/
			
			
		}
		if(count == lengthOfAlphabets) {
			System.out.println("It is pangram");
		}else {
			System.out.println("It is not pangram");
		}
	}

}
