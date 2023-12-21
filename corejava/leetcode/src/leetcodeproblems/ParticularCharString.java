package leetcodeproblems;


public class ParticularCharString {
    public static void main(String[] args) {
    	String[] inString = {"AA", "AAAA", "BAB", "CCCC","RRRR"};
        char ch = 'R'; 

        int count = 0;
        for (int i = 0; i < inString.length; i++) {
        	
            
            char[] inChar = inString[i].toCharArray();
            int temp = 0;
            
            int j = 0;
            while( j < inString[i].length()) {
            	
                if (inChar[j] == ch) {
                    temp++;
                    j++;
                    
                }else {
                	break;
                }
            }

            if (temp == inString[i].length()) {
            	
                count++;
               
                
            }
        }

        System.out.println("Count : " + count);
    }
}