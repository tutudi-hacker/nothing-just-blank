package lab04;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Test5 {
    public static void main(String[] args) {
        ArrayList<String> studentList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        try (Scanner filescanner = new Scanner(new File("Ex3StudentData.csv"))) {
            if (filescanner.hasNextLine()) {
                filescanner.nextLine();}
            while (filescanner.hasNextLine()) {
                studentList.add(filescanner.nextLine());}
        } catch (IOException e) {
            System.out.println("Error reading initial file.");}
        for (int i = 1; i <= 3; i++) {
            System.out.println("--- Enter details for New Student " + i + " ---");
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("ID: ");
            String id = input.nextLine();
            System.out.print("Gender: ");
            String gender = input.nextLine();
            studentList.add(name + "," + id + "," + gender);
            System.out.println(); }
        Collections.sort(studentList);
        try (FileWriter fw = new FileWriter("Ex3StudentData.csv")) {
            fw.write("Name,ID,Gender\n");
            for (String student : studentList) {
                fw.write(student + "\n");}
            System.out.println("Data sorted alphabetically by name and saved back to Ex3StudentData.csv successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
    }
