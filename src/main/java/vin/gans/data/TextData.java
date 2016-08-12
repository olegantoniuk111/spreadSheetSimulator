package vin.gans.data;

/**
 * Created by DELL on 12.08.2016.
 */
public class TextData implements ParsedData {
    private String text;

    public TextData(String text) {
        this.text = text;
    }

    @Override
    public String getData() {
        return text;
    }
}
