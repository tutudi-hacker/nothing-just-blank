package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise10 {

    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        String filePath = "students.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if ((line = br.readLine()) != null) {
            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(csvSplitBy);
                if (parts.length >= 1) {
                    String name = parts[0].trim().replace("\"", "");
                    studentNames.add(name);
                }
            }
        } catch (IOException e) {
            System.err.println("File reading error: " + e.getMessage());
        }

        studentNames.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
