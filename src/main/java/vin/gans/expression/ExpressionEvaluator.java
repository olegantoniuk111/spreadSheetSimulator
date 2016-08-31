package vin.gans.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DELL on 31.08.2016.
 */
public class ExpressionEvaluator {

    public static boolean isKey(String key){
        Pattern pattern = Pattern.compile("^[A-Z]+[0-9]+$");
        Matcher matcher = pattern.matcher(key);
        return matcher.matches();
    }

    public static String separateExpression(String expression) {
        Pattern pattern = Pattern.compile("(([A-Z]+\\d+)|([0-9]+([,]|[.])[0-9]+)|([0-9]+)|([\\+\\-\\*/\\(\\)]))");
        Matcher m = pattern.matcher(expression);
        StringBuilder out = new StringBuilder(expression.length());
        while (m.find()) {
            String c = m.group();
            out.append(c);
            out.append(" ");
        }
        return out.toString();
    }
}
