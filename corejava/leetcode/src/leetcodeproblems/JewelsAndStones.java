package leetcodeproblems;

public class JewelsAndStones {

	public static void main(String[] args) {
		
		String jewels = "z";
		String stones = "ZZ";
		
		int i = 0;
		int j = 0;
		int count = 0;
		
		for(i = 0; i < jewels.length(); i++) {
			
			char jewelsCharacter = jewels.charAt(i);
			
			for(j = 0; j < stones.length(); j++) {
				
				char stonesCharacter = stones.charAt(j);
				
				if(jewelsCharacter == stonesCharacter) {
					
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
