package org.example.using.writer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.interfaces.FileGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter implements FileGenerator {

    @Override
    public void generateFile(String path, List<String> fieldsName, List<String> fieldsValue) throws IOException {

        JsonObject jsonObject = new JsonObject();
        JsonArray fieldsArray = new JsonArray();

        for (int i = 0; i < fieldsName.size(); i++) {
            JsonObject fieldObject = new JsonObject();
            fieldObject.addProperty("field name", fieldsName.get(i));
            fieldObject.addProperty("field value", fieldsValue.get(i));
            fieldsArray.add(fieldObject);
        }

        jsonObject.add("field", fieldsArray);

        String jsonOutput = new Gson().toJson(jsonObject);

        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}