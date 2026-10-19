import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Enter the number: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n <= 1000) {
                    break;
                } else {
                    System.out.println("The number shouldn't be more than 1000.");
                }
            } else {
                System.out.println("Error: Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }

        StringBuilder sequenceOutput = new StringBuilder();
        int sum = 0;
        int count = 0;

        for (int i = 1000; i >= n; i--) {
            sequenceOutput.append(i).append(",");
            sum += i;
            count++;
        }

        // Remove the trailing comma if sequence is not empty
        if (sequenceOutput.length() > 0) {
            sequenceOutput.setLength(sequenceOutput.length() - 1);
        }

        double average = (count > 0) ? (double) sum / count : 0.0;

        System.out.println(sequenceOutput.toString());
        System.out.println("the sum is: " + sum);
        System.out.println("the average is: " + average);

        scanner.close();
    }
}


