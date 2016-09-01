package vin.gans.model;





import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by DELL on 10.08.2016.
 */
public class DataModelCreatorTest {
    public DataModelCreatorTest() throws IOException {
    }
    private DataModelCreator dataModel = new DataModelCreator(TestData.filePath);
    private String[][] fileData = dataModel.getDataModel();
    private Map<String, String> mappedData = dataModel.getMappedData();
    private String[][] expressions;
    private Map<String, String> mapedExpressions;

    @BeforeClass
    public  void setUp() {
        expressions = new String[][]{{"12", "=C2", "3", "'Sample"},
                {"=A1+B1*C1/5", "=A2*B1", "=B3-C3", "'Spread"},
                {"'Test", "=4-3", "5", "'Sheet"}};
        mapedExpressions = new LinkedHashMap<>();
        mapedExpressions.put("A1", "12");
        mapedExpressions.put("B1", "=C2");
        mapedExpressions.put("C1", "3");
        mapedExpressions.put("D1", "'Sample");
        mapedExpressions.put("A2", "=A1+B1*C1/5");
        mapedExpressions.put("B2", "=A2*B1");
        mapedExpressions.put("C2", "=B3-C3");
        mapedExpressions.put("D2", "'Spread");
        mapedExpressions.put("A3", "'Test");
        mapedExpressions.put("B3", "=4-3");
        mapedExpressions.put("C3", "5");
        mapedExpressions.put("D3", "'Sheet");
    }
    @Test
    public void checkingDataFromFile() throws IOException{
        Assert.assertTrue(Arrays.deepEquals(fileData,expressions));

    }

    @Test
    public void checkDataMapping() throws IOException{
        Set<Map.Entry<String, String>> entry =  mappedData.entrySet();
        Set<Map.Entry<String, String>> entry1 =  mapedExpressions.entrySet();
        Assert.assertEquals(entry,entry1);
    }




}
