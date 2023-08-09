package org.example.using.reader;

import org.example.interfaces.DocumentFileReader;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YamlReader implements DocumentFileReader {

    @Override
    public void readFile(String path) throws Exception {
        InputStream inputStream = new FileInputStream(path);

        Yaml yaml = new Yaml();
        Map<Integer, Object> data = yaml.load(inputStream);
        System.out.println(data);
    }
}
