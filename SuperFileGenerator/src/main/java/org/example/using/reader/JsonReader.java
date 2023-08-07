package org.example.using.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.interfaces.ReadFile;

import java.io.File;

public class JsonReader implements ReadFile {
    @Override
    public void readFile(String path) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);
        Object object = objectMapper.readValue(file,Object.class);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
    }
}