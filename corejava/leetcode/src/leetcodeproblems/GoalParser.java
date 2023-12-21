package leetcodeproblems;

public class GoalParser {
	
	public static void main(String[] args) {
		
		String input = "(al)G(al)()()G";
		String output = "";
		
		int i = 0;
		
		for(i = 0; i < input.length(); i++) {
			
			char ch = input.charAt(i);
			
			if(ch == 'G') {
				output = output + ch; 
			}else if(ch == '('){
				char j = input.charAt(i+1);
				if(j == ')') {
					output = output + 'o';
				}else {
					output = output + "al";
				}
			}
		}
		System.out.println(output);
	}

}
