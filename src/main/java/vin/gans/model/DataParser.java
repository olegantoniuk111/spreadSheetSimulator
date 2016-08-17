package vin.gans.model;

import vin.gans.data.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by DELL on 12.08.2016.
 */
public class DataParser {


    public DataParser(Map<String, String> dataForParsing) {
        parseData(dataForParsing);
    }

    private HashMap<String, ExpressionData> expressionData;
    private HashMap<String, ParsedData> simpleData;



    private void parseData(Map<String, String> allData){
        expressionData =  new LinkedHashMap<>();
        simpleData = new LinkedHashMap<>();
        Map.Entry<String, String> entry;
        Iterator<Map.Entry<String, String>> iterator= allData.entrySet().iterator();
            while(iterator.hasNext()){
                entry = iterator.next();
                String expression = entry.getValue();
                String key = entry.getKey();
                if(expression.isEmpty()|| expression.matches("^[ ]$")){
                    simpleData.put(key, new EmptyField());
                }else  if(expression.startsWith("'")){
                    simpleData.put(key, new TextData(expression.substring(1, expression.length())));
                }else if(IntData.parseInt(expression)){
                    simpleData.put(key, new IntData(expression));
                }else if(FloatData.parseFloat(expression)){
                    simpleData.put(key, new FloatData(expression));
                }else if(expression.startsWith("=")){
                    String parsedString = expression.substring(1,expression.length());
                    expressionData.put(key, new ExpressionData(parsedString));
                }
            }
    }


    public HashMap<String, ExpressionData> getExpressionData() {
        return expressionData;
    }
    public HashMap<String, ParsedData> getSimpleData() {
        return simpleData;
    }
}
