package leetcodeproblems;

public class LengthOfLastWord {
	
	public static void main(String[] args) {
		String s1 = "luffy is still joyboy";
		String s2[] = s1.split(" ");
		System.out.println(s2[0]);
		int n = s2.length;
		int i = 0;
		
		for(i = 0; i < n; i++) {
			if(i == n - 1) {
				System.out.println(s2[i].length());
			}else {
				continue;
			}
		}
	}

}
