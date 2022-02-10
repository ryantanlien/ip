package butler.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import butler.TaskList;
import butler.task.Task;

public class Storage {

    /** Default path for storage file. */
    private static final String DEFAULT_PATH_NAME = "src/main/resources/list.txt";
    /** Actual path for storage file. */
    private String pathName;

    /**
     * Constructs a Storage object and intialises actual path to given path.
     * If no path is given, actual path is default path.
     *
     * @param pathName Given path.
     */
    public Storage(String pathName) {
        assert pathName != null;
        if (pathName.equals("")) {
            this.pathName = DEFAULT_PATH_NAME;
        } else {
            this.pathName = pathName;
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
        assert file != null;
        return file;
    }

    private File getFileObject() {
        File file = createFile(this.pathName);
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

    /**
     * Writes contents of taskList to the file at actual path.
     *
     * @param tasks A managed list of tasks.
     */
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
