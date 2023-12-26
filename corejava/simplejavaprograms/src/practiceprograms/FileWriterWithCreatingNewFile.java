package practiceprograms;
import java.io.FileWriter;
import java.io.IOException;
class FileWriterWithCreatingNewFile
{
	public static void main(String[] args) throws IOException
	{
		String str = "Good Morning" + "Have a nice day";
		FileWriter fw=new FileWriter("D:\\work\\javasamples\\demo\\vikramwriter.txt");
		for (int i = 0; i < str.length(); i++)
			fw.write(str.charAt(i));
		System.out.println("Writing successful");
		fw.close();
	}
}
