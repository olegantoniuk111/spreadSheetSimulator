
import vin.gans.data.*;
import vin.gans.model.DataAnalyzer;

import vin.gans.simpleDataUtil.SimpleDataFactory;
import vin.gans.model.DataModelCreator;

import java.io.IOException;
import java.util.Map;

/**
 * Created by DELL on 10.08.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\intellijProjects\\expressionevaluator\\resources\\input.csv";
        DataModelCreator model = new DataModelCreator(filePath);

        Map<String,String> expressions = DataAnalyzer.getExpressionData(model.getMappedData());
        Map<String, String> simpleData = DataAnalyzer.getSimpleData(model.getMappedData());
        Map<String, ParsedData> parsedSimpleData = SimpleDataFactory.createParsedData(simpleData);
        System.out.println(parsedSimpleData.toString());

        FloatData f = new FloatData("12.7");
        Float f1 = 12.7f;
        System.out.println( f.equals(12.7));

        IntData i = new IntData("10");
        System.out.println(i.equals(10));
    }
}
