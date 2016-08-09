package vin.gans.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by DELL on 10.08.2016.
 */
public class DataModelTest {
    public DataModelTest() throws IOException {
    }
    private static String[][] array = new String[][] {{"12","=C2", "3", "'Sample"},
                                {"=A1+B1*C1/5", "=A2*B1", "=B3-C3", "'Spread"},
                                {"'Test", "=4-3", "5", "'Sheet"}};


    private String filePath = "D:\\intellijProjects\\expressionevaluator\\resources\\testResources\\testinput.csv";
    private  String[][] fileData = DataModel.buildDataModel(filePath);




    @Test
    public void checkingDataFromFile() throws IOException {
         Assert.assertTrue(Arrays.deepEquals(fileData,array));
    }

}
