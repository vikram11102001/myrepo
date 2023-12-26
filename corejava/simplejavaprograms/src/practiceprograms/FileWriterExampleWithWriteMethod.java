package practiceprograms;
// Import the FileWriter class
import java.io.FileWriter;

// Import the IOException class for handling errors
import java.io.IOException;

public class FileWriterExampleWithWriteMethod{
	public static void main(String[] args)
	{
		try {
			FileWriter Writer
				= new FileWriter("D:\\work\\javasamples\\demo\\vikramnew.txt");
			Writer.write(
				"Good MOrning:)");
			Writer.close();
			System.out.println("Successfully written.");
		}
		catch (IOException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
}
