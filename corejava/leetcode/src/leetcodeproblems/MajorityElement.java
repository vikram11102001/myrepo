package leetcodeproblems;

public class MajorityElement {
    
	public int m1(int[] argInput) {
		
		int countElement = 1;
		for(int i = 0; i < argInput.length; i++) {
			for(int j = i + 1; j < argInput.length; j++) {
				if(argInput[j] == argInput[i]) {
					countElement++;
				}
			}
		}
		return countElement;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
        int[] input = {1, 2, 2, 4, 4, 4};
        MajorityElement obj = new MajorityElement();
        int result = obj.m1(input);
        System.out.println("Majority Element: " + result);
    }

    
}
