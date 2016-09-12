package vin.gans.simpleDataUtil;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vin.gans.data.FloatData;
import vin.gans.data.IntData;
import vin.gans.data.ParsedData;
import vin.gans.data.TextData;
import vin.gans.model.DataAnalyzer;
import vin.gans.model.Model;
import vin.gans.model.TestData;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by DELL on 01.09.2016.
 */
public class SimpleDataParserTest {

    private HashMap<String , ParsedData> parsedData;
    private HashMap<String, ParsedData> parsedDataTest;
    private Model model;

    @BeforeClass
    private void setUp() throws IOException {
        model  = new Model(TestData.filePath);
        parsedDataTest = new LinkedHashMap<>();
        parsedDataTest.put("A1", new FloatData("12.5"));
        parsedDataTest.put("C1", new IntData("3"));
        parsedDataTest.put("D1", new TextData("Sample"));
        parsedDataTest.put("D2", new TextData("Spread"));
        parsedDataTest.put("A3", new TextData("Test"));
        parsedDataTest.put("C3", new IntData("5"));
        parsedDataTest.put("D3", new TextData("Sheet"));
    }

    @Test
    public void checkSimpleParsedData(){
       parsedData = SimpleDataParser.createParsedData(DataAnalyzer.getSimpleData(model.getMappedData()));
        System.out.println(parsedData.toString());
        System.out.println(parsedDataTest.toString());
        Assert.assertEquals(parsedData,parsedDataTest);
    }
}
