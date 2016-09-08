package vin.gans.expressionDataUtil;

import vin.gans.data.ExpressionData;
import vin.gans.data.FloatData;
import vin.gans.data.IntData;
import vin.gans.data.ParsedData;
import vin.gans.exception.DataParseException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by DELL on 01.09.2016.
 */
public class ExpressionDataFactory {
    private static HashMap<String, ParsedData> expressionData;

    public static Map<String, ParsedData> parseExpressions(Map<String,String> expressions,ExpressionEvaluator evaluator){
        expressionData = new LinkedHashMap<>();
        Set<String> keys = expressions.keySet();
        for(String key :keys){
            Float evaluatedCell = evaluator.evaluate(expressions.get(key));
            if (evaluatedCell%1 > 0)
            expressionData.put(key, new FloatData(evaluatedCell.toString()));
            else {
                expressionData.put(key,new IntData(String.valueOf(evaluatedCell.intValue())));
            }
        }
        return expressionData;
    }



}
