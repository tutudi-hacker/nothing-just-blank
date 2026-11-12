package lab5;


import java.util.Arrays;

public class Exercise11 {

    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 3, 8};

        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();

        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}
