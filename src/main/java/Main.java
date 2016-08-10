
import vin.gans.model.DataModel;

import java.io.IOException;
import java.util.Map;

/**
 * Created by DELL on 10.08.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\intellijProjects\\expressionevaluator\\resources\\input.csv";
        DataModel model = new DataModel(filePath);

        Map<String,String> allExpressions = model.getMappedData();
        for(Map.Entry<String, String> entry : allExpressions.entrySet()){

            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
