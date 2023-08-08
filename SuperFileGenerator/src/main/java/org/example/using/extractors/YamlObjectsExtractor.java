package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.YamlWriter;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class YamlObjectsExtractor<T> implements Extractor {

    @Override
    public void extractor(String path, Field[] allFieldsInStructure, String[] fieldsName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject) throws Exception {

        int indexBooster = 0;
        int counter = 0;

        Map<Integer, Object> mapToSend = new HashMap<>();

        for (int i = 0; i < sizeOfListWithObject; i++) {
            Map<String, String> helpMap = new HashMap<>();
            for (int j = 0; j < fieldsName.length; j++) {
                if (i > 0 && counter == 5) {
                    indexBooster = (indexBooster + fieldsName.length);
                    counter = 0;
                }
                helpMap.put(fieldsName[j], fieldsValue[j + indexBooster]);
                counter++;
            }
            mapToSend.put(i, helpMap);
        }

        sendToFileGenerator(path, mapToSend);
    }

    private void sendToFileGenerator(String path, Map<Integer, Object> mapToSend) throws FileNotFoundException {
        new YamlWriter().generateFile(path, mapToSend);
    }
}
