package lab3;

import java.util.Scanner;

class StudentData {
    String id;
    String name;
    double[] marks = new double[5];
    double totalMarks;
    double average;
    char grade;

    // Constructor to process data and determine grade
    StudentData(String id, String name, double[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        
        // Calculate total marks
        this.totalMarks = 0;
        for (double mark : marks) {
            this.totalMarks += mark;
        }
        
        // Calculate average for 5 subjects
        this.average = this.totalMarks / 5.0;
        
        // Assign grade based on average boundaries
        if (this.average >= 90) {
            this.grade = 'A';
        } else if (this.average >= 75) {
            this.grade = 'B';
        } else if (this.average >= 50) {
            this.grade = 'C';
        } else {
            this.grade = 'F';
        }
    }
}

public class Student { // Matches your filename Student.java perfectly
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students (N): ");
        int n = sc.nextInt();
        sc.nextLine(); // Clear buffer

        StudentData[] students = new StudentData[n];

        // Input loop
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();
            
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            
            double[] tempMarks = new double[5];
            System.out.println("Enter marks for 5 subjects:");
            for (int j = 0; j < 5; j++) {
                System.out.print("  Subject " + (j + 1) + ": ");
                tempMarks[j] = sc.nextDouble();   }
            sc.nextLine(); // Clear buffer
            // Create object and store it
            students[i] = new StudentData(id, name, tempMarks);  }

        // Output loop to display details
        System.out.println("\n=========================== Student Grade Reports ===========================");
        for (StudentData s : students) {
            System.out.printf("ID: %s | Name: %s | Total: %.1f | Avg: %.2f | Grade: %c\n",
                    s.id, s.name, s.totalMarks, s.average, s.grade);
        }
        System.out.println("=============================================================================");

        sc.close();
    }
}

