package vin.gans.model;

import vin.gans.data.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by DELL on 12.08.2016.
 */
public class DataParser {


    public DataParser(Map<String, String> dataForParsing) {
        parseData(dataForParsing);
    }
    private HashMap<String, ExpressionData> expressionData = new HashMap<>();
    private HashMap<String, ParsedData> simpleData = new HashMap<>();

    private void parseData(Map<String, String> allData){
        Map.Entry<String, String> entry;
        Iterator<Map.Entry<String, String>> iterator= allData.entrySet().iterator();
            while(iterator.hasNext()){
                entry = iterator.next();
                String expression = entry.getValue();
                if(expression.isEmpty()|| expression.matches("^[ ]$")){
                    simpleData.put(entry.getKey(), new EmptyField());
                }else  if(expression.startsWith("'")){
                    simpleData.put(entry.getKey(), new TextData(expression.substring(1, expression.length())));
                }else if(IntData.parseInt(expression)){
                    simpleData.put(entry.getKey(), new IntData(expression));
                }else if(FloatData.parseFloat(expression)){
                    simpleData.put(entry.getKey(), new FloatData(expression));
                }else if(expression.startsWith("=")){
                    String parsedString = expression.substring(1,expression.length());
                    expressionData.put(entry.getKey(),new ExpressionData(parsedString));
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
