package lab3;

import java.util.Scanner;

class EmployeeData { // Renamed helper class to avoid conflict
    String id;
    String name;
    double basicSalary;
    double hra;
    double tca;
    double grossSalary;

    // Constructor to initialize employee data and calculate salary components
    EmployeeData(String id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        
        // Calculations based on the formulas given
        this.hra = 0.20 * basicSalary; // 20% of Basic Salary
        this.tca = 0.10 * basicSalary; // 10% of Basic Salary
        this.grossSalary = basicSalary + this.hra + this.tca;
    }
}

public class Employee { // Matches your filename Employee.java perfectly
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees (N): ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Create an array to store N employees
        EmployeeData[] employees = new EmployeeData[n];

        // Input loop
        for (int i = 0; i < n; i++) { // Fixed lowercase 'for'
            System.out.println("\n--- Employee " + (i + 1) + " ---");
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
            
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Basic Salary: ");
            double basicSalary = sc.nextDouble();
            sc.nextLine(); // Consume newline

            // Create object and store it in the array
            employees[i] = new EmployeeData(id, name, basicSalary);
        }

        // Output loop to display details
        System.out.println("\n==================== All Employee Salary Details ====================");
        for (EmployeeData emp : employees) {
            System.out.printf("ID: %s | Name: %s | Basic: $%.2f | HRA: $%.2f | TCA: $%.2f | Gross Salary: $%.2f\n",
                    emp.id, emp.name, emp.basicSalary, emp.hra, emp.tca, emp.grossSalary);
        }
        System.out.println("=====================================================================");

        sc.close();
    }
}
