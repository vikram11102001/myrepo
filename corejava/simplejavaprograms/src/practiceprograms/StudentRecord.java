package practiceprograms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentRecord
{
    public static void main(String[] args) throws IOException
    {
        // declare and initialize the variables
        double test1, test2, test3;
        double average;
        String name;
        FileReader fr = new FileReader("D:\\work\\javasamples\\demo\\Marks.txt");
        Scanner inFile = new Scanner(fr);
		File myobj = new File("D:\\work\\javasamples\\demo\\Marks1.txt");
		myobj.createNewFile();
        
        PrintWriter outFile = new PrintWriter("Marks1.txt");
        
        // Read till end of file
        while (inFile.hasNextLine())
        {
           name = inFile.next();
           outFile.println("Student Name: " + name);
                                                                                
           test1 = inFile.nextDouble();
           test2 = inFile.nextDouble();
           test3 = inFile.nextDouble();

           outFile.println();
           average = (test1 + test2 + test3) / 3;
           outFile.println(average);
           outFile.println();
        }

        inFile.close();
        outFile.close();
         
    }
}