package leetcodeproblems;

public class MaxProdOfTwoElementsInArray {
	
	public void maxProduct(int[] nums, int lengthOfNums) {
		
		int i = 0;
		int j = 0;
		
		
		int checkingNumber = 0;
		for(i = 0; i < lengthOfNums; i++) {
			
			for(j = i + 1; j < lengthOfNums; j++) {
				
				int product = (nums[i] - 1)*(nums[j] - 1);
				
				if(product > checkingNumber) {
					 checkingNumber = product;
				}
			}
		}
		System.out.println(checkingNumber);
	}
	
	
	public static void main(String[] args) {
		 
		int[] nums = {3,7};
		int lengthOfNums = nums.length;
		
		MaxProdOfTwoElementsInArray obj1= new MaxProdOfTwoElementsInArray();
		obj1.maxProduct(nums, lengthOfNums);
	}

}
