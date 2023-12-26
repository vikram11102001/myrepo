package servletsamples;

public class SignUp {
	
	
	
	public void doSignUp(String travellerid, String firstname, String lastname, String password) {
		String travellerID = travellerid;
		String firstName = firstname;
		String lastName = lastname;
		String passWord = password;
		
		SignUpDao dao = new SignUpDao();
		dao.saveSignUp(travellerID, firstName, lastName, passWord);
		
	}
	public static void main(String[] args) {
		
		
			
			
			
			
    }
		

	

}
