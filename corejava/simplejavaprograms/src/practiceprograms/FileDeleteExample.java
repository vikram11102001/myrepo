package practiceprograms;
// Import the File class
import java.io.File;

public class FileDeleteExample{
	public static void main(String[] args)
	{
		File Obj = new File("D:\\work\\javasamples\\demo\\vikram.txt");
		Obj.delete();
	}
}
