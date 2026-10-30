package lab3;

import java.util.Scanner;

class Temperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: Read number of N cities
        System.out.print("Enter the number of cities (N): ");
        int n = sc.nextInt();
        
        // Create arrays to hold the temperatures for each city
        double[] celsius = new double[n];
        double[] fahrenheit = new double[n];
        
        // Process: Read Celsius input and convert to Fahrenheit
        for (int i = 0; i < n; i++) {
            System.out.print("Enter temperature in Celsius for City " + (i + 1) + ": ");
            celsius[i] = sc.nextDouble();
            
            // Formula calculation (Note: use 9.0 and 5.0 so Java uses decimal division)
            fahrenheit[i] = (celsius[i] * 9.0 / 5.0) + 32.0;
        }
        
        // Output: Display results for both scales
        System.out.println("\n--- Temperature Conversion Results ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("City %d -> Celsius: %.2f°C | Fahrenheit: %.2f°F\n", (i + 1), celsius[i], fahrenheit[i]);
        }
        sc.close(); }}