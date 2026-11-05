package lab04;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        File f =new File ("Lucky number.csv");
        Random rand = new Random();
        try{
            FileWriter fw = new FileWriter(f);
        for (int k = 1; k <= 500 ; k++) {
            fw.write(rand.nextInt(1000)+ "\n");}
            fw.close();
            System.out.println("System of the number are print out successfully :)");
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            Scanner filescanner= new Scanner(f);
            System.out.println("----Reading the file-----");
            while (filescanner.hasNextLine()){
             System.out.println(filescanner.nextLine());
            }
            filescanner.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}