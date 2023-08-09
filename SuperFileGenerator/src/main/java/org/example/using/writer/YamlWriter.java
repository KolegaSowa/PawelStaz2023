package org.example.using.writer;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class YamlWriter {

    public void generateFile(String path, Map<Integer, Object> mapToWrite) throws FileNotFoundException {

        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setPrettyFlow(true);

        PrintWriter writer = new PrintWriter(path);
        Yaml yaml = new Yaml(dumperOptions);
        yaml.dump(mapToWrite, writer);
    }
}