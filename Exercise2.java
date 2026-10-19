import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("       Welcome to our program ");
        System.out.println("this is the quadratic equation ax^2+bx+c=0");
        System.out.println("======================================");

        System.out.print("enter a : ");
        double a = scanner.nextDouble();
        System.out.print("enter b: ");
        double b = scanner.nextDouble();
        System.out.print("enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("It is not a quadratic equation.");
        } else {
            double discriminant = (b * b) - (4 * a * c);
            System.out.println("Roots of this equation: " + (int) a + "x^2 + " + (int) b + "x + " + (int) c + " = 0 are:");

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("root1 is: " + x1);
                System.out.println("root2 is: " + x2);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("There is only 1 root: " + x);
            } else {
                // Handling imaginary roots cleanly
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                System.out.printf("root1 is: %.2f + %.2fi\n", realPart, imaginaryPart);
                System.out.printf("root2 is: %.2f - %.2fi\n", realPart, imaginaryPart);
            }
        }
        scanner.close();
    }
}
