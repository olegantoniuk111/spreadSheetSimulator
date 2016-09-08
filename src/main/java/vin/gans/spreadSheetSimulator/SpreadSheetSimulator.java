package vin.gans.spreadSheetSimulator;

import vin.gans.data.ParsedData;
import vin.gans.expressionDataUtil.ExpressionDataFactory;
import vin.gans.expressionDataUtil.ExpressionEvaluator;
import vin.gans.model.DataAnalyzer;
import vin.gans.model.Model;
import vin.gans.simpleDataUtil.SimpleDataFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by CONCHE on 08.09.2016.
 */
public class SpreadSheetSimulator {
    private  Model model;

    public Map<String, ParsedData> getEvaluatedData() {
        return evaluatedData;
    }

    private Map <String , ParsedData> evaluatedData;

    public SpreadSheetSimulator(Model model) {
        this.model = model;
        this.evaluatedData = createEvaluatedData(model);
    }

    private Map<String , ParsedData> createEvaluatedData(Model model){
        Map<String, String> simpleData = DataAnalyzer.getSimpleData(model.getMappedData());
        Map<String,String> expressions = DataAnalyzer.getExpressionData(model.getMappedData());
        Set<String> keys = model.getMappedData().keySet();
        Map<String, ParsedData> parsedSimpleData = SimpleDataFactory.createParsedData(simpleData);
        ExpressionEvaluator evaluator = new ExpressionEvaluator(parsedSimpleData,expressions);
        Map<String,ParsedData> parsedExpressionData = ExpressionDataFactory.parseExpressions(expressions,evaluator);

         evaluatedData = new LinkedHashMap<>();
        for(String key : keys){
            if (parsedSimpleData.containsKey(key)){
                evaluatedData.put(key,parsedSimpleData.get(key));
            }else {
                evaluatedData.put(key,parsedExpressionData.get(key));
            }
        }
        return evaluatedData;
    }

    public void printEvaluatedData(){
        String[][] array = model.getCoordinates();
        for(int i=0; i<array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+"="+evaluatedData.get(array[i][j]));
                System.out.print("||-||-||");
            }
            System.out.println();
        }
    }
}
