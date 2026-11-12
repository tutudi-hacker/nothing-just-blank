package lab5;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise8 {

    static class Student {
        String name;
        String id;
        int age;
        String gender;

        public Student(String name, String id, int age, String gender) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Student{ID='" + id + "', Name='" + name + "', Age=" + age + ", Gender='" + gender + "'}";
        }
    }

    static class SumTask implements Runnable {
        private int n;

        public SumTask(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            System.out.println("[Task 1] Calculating sum from 1 to " + n + "...");
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println("[Task 1] Complete. Sum from 1 to " + n + " = " + sum);
        }
    }

    static class PrimeTask implements Runnable {
        @Override
        public void run() {
            System.out.println("[Task 2] Finding prime numbers between 1 and 100...");
            StringBuilder primes = new StringBuilder();
            for (int i = 2; i <= 100; i++) {
                if (isPrime(i)) {
                    primes.append(i).append(" ");
                }
            }
            System.out.println("[Task 2] Complete. Prime numbers: " + primes.toString().trim());
        }

        private boolean isPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

    static class CSVReaderTask implements Runnable {
        private String filePath;
        private ArrayList<Student> studentsList = new ArrayList<>();

        public CSVReaderTask(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            System.out.println("[Task 3] Reading data from CSV file: " + filePath + "...");
            String line;
            String csvSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                if ((line = br.readLine()) != null) {
                }

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(csvSplitBy);
                    if (parts.length >= 4) {
                        String name = parts[0].trim().replace("\"", "");
                        String id = parts[1].trim().replace("\"", "");
                        int age = Integer.parseInt(parts[2].trim().replace("\"", ""));
                        String gender = parts[3].trim().replace("\"", "");

                        studentsList.add(new Student(name, id, age, gender));
                    }
                }
                System.out.println("[Task 3] Complete. Successfully loaded " + studentsList.size() + " students into array list.");
                
            } catch (IOException e) {
                System.err.println("[Task 3] File reading error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("[Task 3] Error parsing student age data: " + e.getMessage());
            }
        }

        public ArrayList<Student> getStudentsList() {
            return studentsList;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Starting Multiple Threads ===");

        Thread thread1 = new Thread(new SumTask(1000));
        Thread thread2 = new Thread(new PrimeTask());
        Thread thread3 = new Thread(new CSVReaderTask("students.csv"));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Main execution thread was interrupted.");
        }

        System.out.println("=== All Threads Finished Execution ===");
    }
}