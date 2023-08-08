package org.example.using;

import java.util.List;

public class ManagerFileOperations<T> {

    private static ManagerFileOperations<?> instance;

    ManagerFileOperations() {}

    public static synchronized ManagerFileOperations<?> getInstance() {
        if (instance == null) {
            instance = new ManagerFileOperations<>();
        }
        return instance;
    }

    private String splitPath(String path) {
        String[] typeOfFile = path.split("\\.");
        String extended = typeOfFile[typeOfFile.length - 1];
        return extended;
    }

    public void writeFile(String path, List<T> listOfObjects, Class<T> classInList) throws Exception {
        String extended = splitPath(path);
        new BreakListToValues<T>().sendToOtherClass(extended, path, listOfObjects, classInList);
    }

    public void readFile(String path) throws Exception {
        String extended = splitPath(path);
        ChooserFileToRead.getInstance().chooseReader(extended, path);
    }
}
