package vin.gans.model;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import vin.gans.data.ExpressionData;
import vin.gans.data.IntData;
import vin.gans.data.ParsedData;
import vin.gans.data.TextData;

import java.io.IOException;
import java.util.*;

/**
 * Created by DELL on 13.08.2016.
 */
public class DataParseTest {
    public DataParseTest() throws IOException {
    }

    private DataModel model;
    private DataParser dataParser;
    private HashMap<String, ExpressionData> expressionData;
    private HashMap<String, ParsedData> simpleData;

    private LinkedHashMap<String, Object> expressionsDataTest;
    private LinkedHashMap<String, ParsedData> simpleDataTest;
    private LinkedHashMap<String, Object> simpleDataTest2;


    @Before
    public void setUp() throws IOException {
        model = new DataModel(TestData.filePath);
        dataParser = new DataParser(model.getMappedData());
        simpleDataTest = new LinkedHashMap<>();

        simpleData = dataParser.getSimpleData();
        simpleDataTest.put("A1", new IntData("12"));
        simpleDataTest.put("C1", new IntData("3"));
        simpleDataTest.put("D1", new TextData("Sample"));
        simpleDataTest.put("D2", new TextData("Spread"));
        simpleDataTest.put("A3", new TextData("Test"));
        simpleDataTest.put("C3", new IntData("5"));
        simpleDataTest.put("D3", new TextData("Sheet"));

        expressionsDataTest = new LinkedHashMap<>();
        expressionsDataTest.put("B1", "C2");
        expressionsDataTest.put("A2", "A1+B1*C1/5");
        expressionsDataTest.put("B2", "A2*B1");
        expressionsDataTest.put("C2", "B3-C3");
        expressionsDataTest.put("B3", "4-3");

        simpleDataTest2 = new LinkedHashMap<>();
        simpleDataTest2.put("A1", 12);
        simpleDataTest2.put("C1", 3);
        simpleDataTest2.put("D1", "Sample");
        simpleDataTest2.put("D2", "Spread");
        simpleDataTest2.put("A3", "Test");
        simpleDataTest2.put("C3", 5);
        simpleDataTest2.put("D3", "Sheet");
    }

    @Test
    public void testSimpleData() {
        org.testng.Assert.assertEquals(simpleData.keySet(), simpleDataTest.keySet());
        org.testng.Assert.assertEquals(simpleData.values(), simpleDataTest.values());
        Set<String> keySet = simpleData.keySet();
        for (String key : keySet) {
            org.testng.Assert.assertEquals(simpleData.get(key).getValue(), (simpleDataTest2.get(key)));
        }
    }

    @Test
    public void testExpressions() {
        expressionData = new LinkedHashMap<String, ExpressionData>(dataParser.getExpressionData());
        Set<String> keySet = expressionData.keySet();
        Set<String> testKeySet = expressionsDataTest.keySet();
        Assert.assertEquals(keySet,testKeySet);
        for (String key : keySet){
            Assert.assertEquals(expressionData.get(key).getValue(), expressionsDataTest.get(key));
        }


        //System.out.print(expressionData.toString());
    }
}

