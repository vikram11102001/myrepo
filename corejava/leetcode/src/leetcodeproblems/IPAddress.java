package leetcodeproblems;

public class IPAddress {
	
	public void defangIPAdress(String givenString, char beforeDot, char afterDot) {
		
		int lengthOfGivenString = givenString.length();
		
		int i = 0;
		int j = 0;
		int k = 1;
		
		StringBuffer str = new StringBuffer(givenString);
		
		
		for(i = 0; i < lengthOfGivenString; i++) {
			
			System.out.println("Loop " + k + ":-");
			System.out.println("         ");
			System.out.println("Value of i : " + i);
			char checkingCharacter = str.charAt(i);
			System.out.println("Checking Character : " + checkingCharacter);
			
			if(checkingCharacter == '.') {
				
				System.out.println("If block :-");
				System.out.println("      ");
			
				System.out.println("Before Inserting '[' the character in the index position " + i + " is " + str.charAt(i));
				str.insert(i, beforeDot);
				System.out.println("After Inserting '[' the charcter in the index position " + i + " is "+  str.charAt(i));
				System.out.println(str);
				System.out.println("********");
				j = i + 2;
				System.out.println("Before Inserting ']' the character in the index position " + j + " is " +  str.charAt(j));
				str.insert(j, afterDot);
				System.out.println("After Inserting ']' the character in the index position " + j + " is " + str.charAt(j));
				System.out.println(str);
				System.out.println("********");
				i=j;
				int newLength = str.length();
				lengthOfGivenString = newLength;
				System.out.println(newLength);
				
			}
			
			
			System.out.println("Value of i after inserting [ and ] : " + i);
			
			System.out.println("---------");
			System.out.println("Loop goes to check next character");
			System.out.println("---------");
			System.out.println("---------");
			k++;
		}
		
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		
		String address = "1.1.1.1";
		char insertBeforeDot = '[';
		char insertAfterDot = ']';
		
		IPAddress obj1 = new IPAddress();
		
		obj1.defangIPAdress(address, insertBeforeDot, insertAfterDot);
		
	}

}
