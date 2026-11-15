package Lab06ex1;

class Employee {
String name;
double salary;
public Employee(String name, double salary) {
this.name=name;
this.salary=salary;
}
public double calculatebonus() {
return this.salary*0.1;
}
}
class Manager extends Employee{
public Manager(String name ,double salary) {
super(name,salary);
}
public double calculatebonus() {
return salary*0.2;
}
}
class Intern extends Employee{
public Intern(String name, double salary) {
super(name,salary);
}
public double calculatebonus() {
return salary*0.05;
}
}
class Main {
public static void main(String[] args) {
Employee [] team =new Employee[3];
team[0]=new Employee("Cao Cao",1000 );
team[1]=new Manager("Zhuge",2000);
team[2]=new Intern("Guanyu",5000);
System.out.print("---Payroll bonus calculation----\n");
for(Employee emp:team) {
System.out.println(emp.name+"Bonus:"+emp.calculatebonus());
}
}
}