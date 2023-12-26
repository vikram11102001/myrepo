package practiceprograms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExample{
    public static void main (String[] args)throws IOException {
        String filePath = "D:\\work\\javasamples\\demo\\Marks.txt";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line); // Process the line as needed
        }
    }
}