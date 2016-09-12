package vin.gans.simpleDataUtil;

import vin.gans.data.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by DELL on 01.09.2016.
 */
public class SimpleDataParser {

    private static HashMap<String, ParsedData> parsedData;

    public static HashMap<String, ParsedData> createParsedData(Map<String, String> simpleData) {
        parsedData = new LinkedHashMap<>();
        Map.Entry<String, String> entry;
        Iterator<Map.Entry<String, String>> iterator = simpleData.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = iterator.next();
            String expression = entry.getValue();
            String key = entry.getKey();
            if (expression.isEmpty() || expression.matches("^[ ]$")) {
                parsedData.put(key, new EmptyField());
            } else if (expression.startsWith("'")) {
                parsedData.put(key, new TextData(expression.substring(1, expression.length())));
            }else if (FloatData.parseFloat(expression)) {
                parsedData.put(key, new FloatData(expression));
            } else if (IntData.parseInt(expression)) {
                parsedData.put(key, new IntData(expression));
            }
        }
        return parsedData;
    }
}