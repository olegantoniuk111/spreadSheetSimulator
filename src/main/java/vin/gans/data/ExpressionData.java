package vin.gans.data;

/**
 * Created by DELL on 12.08.2016.
 */
public class ExpressionData implements ParsedData {
    private String expression;

    public ExpressionData(String expression) {
        this.expression = expression;
    }

    @Override
    public String getData() {
        return expression;
    }
}
