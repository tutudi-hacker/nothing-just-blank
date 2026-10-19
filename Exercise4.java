import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Input (yyyy-mm-dd): ");
        String rawInput = s.nextLine();
        
        String cleanInput = rawInput.replace("-", " ");
        Scanner parser = new Scanner(cleanInput);

        if (parser.hasNextInt()) {
            int y = parser.nextInt();
            int m = parser.nextInt();
            int d = parser.nextInt();
            int max = 31;

            if (m == 4 || m == 6 || m == 9 || m == 11) {
                max = 30;
            } else if (m == 2) {
                // Leap year check
                max = ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) ? 29 : 28;
            }

            if (m >= 1 && m <= 12 && d >= 1 && d <= max) {
                System.out.println("Output: valid");
            } else {
                System.out.println("Output: invalid");
            }
        } else {
            System.out.println("Output: invalid format");
        }

        parser.close();
        s.close();
    }
}
