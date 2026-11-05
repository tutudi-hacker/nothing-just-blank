package lab04;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Test6 {
    static class Candidate {
        String gender;
        String group;
        int math;
        int reading;
        int writing;
        Candidate(String gender, String group, int math, int reading, int writing) {
            this.gender = gender;
            this.group = group;
            this.math = math;
            this.reading = reading;
            this.writing = writing;
        }
    }
    public static void main(String[] args) {
        ArrayList<Candidate> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("StudentsPerformance.csv"))) {
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine().replace("\"", "");
                String[] parts = line.split(",");
                if (parts.length >= 8) {
                    String gender = parts[0].trim();
                    String group = parts[1].trim();
                    int math = Integer.parseInt(parts[5].trim());
                    int reading = Integer.parseInt(parts[6].trim());
                    int writing = Integer.parseInt(parts[7].trim());
                    list.add(new Candidate(gender, group, math, reading, writing));
                }
            }
            q1(list);
            q2(list);
            q3(list);
            q4(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void q1(ArrayList<Candidate> list) {
        int total = list.size();
        int male = 0;
        int female = 0;
        for (Candidate c : list) {
            if (c.gender.equalsIgnoreCase("male")) male++;
            else if (c.gender.equalsIgnoreCase("female")) female++;
        }
        System.out.println("--- Question 1 ---");
        System.out.println("Total candidates: " + total);
        System.out.printf("Male candidates: %.2f%%\n", (double) male / total * 100);
        System.out.printf("Female candidates: %.2f%%\n\n", (double) female / total * 100);
    }

    public static void q2(ArrayList<Candidate> list) {
        int count = 0;
        int male = 0;
        int female = 0;
        for (Candidate c : list) {
            double avg = (c.math + c.reading + c.writing) / 3.0;
            if (avg >= 90) {
                count++;
                if (c.gender.equalsIgnoreCase("male")) male++;
                else if (c.gender.equalsIgnoreCase("female")) female++;
            }
        }
        System.out.println("--- Question 2 ---");
        System.out.println("Candidates with average score >= 90: " + count);
        if (count > 0) {
            System.out.printf("Male candidates: %.2f%%\n", (double) male / count * 100);
            System.out.printf("Female candidates: %.2f%%\n\n", (double) female / count * 100);
        } else {
            System.out.println("No candidates found.\n");
        }
    }

    public static void q3(ArrayList<Candidate> list) {
        int count = 0;
        for (Candidate c : list) {
            if (c.math >= 85 && c.reading >= 85 && c.writing >= 85) {
                count++;
            }
        }
        System.out.println("--- Question 3 ---");
        System.out.println("Candidates with score >= 85 in each subject: " + count + "\n");
    }

    public static void q4(ArrayList<Candidate> list) {
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, Integer> maleMap = new HashMap<>();
        Map<String, Integer> femaleMap = new HashMap<>();
        for (Candidate c : list) {
            totalMap.put(c.group, totalMap.getOrDefault(c.group, 0) + 1);
            if (c.gender.equalsIgnoreCase("male")) {
                maleMap.put(c.group, maleMap.getOrDefault(c.group, 0) + 1);
            } else if (c.gender.equalsIgnoreCase("female")) {
                femaleMap.put(c.group, femaleMap.getOrDefault(c.group, 0) + 1);
            }
        }
        System.out.println("--- Question 4 ---");
        for (String group : totalMap.keySet()) {
            int tot = totalMap.get(group);
            int m = maleMap.getOrDefault(group, 0);
            int f = femaleMap.getOrDefault(group, 0);
            System.out.println(group + ": " + tot + " students");
            System.out.printf("  Male candidates: %.2f%%\n", (double) m / tot * 100);
            System.out.printf("  Female candidates: %.2f%%\n", (double) f / tot * 100);
        }
    }
}
