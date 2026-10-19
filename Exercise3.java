import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input:");
        String userInput = scanner.nextLine();
        String[] tokens = userInput.split("\\s+");
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                numbers.add(Integer.parseInt(token));
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("No numbers were entered.");
            scanner.close();
            return;
        }

        int minNum = Collections.min(numbers);
        int maxNum = Collections.max(numbers);
        StringBuilder numbersStr = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.size() == 1) {
                numbersStr.append(numbers.get(i));
            } else if (i == numbers.size() - 1) {
                numbersStr.append(" and ").append(numbers.get(i));
            } else if (i == numbers.size() - 2) {
                numbersStr.append(numbers.get(i));
            } else {
                numbersStr.append(numbers.get(i)).append(", ");
            }
        }

        System.out.println("The output");
        System.out.println("the " + numbers.size() + " numbers are (" + numbersStr.toString() + "), min is " + minNum + ", max is " + maxNum);
        scanner.close();
    }
}
