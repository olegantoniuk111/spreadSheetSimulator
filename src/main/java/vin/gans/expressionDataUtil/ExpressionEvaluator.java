package vin.gans.expressionDataUtil;

import vin.gans.data.ExpressionData;
import vin.gans.data.FloatData;
import vin.gans.data.IntData;
import vin.gans.data.ParsedData;
import vin.gans.exception.DataParseException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DELL on 31.08.2016.
 */
public class ExpressionEvaluator {
    private Map<String, ParsedData> parsedSimpleData;
    private Map<String, String> expressionData;

    public ExpressionEvaluator(Map<String, ParsedData> parsedSimpleData, Map<String, String> expressionData) {
        this.parsedSimpleData = parsedSimpleData;
        this.expressionData = expressionData;
    }

    private static final String operators = "-+/*";

    public static boolean isOperator(String str){
        return operators.indexOf(str) >= 0;
    }

    public static boolean isKey(String key){
        Pattern pattern  = Pattern.compile("^[A-Z]+[0-9]+$");
        Matcher matcher = pattern.matcher(key);
        return matcher.matches();
    }

    public  static String separateExpression(String expression) {
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

//    public  ParsedData getByKeyFromSimpleData(String key) throws DataParseException {
//        if(ExpressionEvaluator.isKey(key)){
//            return parsedSimpleData.get(key);
//        }else throw new DataParseException("keyException");
// }
    private static Deque<String> createStackFromExpression(String expressionData){
        String separatedExpression = separateExpression(expressionData);
        String [] array = separatedExpression.split(" ");
        Deque<String> stack = new ArrayDeque<>(array.length);
            for (int i = array.length-1;i>-1;i--){
                stack.push(array[i]);
            }
        return stack;
    }


    public Float evaluate(String data){
        Deque<String> stack = createStackFromExpression(data);
        Stack <Float> result = new Stack<>();
        result.push(0.0f);
        Float number;
        while (!stack.isEmpty()){
            String expression = stack.pop();
            if (isKey(expression)&& parsedSimpleData.containsKey(expression)) {
                number = Float.parseFloat(parsedSimpleData.get(expression).toString());
                result.push(number + result.pop());
            }else if (isKey(expression)&& expressionData.containsKey(expression)) {
                number = evaluate(expressionData.get(expression));
                result.push(number + result.pop());
            }
            else if(IntData.parseInt(expression)){
                number = Float.parseFloat(expression);
                result.push(number + result.pop());
            }
            else if(FloatData.parseFloat(expression)){
                number = Float.parseFloat(expression);
                result.push(number + result.pop());
            }
            else if (isOperator(expression)){
                if (expression.equals("+")){
                    number = result.pop() + evaluate(stack.pop()) ;
                    result.push(number);
                }else  if (expression.equals("-")){
                    number = result.pop() - evaluate(stack.pop()) ;
                    result.push(number);
                }else if (expression.equals("*")){
                    number = result.pop() * evaluate(stack.pop()) ;
                    result.push(number);
                }else if (expression.equals("/")){
                    number = result.pop() / evaluate(stack.pop()) ;
                    result.push(number);
                }

            }

        }
        return result.pop();
        }

    }



