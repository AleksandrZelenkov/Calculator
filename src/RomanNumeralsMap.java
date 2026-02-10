import java.util.ArrayList;
import java.util.List;

class RomanNumeralsMap extends Transformation{

    private String aString;
    private String bString;
    private String action;

    private List<String> units = new ArrayList<>(List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"));
    private final List<String> DOZENS = new ArrayList<>(List.of("X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"));

    RomanNumeralsMap(String aString, String bString, String action) {
        this.aString = aString;
        this.bString = bString;
        this.action = action;

        for (String numDozens : DOZENS) {
            units.add(numDozens);
            for (int h = 0; h < 9; h++) {
                units.add(numDozens + units.get(h));
            }
        }
    }

    protected void action() throws CalculatorException {
        if (units.contains(aString) && units.contains(bString)) {
            if(units.lastIndexOf(aString) < 10 && units.lastIndexOf(bString) < 10){
                printAnswer(units.get(calculation(units.lastIndexOf(aString)+1, units.lastIndexOf(bString)+1, action)-1));
            } else {throw new CalculatorException("Числа на входе должны находиться в диапазоне целых чисел от 1 до 10.");}
        } else {throw new CalculatorException("Введённые значения не являются числами.");}
    }

    // Потехи ради:
    private void review () {
        int y = 0;
        for (String numUnits : units) {
            System.out.print(numUnits + " ");
            y++;
            if (y == 10) {
                System.out.println();
                y = 0;
            }
        }
            System.out.println("\n" + units.size());
    }
}