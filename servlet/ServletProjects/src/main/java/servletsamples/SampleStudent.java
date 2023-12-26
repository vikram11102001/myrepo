package servletsamples;

public class SampleStudent {
	private String studentname1;
	private String studentname2;
	private String studentname3;
	public static String collegeName; 

	public String getStudentname1() {
		return studentname1;
	}

	public void setStudentname1(String studentname1) {
		this.studentname1 = studentname1;
	}

	public String getStudentname2() {
		return studentname2;
	}

	public void setStudentname2(String studentname2) {
		this.studentname2 = studentname2;
	}

	public String getStudentname3() {
		return studentname3;
	}

	public void setStudentname3(String studentname3) {
		this.studentname3 = studentname3;
	}


	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SampleStudent obj =new SampleStudent();
		obj.setStudentname1("Vikram");
		obj.setStudentname2("Vijay");
		obj.setStudentname3("Vijay Sethupathi");
		System.out.println(obj.getStudentname1());
		
		
	}

}
