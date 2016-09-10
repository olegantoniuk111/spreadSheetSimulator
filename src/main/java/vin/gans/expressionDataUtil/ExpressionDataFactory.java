package vin.gans.expressionDataUtil;

import vin.gans.data.FloatData;
import vin.gans.data.IntData;
import vin.gans.data.ParsedData;
import vin.gans.data.TextData;
import vin.gans.exception.NonExistentCellException;


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
            Float evaluatedCell = null;
            try {
                evaluatedCell = evaluator.evaluate(expressions.get(key));
            } catch (NonExistentCellException e) {
                expressionData.put(key,new TextData("# can't parse" + e.getMessage()));
                continue;
                //e.printStackTrace();
            }
            if (evaluatedCell%1 == 0)
                expressionData.put(key,new IntData(String.valueOf(evaluatedCell.intValue())));
            else {
                expressionData.put(key, new FloatData(evaluatedCell.toString()));

            }
        }
        return expressionData;
    }



}
