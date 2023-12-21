package basicprograms;

/*class Test  {  
	
	private String name ="Vikram";  

}  
public class PrivateExample {  
	public static void main(String[] args) {  
		
		Test obj = new Test();  
		System.out.println(obj.name);  

	}  
}*/

class Test  {  
	
	private String name ="Vikram";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	

}  
public class PrivateExample {  
	public static void main(String[] args) {  
		
		Test obj = new Test();  
		System.out.println(obj.getName());  

	}  
}  


