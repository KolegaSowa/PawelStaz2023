package org.example.using.extractors;

import org.example.interfaces.Extractor;
import org.example.using.writer.YamlWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YamlObjectsExtractor implements Extractor {

    @Override
    public void extract(String path, List<String> fieldsName, List<String> fieldsValue)
            throws Exception {

        int indexBooster = 0;
        int counter = 0;
        int numberOfObjectInList = fieldsValue.size()/fieldsName.size();

        Map<Integer, Object> mapToSend = new HashMap<>();

        for (int keyOfHelpMap = 0; keyOfHelpMap < numberOfObjectInList; keyOfHelpMap++) {
            Map<String, String> helpMap = new HashMap<>();
            for (int indexInArray = 0; indexInArray < fieldsName.size(); indexInArray++) {
                if (keyOfHelpMap > 0 && counter == 5) {
                    indexBooster = (indexBooster + fieldsName.size());
                    counter = 0;
                }
                helpMap.put(fieldsName.get(indexInArray), fieldsValue.get(indexInArray + indexBooster));
                counter++;
            }
            mapToSend.put(keyOfHelpMap, helpMap);
        }

        new YamlWriter().generateFile(path, mapToSend);
    }
}