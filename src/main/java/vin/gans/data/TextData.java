package vin.gans.data;

import java.util.Objects;

/**
 * Created by DELL on 12.08.2016.
 */
public class TextData implements ParsedData{
    @Override
    public String toString() {
        return text.toString();
    }

    private String text;


    public TextData(String text) {
        this.text = text;
    }

    @Override
    public String getValue() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

  //      TextData textData = (TextData) o;

        return text != null ? text.equals(o.toString()) : o.toString() == null;

    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }
}
