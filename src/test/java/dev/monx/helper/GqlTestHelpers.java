package dev.monx.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.text.StringEscapeUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GqlTestHelpers {

    public static String loadQueryAsJson(String resource, Map<String, Object> variables) throws IOException {
        Path path = Paths.get("src/test/resources/graphql/" + resource);
        var objectMapper = new ObjectMapper();
        String allLines = Files.readAllLines(path).stream().collect(Collectors.joining("\n"));
        var quotedQuery = StringEscapeUtils.escapeJson(allLines);
        var quotedVariables = objectMapper.writeValueAsString(variables);
        var json = "{ \"query\": \"" + quotedQuery + "\", \"variables\": " + quotedVariables + " }";
        return json;
    }

    public static String loadQueryAsJson(String resource) throws IOException {
        Path path = Paths.get("src/test/resources/graphql/" + resource);
        String allLines = Files.readAllLines(path).stream().collect(Collectors.joining("\n"));
        var quotedQuery = StringEscapeUtils.escapeJson(allLines);
        var json = "{ \"query\": \"" + quotedQuery + "\"}";
        return json;
    }
}
