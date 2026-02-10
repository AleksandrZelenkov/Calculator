import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) throws CalculatorException{

        Scanner scan = new Scanner(System.in);
        Reading reading = new Reading(scan.nextLine());
        reading.split();
        Transformation transformation = new Transformation(reading.getA(), reading.getB(), reading.getAction());
        transformation.definition();
    }
}