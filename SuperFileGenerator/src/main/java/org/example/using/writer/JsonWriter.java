package org.example.using.writer;

import org.example.interfaces.FileGenerator;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter implements FileGenerator {

    @Override
    public void generateFile(String path, String[] fieldsName, String[] fieldsValue, int sizeOfListWithObject) throws IOException {

        int indexBooster = 0;
        int counter = 0;

        try (FileWriter file = new FileWriter(path)) {

            JSONObject jsonObject = new JSONObject();

            for (int i = 0; i < sizeOfListWithObject; i++) {
                for (int j = 0; j < fieldsName.length; j++) {
                    if (i > 0 && counter == 5) {
                        indexBooster = (indexBooster + fieldsName.length);
                        counter = 0;
                    }
                    jsonObject.put(fieldsName[j], fieldsValue[j + indexBooster]);
                    counter++;
                }
                file.write(jsonObject.toJSONString());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

