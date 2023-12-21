package leetcodeproblems;

public class TruncateSentence {
	
	public void truncateSentence(String str, int k) {
		
		String[] inStrArray = str.split(" ");
		int i = 0;
		String outputStr = "";
		
		do{
			
			outputStr = outputStr + inStrArray[i] + " ";
			i++;
		}while(i < k);
		
		System.out.println(outputStr);
		
	}

	public static void main(String[] args) {
		
		String str = "chopper is not a tanuki";
		int k = 5;
		
		TruncateSentence obj1 = new TruncateSentence();
		obj1.truncateSentence(str, k);
	}
}
