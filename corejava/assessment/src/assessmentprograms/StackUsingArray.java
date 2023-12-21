package assessmentprograms;
class StackOperations{
	int i = 0;
	int length = 4;
	int[] arr;
	public void add(int n) {
		if(i < length) {
			if(arr[i] == null) {
				arr[i] = n;
			}else {
				arr[i + 1] = n;
			}
			i++;
		}
		/*for(int i = 0; i < length; i++) {
			if(arr[i] == null) {
				arr[i] = n;
			}else {
				arr[i + 1] = n;
			}
		}*/
		
		
	}
	public void remove() {
		int j = length - 1;
		if(j >= 0) {
			arr[j] == null;
		}
		j--;
	}
	public void print() {
		for(i = 0; i < length; i++) {
			System.out.println(arr[i]);
		}
	}
}


public class StackUsingArray {
	public static void main(String[] args) {
		StackOperations so = new StackOperations();
		so.add(1);
		so.add(2);
		so.add(3);
		so.add(4);
		so.print();
		so.remove();
		so.print();
		
		
	}

}
