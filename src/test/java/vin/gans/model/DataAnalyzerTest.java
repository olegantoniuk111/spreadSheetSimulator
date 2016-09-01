package vin.gans.model;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vin.gans.data.ExpressionData;
import vin.gans.data.IntData;
import vin.gans.data.ParsedData;
import vin.gans.data.TextData;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by DELL on 01.09.2016.
 */
public class DataAnalyzerTest {
    public DataAnalyzerTest() throws IOException {
    }

    private DataModelCreator model = new DataModelCreator(TestData.filePath);
    private HashMap<String, String> simpleData;
    private HashMap<String, String> expressionsData;

    private LinkedHashMap<String, String> expressionsDataTest;

    private LinkedHashMap<String, String> simpleDataTest;


    @BeforeClass
    public void setUp() throws IOException {
        simpleData = DataAnalyzer.getSimpleData(model.getMappedData());
        expressionsData = DataAnalyzer.getExpressionData(model.getMappedData());

        simpleDataTest = new LinkedHashMap<>();
        simpleDataTest.put("A1", "12");
        simpleDataTest.put("C1", "3");
        simpleDataTest.put("D1", "'Sample");
        simpleDataTest.put("D2", "'Spread");
        simpleDataTest.put("A3", "'Test");
        simpleDataTest.put("C3", "5");
        simpleDataTest.put("D3", "'Sheet");

        expressionsDataTest = new LinkedHashMap<>();
        expressionsDataTest.put("B1", "C2");
        expressionsDataTest.put("A2", "A1+B1*C1/5");
        expressionsDataTest.put("B2", "A2*B1");
        expressionsDataTest.put("C2", "B3-C3");
        expressionsDataTest.put("B3", "4-3");

    }
    @Test
    public void testSimpleData() {
        org.testng.Assert.assertEquals(simpleData.keySet(), simpleDataTest.keySet());
        org.testng.Assert.assertEquals(simpleData.values(), simpleDataTest.values());
        Set<String> keySet = simpleData.keySet();

        for (String key : keySet) {
            org.testng.Assert.assertEquals(simpleData.get(key), simpleDataTest.get(key));
        }
    }

    @Test
    public void testExpressions(){
        Assert.assertEquals(expressionsData.keySet(), expressionsDataTest.keySet());
        Set<String> keySet = expressionsData.keySet();
        for(String key : keySet){
            Assert.assertEquals(expressionsData.get(key),expressionsDataTest.get(key) );
        }
    }

}


