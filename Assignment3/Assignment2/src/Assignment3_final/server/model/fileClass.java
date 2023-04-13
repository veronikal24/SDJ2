
package Assignment3_final.server.model;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class fileClass {
    // This class is Singleton
    private static fileClass fileClass = null;
    File myObj = null;
    String path = "C:\\Users\\veron\\OneDrive\\Plocha\\5th Semester\\SDJ2\\Assignemnt3\\sample.txt";

    private fileClass() {
        {
            if (myObj == null) {
                try {
                    File myObj = new File(path);
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }

        }
    }
    public static fileClass getFileClassInstance(){
        if (fileClass== null)
            fileClass = new fileClass();

        return fileClass;
    }

public void addText(String text){
    try {
        BufferedWriter myWriter = new BufferedWriter(new FileWriter(path, true));
        myWriter.append('\n');
        myWriter.append(text);
        System.out.println("I am writing this" + text);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }


}
}
