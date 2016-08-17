package vin.gans.data;

/**
 * Created by DELL on 12.08.2016.
 */
public class EmptyField implements ParsedData {

    public EmptyField() {
    }

    @Override
    public Object getValue() {
        return "";
    }



}
