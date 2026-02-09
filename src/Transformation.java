import java.util.HashMap;
import java.util.Map;

public class Transformation {

    private int a;
    private int b;
    private String aString;
    private String bString;
    private String action;
    private String outputString;
    private final String ANSWER_TEXT = "Ответ: ";
    private final String RED_COLOR = "\u001B[31m";

    Transformation(String aString, String bString, String action){this.aString = aString; this.bString = bString; this.action = action;}

    protected String definition(){

        try {
          a = Integer.parseInt(aString);
          b = Integer.parseInt(bString);

          if(checkingRange(a) && checkingRange(b)) {
              outputString = ANSWER_TEXT + calculation(a, b, action);
          } else{
              outputString = RED_COLOR + "Числа на входе должны находиться в диапазоне целых чисел от 1 до 10.";
          }

        } catch (NumberFormatException nfe){

            Map<String, Integer> numbers = new HashMap<>();
            numbers.put("I", 1);
            numbers.put("II", 2);
            numbers.put("III", 3);
            numbers.put("IV", 4);
            numbers.put("V", 5);
            numbers.put("VI", 6);
            numbers.put("VII", 7);
            numbers.put("VIII", 8);
            numbers.put("IX", 9);
            numbers.put("X", 10);

            if (numbers.get(aString) != null && numbers.get(bString) != null) {
                for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
                    if (entry.getValue().equals(calculation(numbers.get(aString), numbers.get(bString), action))) {
                        outputString = entry.getKey();
                    }
                }
            } else{
            outputString = RED_COLOR + "Введённые значения не являются числами.";
            }
        }
        if(outputString != null){return outputString;}else{return RED_COLOR + "Ошибка.";}
    }

    private boolean checkingRange(int num){
        return num > 0 && num < 11;
    }

    private int calculation(int a, int b, String action){
        int ansver = 0;
        switch (action){
            case "+": ansver = a + b; break;
            case "-": ansver = a - b; break;
            case "/": ansver = a / b; break;
            case "*": ansver = a * b; break;
            default:
                System.out.println(RED_COLOR + "Такой операции не существует.");
        }
        return ansver;
    }
}
