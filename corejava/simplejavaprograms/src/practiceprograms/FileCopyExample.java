package practiceprograms;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyExample {

    public static void main(String[] args) {
        
        Path sourcePath = Paths.get("D:\\work\\javasamples\\demo\\vikramnew.txt");
        
        Path destinationPath = Paths.get("D:\\work\\javasamples\\demo\\vikramnew_copy.txt");
        
        try {
            
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
