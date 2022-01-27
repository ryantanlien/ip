package butler.util;

import butler.TaskList;
import butler.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    private final static String DEFAULT_PATH_NAME = "src/main/resources/list.txt";
    private String PATH_NAME;

    public Storage(String pathName) {
        if (pathName.equals("")) {
            PATH_NAME = DEFAULT_PATH_NAME;
        } else {
            PATH_NAME = pathName;
        }
    }

    private File createFile(String pathName) {
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

    private File getFileObject() {
        File file = createFile(PATH_NAME);
        return file;
    }

    private void writeToFile(File file, String string) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(string);
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void writeTaskListToFile(TaskList tasks) {
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
