package Lab06ex2;

public class Vehicle {
String Brand;
int year;
public Vehicle(String Brand, int year) {
this.Brand=Brand;
this.year=year;
}
public void start() {
System.out.println("The "+year+" "+Brand+ " is starting up");
}
}
class Car extends Vehicle{
public int numdoors;
public Car(String Brand,int year,int numdoors ) {
super(Brand, year);
this.numdoors=numdoors;
}
public void honk(){
System.out.print("BEEP BEEP! \n");
}
}
class Main {
public static void main(String[] args) {
Vehicle genericVehicle = new Vehicle("Generic transporter",2020);
genericVehicle.start();
System.out.println("-------------------------");
Car myCar=new Car("Hyundai",2000, 5);
myCar.honk();
myCar.start();
}
}