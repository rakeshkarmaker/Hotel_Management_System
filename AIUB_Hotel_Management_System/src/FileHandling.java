import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

    static void createFile(String fileName){
        try {
            File Obj = new File(fileName);
            if (Obj.createNewFile()) {
                System.out.println("File created: "
                        + Obj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("Rakesh.txt");
        fileWriter.write("Rakesh is a good boy");
        fileWriter.close();
    }
}
