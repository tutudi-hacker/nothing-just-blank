import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Input your scores of 4 subjects (Math, English, Physics, and Programming): ");
        int m = s.nextInt();
        int e = s.nextInt();
        int p = s.nextInt();
        int r = s.nextInt();

        int max = Math.max(Math.max(m, e), Math.max(p, r));
        int min = Math.min(Math.min(m, e), Math.min(p, r));

        String maxC = "";
        if (m == max) maxC += "Math and ";
        if (e == max) maxC += "English and ";
        if (p == max) maxC += "Physics and ";
        if (r == max) maxC += "Programming and ";
        maxC = maxC.substring(0, maxC.length() - 5);
        String maxTail = maxC.contains(" and ") ? " courses)." : " course).";

        String minC = "";
        if (m == min) minC += "Math and ";
        if (e == min) minC += "English and ";
        if (p == min) minC += "Physics and ";
        if (r == min) minC += "Programming and ";
        minC = minC.substring(0, minC.length() - 5);
        String minTail = minC.contains(" and ") ? " courses)." : " course).";

        System.out.println("\nOutput:");
        System.out.println("Max score is: " + max + " (" + maxC + maxTail);
        System.out.println("Min score is: " + min + " (" + minC + minTail);
        System.out.println("Average score of this student is: " + ((m + e + p + r) / 4.0));
        s.close();
    }
}
