package vin.gans.data;

import java.util.Objects;

/**
 * Created by DELL on 12.08.2016.
 */
public class IntData implements ParsedData{
    private int data;


    public IntData(String cellData) {
        this.data = Integer.parseInt(cellData);
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
       // IntData intData = (IntData) o;
        return data == Integer.valueOf(o.toString());

    }

    @Override
    public int hashCode() {
        return data;
    }

    @Override
    public Integer getValue() {
        return data;
    }

    public static boolean parseInt(String string){
        return string.matches("^[0-9]+$");
    }

}
