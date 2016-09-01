package vin.gans.data;

import java.util.Objects;

/**
 * Created by DELL on 12.08.2016.
 */
public class FloatData implements  ParsedData, Comparable<Float> {
    private Float data;

    public FloatData(String cellData) {
        this.data = Float.parseFloat(cellData);
    }
    @Override
    public Object getValue() {
        return data;
    }
    public static boolean parseFloat(String string){
        return string.matches("^[0-9]+([,]|[.])[0-9]+$");
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Float floatData = Float.valueOf(o.toString());
        //return data == Float.valueOf(o.toString());
        return data != null ? data.equals(floatData) : floatData == null;

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public int compareTo(Float o) {
        return o.compareTo(data);
    }
}