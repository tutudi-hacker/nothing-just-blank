package lab04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<String> studentList = new ArrayList<>();
        try (Scanner filescanner = new Scanner(new File("Ex3StudentData.csv"))) {
            if (filescanner.hasNextLine()) {
                filescanner.nextLine();
            }
            while (filescanner.hasNextLine()) {
                studentList.add(filescanner.nextLine());
            }
            System.out.println("--- Displaying data from array list ---");
            for (String student : studentList) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}
