package vin.gans.expressionDataUtil;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vin.gans.data.ParsedData;
import vin.gans.exception.NonExistentCellException;
import vin.gans.model.DataAnalyzer;
import vin.gans.model.Model;
import vin.gans.model.TestData;
import vin.gans.simpleDataUtil.SimpleDataFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Created by DELL on 31.08.2016.
 */
public class ExpressionEvaluatorTest {
    private  Map<String, ParsedData> parsedSimpleData;
    private  Map<String, String> expressionData;
    private ExpressionEvaluator testEvaluator;
    private Model testModel;

    @BeforeClass
    void setUp() throws IOException {
        testModel = new Model(TestData.filePath);
        parsedSimpleData = SimpleDataFactory.createParsedData(testModel.getMappedData());
        expressionData = DataAnalyzer.getExpressionData(testModel.getMappedData());
        testEvaluator = new ExpressionEvaluator(parsedSimpleData,expressionData);

    }

    @Test
    public void separateExpressionTest(){
        String expression = "A1+10*B4/17+C7";
        String result = "A1 + 10 * B4 / 17 + C7 ";
        Assert.assertEquals(ExpressionEvaluator.separateExpression(expression), result);
    }
    @Test
    public void isKeyTest() {
        String[] keys = new String[]{"A1", "AB23", "B1475", "AA59"};
        for (String str : keys) {
            Assert.assertTrue(ExpressionEvaluator.isKey(str));
        }
    }
    @Test
    public void isOperatorTest(){
            String [] operators = new String[]{"+","-","*","/"};
            for(String operator: operators){
                Assert.assertTrue(ExpressionEvaluator.isOperator(operator));
            }
        }

    @Test
    public void evaluateTest() throws NonExistentCellException {
        Assert.assertTrue(-4.0 == testEvaluator.evaluate("C2"));
        Assert.assertTrue(testEvaluator.evaluate("A1+B1*C1/5").equals(Float.valueOf("5.1")));
        Assert.assertTrue(testEvaluator.evaluate("A2*B1").equals(Float.valueOf("-20.4")));
        Assert.assertTrue(-4.0== testEvaluator.evaluate("B3-C3").intValue());
        Assert.assertTrue(testEvaluator.evaluate("4-3")==1);

    }
}
