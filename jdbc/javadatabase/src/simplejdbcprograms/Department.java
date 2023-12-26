package simplejdbcprograms;

public class Department {
	
	public void find(String ece[], String cse[]) {
		for(int i = 0; i < ece.length; i++) {
			for(int j = 0; j < cse.length; j++) {
				if(ece[i]==cse[j]) {
					System.out.println("found");
				}
			}
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String[] ece = {"Raja", "Ram", "John", "Albert"};
		String[] cse = {"Lisa", "Raja", "Ram", "Albert"};
		
		Department d1 = new Department();
		d1.find(ece, cse);
		
		
	}
}
