package lab5;

import java.math.BigInteger;

public class Exercise5 {

    public static BigInteger factorialProcedural(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger factorialRecursive(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialRecursive(n - 1));
    }

    public static void main(String[] args) {
        int[] inputs = {3, 6, 10, 50};

        for (int n : inputs) {
            System.out.println("Procedural " + n + "! = " + factorialProcedural(n));
            System.out.println("Recursive  " + n + "! = " + factorialRecursive(n));
        }
    }
}
