package Lab06ex9;
import java.util.ArrayList;
import java.util.List;

public class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(this.name + " is performing general activities.");
    }

    public String get_role() {
        return "Person";
    }

    public static void main(String[] args) {
        List<Person> staff = new ArrayList<>();
        staff.add(new Employee("David", "EMP-01"));
        staff.add(new MathTeacher("Sarah", "EMP-02"));
        staff.add(new ScienceTeacher("Michael", "EMP-03"));

        for (Person person : staff) {
            System.out.println("Role: " + person.get_role());
            person.work();
            System.out.println();
        }
    }
}

class Employee extends Person {
    protected String employeeId;

    public Employee(String name, String employeeId) {
        super(name);
        this.employeeId = employeeId;
    }

    @Override
    public void work() {
        System.out.println(this.name + " (ID: " + this.employeeId + ") is working on assigned duties.");
    }

    @Override
    public String get_role() {
        return "Employee";
    }
}

abstract class Teacher extends Employee {
    public Teacher(String name, String employeeId) {
        super(name, employeeId);
    }

    @Override
    public abstract void work();

    @Override
    public String get_role() {
        return "Teacher";
    }
}

class MathTeacher extends Teacher {
    public MathTeacher(String name, String employeeId) {
        super(name, employeeId);
    }

    @Override
    public void work() {
        System.out.println(this.name + " (ID: " + this.employeeId + ") is teaching calculus and algebra.");
    }

    @Override
    public String get_role() {
        return "Math Teacher";
    }
}

class ScienceTeacher extends Teacher {
    public ScienceTeacher(String name, String employeeId) {
        super(name, employeeId);
    }

    @Override
    public void work() {
        System.out.println(this.name + " (ID: " + this.employeeId + ") is conducting a chemistry lab experiment.");
    }

    @Override
    public String get_role() {
        return "Science Teacher";
    }
}
