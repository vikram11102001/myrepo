package patterns.singletonpattern;

public class Account {

	private Account() {
		
	}
	
	static Account acc;
	
	public static Account getInstance() {
		if(acc == null) {
			acc = new Account();
		}
		
		return acc;
		
	}
	
	public void add(int a, int b) {
		int c = a + b;
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		
	}
}
