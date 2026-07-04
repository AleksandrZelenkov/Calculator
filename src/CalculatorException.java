import mlya.Mlya;
public class CalculatorException extends Exception {

    CalculatorException(String message){
        super("\u001B[31m" + message + "\u001B[0m");
        Mlya mlya = new Mlya();
        mlya.say();
    }
}