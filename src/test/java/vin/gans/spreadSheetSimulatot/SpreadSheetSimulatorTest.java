package vin.gans.spreadSheetSimulatot;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vin.gans.data.FloatData;
import vin.gans.data.IntData;
import vin.gans.data.ParsedData;
import vin.gans.data.TextData;
import vin.gans.model.Model;
        import vin.gans.model.TestData;
        import vin.gans.spreadSheetSimulator.SpreadSheetSimulator;

        import java.io.IOException;
        import java.util.LinkedHashMap;
        import java.util.Map;

/**
 * Created by CONCHE on 08.09.2016.
 */
        public class SpreadSheetSimulatorTest {
            private Map<String, ParsedData> evaluatedTestData;
            private Model model;
            private SpreadSheetSimulator testSimulator;

            @BeforeClass
            public void setUp() throws IOException {
                model = new Model(TestData.filePath);
                testSimulator = new SpreadSheetSimulator(model);

                evaluatedTestData = new LinkedHashMap<>();
                evaluatedTestData.put("A1",new FloatData("12.5"));
                evaluatedTestData.put("B1",new IntData("-4"));
                evaluatedTestData.put("C1",new IntData("3"));
                evaluatedTestData.put("D1",new TextData("Sample"));

                evaluatedTestData.put("A2",new FloatData("5.1"));
                evaluatedTestData.put("B2",new FloatData("-20.4"));
                evaluatedTestData.put("C2",new IntData("-4"));
                evaluatedTestData.put("D2",new TextData("Spread"));

                evaluatedTestData.put("A3",new TextData("Test"));
                evaluatedTestData.put("B3",new IntData("1"));
                evaluatedTestData.put("C3",new IntData("5"));
                evaluatedTestData.put("D3",new TextData("Sheet"));


    }
    @Test
    public void checkingAllEvaluatedData(){
        Assert.assertEquals(evaluatedTestData, testSimulator.getEvaluatedData());
    }

}
