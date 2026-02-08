import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Reading reed = new Reading(scan.nextLine());

        Transformation transformation = new Transformation(reed.getA(), reed.getB(), reed.getAction());
        System.out.printf(transformation.definition());
    }
}