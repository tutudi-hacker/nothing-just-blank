package lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test7 {
    static class Student {
        String originalLine;
        String gender;
        String group;

        Student(String originalLine, String gender, String group) {
            this.originalLine = originalLine;
            this.gender = gender;
            this.group = group;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        String header = "";
        try (Scanner sc = new Scanner(new File("StudentsPerformance.csv"))) {
            if (sc.hasNextLine()) {
                header = sc.nextLine();
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String cleanLine = line.replace("\"", "");
                String[] parts = cleanLine.split(",");
                if (parts.length >= 2) {
                    String gender = parts[0].trim();
                    String group = parts[1].trim();
                    list.add(new Student(line, gender, group));
                }
            }
            processAndWriteGroups(list, header);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processAndWriteGroups(ArrayList<Student> list, String header) {
        Map<String, ArrayList<Student>> groupsMap = new HashMap<>();
        for (Student s : list) {
            groupsMap.putIfAbsent(s.group, new ArrayList<>());
            groupsMap.get(s.group).add(s);
        }

        for (Map.Entry<String, ArrayList<Student>> entry : groupsMap.entrySet()) {
            String groupName = entry.getKey();
            ArrayList<Student> groupStudents = entry.getValue();

            int total = groupStudents.size();
            int male = 0;
            int female = 0;

            for (Student s : groupStudents) {
                if (s.gender.equalsIgnoreCase("male")) male++;
                else if (s.gender.equalsIgnoreCase("female")) female++;
            }

            double malePct = (double) male / total * 100;
            double femalePct = (double) female / total * 100;

            System.out.println(groupName + ": " + total + " students");
            System.out.printf("  Male candidates: %.2f%%\n", malePct);
            System.out.printf("  Female candidates: %.2f%%\n", femalePct);

            String fileName = groupName.replace(" ", "") + ".csv";
            try (FileWriter fw = new FileWriter(fileName)) {
                fw.write(header + "\n");
                for (Student s : groupStudents) {
                    fw.write(s.originalLine + "\n");
                }
                fw.write("\nSummary:\n");
                fw.write("Total Students," + total + "\n");
                fw.write("Male Percentage," + String.format("%.2f%%", malePct) + "\n");
                fw.write("Female Percentage," + String.format("%.2f%%", femalePct) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
