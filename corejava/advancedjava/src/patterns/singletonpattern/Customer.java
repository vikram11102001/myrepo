package patterns.singletonpattern;

public class Customer {

	
	
	
	
	public static void main(String[] args) {
		
		Account acc = Account.getInstance();
		acc.add(4,5);
		
	}
}
