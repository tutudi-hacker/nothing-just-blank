package lab5;


import java.util.Arrays;
import java.util.List;

public class Exercise9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, -1, 3, -8, 20, -50);

        System.out.println("--- a) Cubes of numbers ---");
        numbers.stream()
               .map(n -> n * n * n)
               .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\n--- b) Positive numbers ---");
        numbers.stream()
               .filter(n -> n > 0)
               .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\n--- c) Sorted numbers ---");
        numbers.stream()
               .sorted()
               .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
