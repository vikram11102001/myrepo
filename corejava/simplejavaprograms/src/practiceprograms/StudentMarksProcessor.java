package practiceprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class StudentMarksProcessor {
    public static void main(String[] args)throws IOException {
        String inputFileName = ("Marks.txt");
		File myobj = new File("D:\\work\\javasamples\\demo\\Markswithaverage.txt");
		myobj.createNewFile();
        String outputFileName =("Markswithaverage.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            int totalMarks = 0;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                int marks = Integer.parseInt(line);
                totalMarks += marks;
                count++;
            }

            if (count > 0) {
                double average = (double) totalMarks / count;
                writer.write("Average marks: " + average);
                System.out.println("Average marks: " + average);
            } else {
                writer.write("No marks found.");
                System.out.println("No marks found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
        }
    }
}
