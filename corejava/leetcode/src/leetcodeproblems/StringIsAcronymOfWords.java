package leetcodeproblems;

public class StringIsAcronymOfWords {
	
	public void checkAcronym(String[] words, String str) {
		
		int lengthOfWords = words.length;
		int lengthOfStr = str.length();
		int i = 0;
		String outputString = "";
		
		if(lengthOfWords == lengthOfStr) {
			
			for(i = 0; i < lengthOfWords; i++) {
				
				char checkingCharacter = str.charAt(i);
				
				String checkingWord = words[i];
				
				char firstLetter = checkingWord.charAt(0);
				
				if(firstLetter == checkingCharacter) {
					outputString = outputString + firstLetter;
				}else {
					break;
				}
				
			}
			if(outputString.equals(str)) {
				System.out.println("The String str is acronym of Words");
			}else {
				System.out.println("The String str is not an acronym of Words");
			}
			
		}else {
			System.out.println("The String str is not an acronym of Words");
		}
	}
	
	public static void main(String[] args) {
		
		String[] words = {"never","gonna","give","up","on","you"};
		String str = "ngguoy";
		
		StringIsAcronymOfWords obj1 = new StringIsAcronymOfWords();
		obj1.checkAcronym(words, str);
	}

}
