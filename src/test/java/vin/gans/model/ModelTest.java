package vin.gans.model;





import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by DELL on 10.08.2016.
 */
public class ModelTest {

    private Model model;
    private String[][] fileData;
    private Map<String, String> mappedData;
    private String[][] expressions;
    private Map<String, String> mapedExpressions;

    @BeforeClass
    public  void setUp() throws IOException {
        model = new Model(TestData.filePath);
        fileData = model.getData();
        mappedData = model.getMappedData();
        expressions = new String[][]{{"12.5", "=C2", "3", "'Sample"},
                {"=A1+B1*C1/5", "=A2*B1", "=B3-C3", "'Spread"},
                {"'Test", "=4-3", "5", "'Sheet"}};
        mapedExpressions = new LinkedHashMap<>();
        mapedExpressions.put("A1", "12.5");
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
        for(int i=0;i<fileData.length;i++){
            for (int j=0;j<fileData[i].length;j++){
                Assert.assertEquals(fileData[i][j].toString(), expressions[i][j].toString());
            }
        }
    }
    @Test
    public void checkMappedDataFromFile() throws IOException{
        Set<Map.Entry<String, String>> entry =  mappedData.entrySet();
        Set<Map.Entry<String, String>> entry1 =  mapedExpressions.entrySet();
        Assert.assertEquals(entry,entry1);
    }
}
