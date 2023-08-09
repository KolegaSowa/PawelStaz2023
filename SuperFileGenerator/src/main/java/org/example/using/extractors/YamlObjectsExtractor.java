package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.YamlWriter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class YamlObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, Field[] allFieldsInStructure, String[] fieldsName, String[] fieldsValue, int lengthFieldsValue, int sizeOfListWithObject)
            throws Exception {

        int indexBooster = 0;
        int counter = 0;

        Map<Integer, Object> mapToSend = new HashMap<>();

        for (int keyOfHelpMap = 0; keyOfHelpMap < sizeOfListWithObject; keyOfHelpMap++) {
            Map<String, String> helpMap = new HashMap<>();
            for (int indexInArray = 0; indexInArray < fieldsName.length; indexInArray++) {
                if (keyOfHelpMap > 0 && counter == 5) {
                    indexBooster = (indexBooster + fieldsName.length);
                    counter = 0;
                }
                helpMap.put(fieldsName[indexInArray], fieldsValue[indexInArray + indexBooster]);
                counter++;
            }
            mapToSend.put(keyOfHelpMap, helpMap);
        }

        new YamlWriter().generateFile(path, mapToSend);
    }
}