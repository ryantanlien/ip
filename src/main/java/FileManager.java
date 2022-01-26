import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

//    final static String FILE_NAME = "list.txt";
    final static String PATH_NAME = "src/main/resources/list.txt";

    private static File createFile(String pathName) {
        File file = new File(pathName);
        try {
            if (file.createNewFile()) {
                return file;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return file;
    }

    private static File getFileObject() {
        File file = createFile(PATH_NAME);
        return file;
    }

    private static void writeToFile(File file, String string) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void writeTaskListToFile(ArrayList<Task> tasks) {
        writeToFile(getFileObject(), "hello");
    }
}
