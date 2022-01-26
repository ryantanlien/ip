import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    final static String PATH_NAME = "src/main/resources/list.txt";

    private static File createFile(String pathName) {
        File folder = new File("src/main/resources");
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
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
        int i = 0;
        StringBuilder fileOutput = new StringBuilder();
        while (i < tasks.size()) {
            Task task = tasks.get(i);
            fileOutput.append(String.valueOf(i + 1)).append(". ").append(task.toString()).append("\n");
            i++;
        }
        writeToFile(getFileObject(), fileOutput.toString());
    }
}
