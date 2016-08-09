import vin.gans.model.DataModel;

import java.io.IOException;

/**
 * Created by DELL on 10.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        String filePath = "D:\\intellijProjects\\expressionevaluator\\resources\\input.csv";
        try {
            String[][] data = DataModel.buildDataModel(filePath);
            System.out.println(data[0][0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
