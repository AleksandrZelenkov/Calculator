class Transformation {

    private int aInt;
    private int bInt;
    private String aString;
    private String bString;
    private String action;

    Transformation(){}
    Transformation(String aString, String bString, String action){this.aString = aString; this.bString = bString; this.action = action;}

    protected void definition() throws CalculatorException {

        if(aString.matches("\\d+") && bString.matches("\\d+")){
            arabic(aString, bString, action);

        } else {
            RomanNumeralsMap roman = new RomanNumeralsMap(aString, bString, action);
            roman.action();
        }
    }

    private static boolean checkingRange(int num) {
        return num < 11 && num >0;
    }

    private void arabic(String aString, String bString, String action) throws CalculatorException {
        aInt = Integer.parseInt(aString);
        bInt = Integer.parseInt(bString);

        if(checkingRange(aInt) && checkingRange(bInt)) {
            printAnswer(calculation(aInt, bInt, action));
        } else {
            throw new CalculatorException("Числа на входе должны находиться в диапазоне целых чисел от 1 до 10.");
        }
    }

    protected int calculation(int a, int b, String action) throws CalculatorException {
        int ansver = 0;
        switch (action){
            case "+": ansver = a + b; break;
            case "-": ansver = a - b; break;
            case "/": ansver = a / b; break;
            case "*": ansver = a * b; break;
            default: throw new CalculatorException("Такой операции не существует.");

        }
        return ansver;
    }

    protected static void printAnswer(int intAnswer){System.out.printf("Ответ: %d", intAnswer);}
    protected static void printAnswer(String stringAnswer){System.out.printf("Ответ: %s", stringAnswer);}
}