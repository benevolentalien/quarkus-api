package dev.monx.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringEscapeUtils;

public class GqlTestHelpers {

    public static String loadQueryAsJson(String resource) throws IOException {
        Path path = Paths.get("src/test/resources/" + resource);
        String allLines = Files.readAllLines(path).stream().collect(Collectors.joining("\n"));
        var quotedQuery = StringEscapeUtils.escapeJson(allLines);
        var json = "{ \"query\": \"" + quotedQuery + "\"}";
        return json;
    }
}
