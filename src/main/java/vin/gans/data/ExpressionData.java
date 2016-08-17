package vin.gans.data;

import java.util.Objects;

/**
 * Created by DELL on 12.08.2016.
 */
public class ExpressionData implements ParsedData {
    private String expression;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        return expression != null ? expression.equals(o.toString()) : o.toString() == null;

    }

    @Override
    public int hashCode() {
        return expression != null ? expression.hashCode() : 0;
    }

    public ExpressionData(String expression) {
        this.expression = expression;
    }

    @Override

    public String getValue() {
        return expression;
    }

    @Override
    public String toString() {
        return expression.toString();
    }
}
