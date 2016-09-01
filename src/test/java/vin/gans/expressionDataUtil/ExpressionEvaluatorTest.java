package vin.gans.expressionDataUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by DELL on 31.08.2016.
 */
public class ExpressionEvaluatorTest {

    @Test
    public void separateExpressionTest(){
        String expression = "A1+10*B4/17+C7";
        String result = "A1 + 10 * B4 / 17 + C7 ";
        Assert.assertEquals(ExpressionEvaluator.separateExpression(expression), result);
    }
    @Test
    public void isKeyTest(){
        String [] keys = new String[] {"A1", "AB23", "B1475","AA59"};
        for (String str : keys){
            Assert.assertTrue(ExpressionEvaluator.isKey(str));
        }
    }
}
