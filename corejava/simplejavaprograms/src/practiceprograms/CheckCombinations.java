package practiceprograms;

import java.util.Stack;

public class CheckCombinations{
	public static void main(String[] args){
		char[] arr = {'{', '}', '}', '{', '{', '}'};
		int n = arr.length;
		if(n % 2 == 0){
			int open = 0;
			int close = 0;
			for(char ch : arr){
				if(ch == '{'){
					open = open + 1;
				}else{
					close = close + 1;
				}
			}
			if(open == close){
				Stack s1 = new Stack();
				for(int i = 0; i < n; i++){
					if (arr[i] == '{') {
                        s1.push(i); 
                    } else if (!s1.isEmpty()) {
                        s1.pop(); 
						
                    } else {
                        System.out.println("Not balanced");
                        
                    }
					
				}
				
			}else{
				System.out.println("Not balanced");
			}
			
		}else{
			System.out.println("Not balanced");
		}
	}
}