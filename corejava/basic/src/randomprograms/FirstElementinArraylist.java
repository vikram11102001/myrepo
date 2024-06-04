package randomprograms;

import java.util.ArrayList;

public class  FirstElementinArraylist{
    public static void main(String[] args) {
        
        ArrayList<String> students = new ArrayList<>();
        students.add("Student 1");
        students.add("Student 2");
        students.add("Student 3");
        students.add("Student 4");
        
        if (!students.isEmpty()) {
            
            String firstStudent = students.get(0);
            
            if(firstStudent!=null) {
            	System.out.println("The first student is: " + firstStudent);
            }else {
            	System.out.println("There is no first element");
            }
            
        } else {
            System.out.println("The student list is empty.");
        }
    }
}
