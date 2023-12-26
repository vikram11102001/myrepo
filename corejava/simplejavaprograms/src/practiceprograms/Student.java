package practiceprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.StringTokenizer;

public class Student {

	private String name;
	private int marks1;
	private int marks2;
	private int marks3;
	private float average;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	
	public static void main(String[] args) throws Exception {
		
		//List<Student> student = new ArrayList<Student>();
		Student s1 =new Student();

		File outputfile = new File("D:\\work\\javasamples\\demo\\output2.txt");

		FileReader reader = new FileReader("D:\\work\\javasamples\\demo\\Marks.txt");

		BufferedReader br = new BufferedReader(reader);

		FileWriter fw = new FileWriter(outputfile);

		String s = null;
		//String s1[];

		while ((s = br.readLine()) != null) 
		{
			int i=1;
			StringTokenizer st = new StringTokenizer(s, " ");
			
			  while (st.hasMoreTokens()) {
			  
			  //fw.write(st.nextToken()+" ");
				String d1 = st.nextToken();
				if(i==1) {
					s1.setName(d1);
				}
				else if(i==2){
					int d2 = Integer.parseInt(d1);
					s1.setMarks1(d2);
				}
				else if(i==3) {
					int d3 = Integer.parseInt(d1);
					s1.setMarks2(d3);
				}
				else if(i==4) {
					int d4 = Integer.parseInt(d1);
					s1.setMarks3(d4);
				}
				i++;
			  }
			 
			float average = ((float)s1.getMarks1()+(float)s1.getMarks2()+(float)s1.getMarks3())/3;
			//System.out.format("%.2f",average);
            s1.setAverage(average);
            String outputStr = s1.getName()+ " " + s1.getMarks1() + " " + s1.getMarks2() + " " + s1.getMarks3() + " " + s1.getAverage();
			fw.write(outputStr+"\n");
		}
		fw.close(); 
		

		}

		
	}