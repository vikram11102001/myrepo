package assessmentprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) {
        String inputFilePath = "D:\\work\\javasamples\\demo\\Marks.txt";
        String outputFilePath = "D:\\work\\javasamples\\demo\\average.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                String studentName = parts[0];
                int totalMarks = 0;
                int subjectCount = 0;
                for (int i = 1; i < parts.length; i++) {
                    int marks = Integer.parseInt(parts[i]);
                    totalMarks += marks;
                    subjectCount++;
                }
                double average = (double) totalMarks / subjectCount;
                bufferedWriter.write(studentName + ": " + average);
                bufferedWriter.newLine();
                
            }
        }catch(IOException e) {
        	e.printStackTrace();
        }        
                
    }            
}