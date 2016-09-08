
import vin.gans.data.*;
import vin.gans.exception.DataParseException;
import vin.gans.expressionDataUtil.ExpressionDataFactory;
import vin.gans.expressionDataUtil.ExpressionEvaluator;
import vin.gans.model.DataAnalyzer;

import vin.gans.simpleDataUtil.SimpleDataFactory;
import vin.gans.model.Model;
import vin.gans.spreadSheetSimulator.SpreadSheetSimulator;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by DELL on 10.08.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException, DataParseException {
        String filePath = "resources\\input.csv";
       // String filePath = "resources\\testResources\\testinput.csv";
        Model model = new Model(filePath);
        SpreadSheetSimulator simulator = new SpreadSheetSimulator(model);
        simulator.printEvaluatedData();
    }
}
