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

    Transformation(String aString, String bString, String action){this.aString = aString; this.bString = bString; this.action = action;}

    protected String definition() {

        try {
          a = Integer.parseInt(aString);
          b = Integer.parseInt(bString);

          if(checkingRange(a) && checkingRange(b)) {
              outputString = ANSWER_TEXT + calculation(a, b, action);
          } else{
              outputString = "\u001B[31mЧисла на входе должны находиться в диапазоне целых чисел от 1 до 10.";
          }

        } catch (NumberFormatException nfe) {

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

            for(Map.Entry<String, Integer> entry : numbers.entrySet()) {
                if(entry.getValue().equals(calculation(numbers.get(aString), numbers.get(bString), action))){
                    outputString = entry.getKey();
                }
            }
        }
        if(outputString != null){return outputString;}else{return "\u001B[31mОшибка.";}
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
                System.out.println("\u001B[31mТакой операции не существует.");
        }
        return ansver;
    }
}
