package lab04;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        File f = new File("Ex2Luckynumber");
        f.mkdir();
        
        Random rand = new Random();
        ArrayList<Integer> allNumbers = new ArrayList<>();
        System.out.println("Enter n");
        int n = input.nextInt();
        for (int k = 1; k <= n; k++) {
            FileWriter fw = new FileWriter(new File(f, "folder" + k + ".csv"));
            for (int i = 0; i < 5; i++) {
                fw.write((rand.nextInt(100) + 1) + "\n");
            }
            fw.close();
        }
        for (int k = 1; k <= n; k++) {
            Scanner filescanner = new Scanner(new File(f, "folder" + k + ".csv"));
            while (filescanner.hasNextInt()) {
                allNumbers.add(filescanner.nextInt());
            }
            filescanner.close();
        }
        if (!allNumbers.isEmpty()) {
            System.out.println("Max:" + Collections.max(allNumbers));
            System.out.println("Min:" + Collections.min(allNumbers));
        } else {
            System.out.println("No numbers were generated because n was less than 1.");
        }
        
        input.close();
    }
}
