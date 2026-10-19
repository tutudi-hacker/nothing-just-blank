import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("input n : ");
        int n = s.nextInt();
        System.out.println("Output");
        System.out.println("All prime numbers from 2 to " + n + " :");

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        s.close();
    }
}
