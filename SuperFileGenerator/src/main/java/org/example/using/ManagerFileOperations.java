package org.example.using;

import lombok.NoArgsConstructor;
import org.example.interfaces.DocumentFileReader;

import java.util.List;

@NoArgsConstructor
public class ManagerFileOperations<T> {

    private static ManagerFileOperations<?> instance;

    public static synchronized ManagerFileOperations<?> getInstance() {
        if (instance == null) {
            instance = new ManagerFileOperations<>();
        }
        return instance;
    }

    private String getFileExtensionFromPath(String path) {
        String[] typeOfFile = path.split("\\.");
        return typeOfFile[typeOfFile.length - 1];
    }

    public void writeFile(String path, List<T> listOfObjects, Class<T> classInList) throws Exception {
        String extension = getFileExtensionFromPath(path);
        new ListsWithValues<T>().sendValues(extension, path, listOfObjects, classInList);
    }

    public void readFile(String path) throws Exception {
        String extension = getFileExtensionFromPath(path);
        DocumentFileReader documentFileReader = ProviderFileToRead.getInstance().chooseReader(extension);
        documentFileReader.readFile(path);
    }
}