
import vin.gans.data.ExpressionData;
import vin.gans.data.ParsedData;
import vin.gans.model.DataModel;
import vin.gans.model.DataParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 10.08.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\intellijProjects\\expressionevaluator\\resources\\input.csv";
        DataModel model = new DataModel(filePath);

       Map<String,String> allExpressions = model.getMappedData();
//        for(Map.Entry<String, String> entry : allExpressions.entrySet()){
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }
        DataParser parser = new DataParser( allExpressions);

        Map<String , ParsedData> simple = parser.getSimpleData();
        for(Map.Entry<String, ParsedData> simpleEntry : simple.entrySet()){
            System.out.println(simpleEntry.getKey() + " - " + (simpleEntry.getValue().getData()));
        }

        Map<String, ExpressionData> expressions = parser.getExpressionData();
        for(Map.Entry<String, ExpressionData> expessionsEntry :expressions.entrySet() ){
            System.out.println(expessionsEntry.getKey() + "- "+expessionsEntry.getValue().getData());
        }
    }
}
