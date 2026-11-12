package lab5;
import java.util.Scanner;
public class MenuCalculator {
 public Scanner scanner;
 public MenuCalculator() {
this.scanner= new Scanner(System.in);
 }
 public void start() {
	 
int choice;
do {
displayMenu();
choice= scanner.nextInt();
	switch (choice){
	case 1:handleaddition(scanner); break;
	case 2 :handlesubstract(scanner); break;
	case 3:handlemultiply(scanner); break;
	case 4:handledivision(scanner); break;
	case 5:handleSumton(scanner);break;
	case 6:System.out.println("Exiting the calculator");
	default: System.out.println("Invalid choice pls enter option 1-6/n");
	}
	
}while (choice !=6);
scanner.close();
 }
private void displayMenu() {
	System.out.println("/n-----Calculator menu------\n");
	System.out.println("1.Addition (+)\n");
	System.out.println("2.Substraction(-)\n");
	System.out.println("3.Multiplication(*)");
	System.out.println("4.Division(/)");
	System.out.println("5.Sum number 1 to n");
	System.out.println("6.Exit");
	System.out.println("Enter ur choice (1-6):");
}
private void handleaddition(Scanner scanner) {
	System.out.print("enter the first number");
	double num1=scanner.nextDouble();
	System.out.print("enter the second number"); 
	double num2=scanner.nextDouble();
	System.out.println ("Result: "+ (num1+num2));
}
private void handlesubstract(Scanner scanner) {
	System.out.print("Enter the first number ");
	double num1= scanner.nextDouble();
	System.out.print("Enter the Second number ");
	double num2=scanner.nextDouble();
	System.out.println ("Result: "+(num1-num2));
}
private	void handlemultiply(Scanner scanner) {
System.out.print("Enter the first number");
double num1=scanner.nextDouble();
System.out.print("Enter the second number");
double num2=scanner.nextDouble();
System.out.println("Result:"+(num1*num2));
}
private void handledivision(Scanner scanner) {
	System.out.print("Enter the first number  ");
	double num1=scanner.nextDouble();
	System.out.print("Enter the second number");
	double num2=scanner.nextDouble();
	if(num2==0) {
		System.out.print("the number is not allowed");
	}else {
	System.out.println("Result:"+(num1/num2));}
}
private void handleSumton(Scanner scanner) {
	System.out.print("Please enter the integer n");
	int num =scanner.nextInt();
	if(num>=1) {
		System.out.print("please the enter the number that the number is greater or equal than 1");
	}else {
		int sum=0;
		for(int i=0;i<=num;i++) {
			sum+=i;
		}
		
		System.out.println("the sum of the number from 1"+num+"is:"+sum);
	}
}
public static void main(String[] args) {
    MenuCalculator calculator = new MenuCalculator();
    calculator.start();
}

}


