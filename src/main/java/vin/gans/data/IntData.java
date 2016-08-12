package vin.gans.data;

/**
 * Created by DELL on 12.08.2016.
 */
public class IntData implements ParsedData {
    private int data;

    public IntData(String cellData) {
        this.data = Integer.parseInt(cellData);
    }

    @Override
    public Object getData() {
        return data;
    }

    public static boolean parseInt(String string){
        return string.matches("^[0-9]+$");
    }
}
