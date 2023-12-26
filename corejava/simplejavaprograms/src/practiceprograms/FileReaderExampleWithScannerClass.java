package practiceprograms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class FileReaderExampleWithScannerClass {
    public static void main(String[] args)
    {
        try {
            File Obj = new File("D:\\work\\javasamples\\demo\\vikramnew.txt");
            Scanner reader = new Scanner(Obj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}