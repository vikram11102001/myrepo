package leetcodeproblems;

import java.util.ArrayList;


public class WordsContainingCharacter {
	
	public ArrayList<Integer> findWordsContaining(String[] inWords, char inChar) {
		
		int lengthOfInWords = inWords.length;
		
		ArrayList<Integer> indexOfWords = new ArrayList<Integer>(lengthOfInWords);
		
		int i = 0;
		int j = 0;
		int k = 1;
		
		
		for(i = 0; i < lengthOfInWords; i++) {
			
			System.out.println("Loop " + k);
			k++;
			
			for(j = 0; j < inWords[i].length(); j++) {
				
				
				String checkingWord = inWords[i];
				
				System.out.println("Checking Word "+ checkingWord);
				
				char checkingLetter = checkingWord.charAt(j);
				
				System.out.println("Checking Letter " + checkingLetter);
				
				if(checkingLetter == inChar) {
					
					indexOfWords.add(i);
					break;
				}
			}
			
			System.out.println("-------------");
		}
		
		return indexOfWords;
		
	}
	
	public static void main(String[] args) {
		
		String[] words = {"abc","bcd","aaaa","cbc"};
		char ch = 'z';

		WordsContainingCharacter obj1 = new WordsContainingCharacter();
		
		System.out.println(obj1.findWordsContaining(words, ch));
		
		
	}

}
