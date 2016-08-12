package vin.gans.data;

/**
 * Created by DELL on 12.08.2016.
 */
public class FloatData implements  ParsedData {
    private Float data;

    public FloatData(String cellData) {
        this.data = Float.parseFloat(cellData);
    }


    @Override
    public Object getData() {
        return data;
    }

    public static boolean parseFloat(String string){
        return string.matches("^[0-9]+$");
    }
}
