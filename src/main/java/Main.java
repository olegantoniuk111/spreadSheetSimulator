
import vin.gans.data.*;
import vin.gans.expression.ExpressionEvaluator;

import vin.gans.model.DataModel;
import vin.gans.model.DataParser;

import java.io.IOException;
import java.util.Map;

/**
 * Created by DELL on 10.08.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\intellijProjects\\expressionevaluator\\resources\\input.csv";
        DataModel model = new DataModel(filePath);
        DataParser parser = new DataParser(model.getMappedData());
        Map<String,ExpressionData> expressions = parser.getExpressionData();
        Map<String, ParsedData> simpleData = parser.getSimpleData();
        System.out.println(expressions.toString());
        System.out.println(simpleData.toString());

        String expression = "10,5/7*5+A3";
        String result = ExpressionEvaluator.separateExpression(expression);
        System.out.println(result);

        System.out.println(ExpressionEvaluator.isKey("1A"));


    }
}
