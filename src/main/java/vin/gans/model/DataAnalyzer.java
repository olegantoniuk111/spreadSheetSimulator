package vin.gans.model;

import vin.gans.data.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by DELL on 01.09.2016.
 */
public class DataAnalyzer {
    private static HashMap<String, String> expressionData;
    private static HashMap<String, String> simpleData;

    public static HashMap<String, String> getSimpleData(Map<String, String> allData) {
        simpleData = new LinkedHashMap<>();
        Map.Entry<String, String> entry;
        Iterator<Map.Entry<String, String>> iterator = allData.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = iterator.next();
            String key = entry.getKey();
            String expression = entry.getValue();
            if (expression.startsWith("=")) {
                continue;
            } else simpleData.put(key, expression);
        }
        return simpleData;
    }

    public static HashMap<String, String> getExpressionData(Map<String, String> allData){
        expressionData  = new LinkedHashMap<>();
        Map.Entry<String, String> entry;
        Iterator<Map.Entry<String, String>> iterator = allData.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = iterator.next();
            String key = entry.getKey();
            String expression = entry.getValue();
            if (expression.startsWith("=")) {
                String parsedString = expression.substring(1,expression.length());
                expressionData.put(key, parsedString);
            } else continue;
        }
        return expressionData;
    }
}
