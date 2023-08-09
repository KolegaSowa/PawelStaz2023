package org.example.using.reader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.interfaces.DocumentFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader implements DocumentFileReader {

    @Override
    public void readFile(String path) throws Exception {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonString.append(line);
            }

            JsonElement jsonElement = JsonParser.parseString(jsonString.toString());
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray fieldsArray = jsonObject.getAsJsonArray("field");

            for (JsonElement fieldElement : fieldsArray) {
                JsonObject fieldObject = fieldElement.getAsJsonObject();
                String fieldName = fieldObject.get("field name").getAsString();
                String fieldValue = fieldObject.get("field value").getAsString();
                System.out.println("field name: " + fieldName + ", field value: " + fieldValue);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}