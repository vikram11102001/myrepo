package basicprograms;

class Accessories{

	public void brandname(){
		System.out.println("Ship");
	}
}
class Headset extends Accessories{

	public void brandname(){
		System.out.println("Boat");
	}
}
public class Inheritance{
	public static void main(String[] args){
		
		
		Accessories h2 = new Headset(); 
		h2.brandname();
		
		
		/*
		 * Headset h2 = new Accessories(); 
		 * h2.brandname();//It shows an error cannot convert accessories to headset
		 */
	}
}
