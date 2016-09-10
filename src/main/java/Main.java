
import vin.gans.exception.NonExistentCellException;
import vin.gans.model.Model;
import vin.gans.spreadSheetSimulator.SpreadSheetSimulator;
import java.io.IOException;

/**
 * Created by DELL on 10.08.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException, NonExistentCellException {

        String filePath = "resources\\input.csv";
        //String filePath = "resources\\testResources\\testinput.csv";
        Model model = new Model(filePath);
        SpreadSheetSimulator simulator = new SpreadSheetSimulator(model);
        simulator.printEvaluatedData();
    }
}
