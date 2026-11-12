package lab5;

public class Exercise4 {

    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;
        private boolean isFullTime;

        public Employee(int id, String name, String department, double salary, boolean isFullTime) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.isFullTime = isFullTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public boolean isFullTime() {
            return isFullTime;
        }

        public void setFullTime(boolean isFullTime) {
            this.isFullTime = isFullTime;
        }

        public void displayEmployeeDetails() {
            System.out.println("Employee ID   : " + id);
            System.out.println("Name          : " + name);
            System.out.println("Department    : " + department);
            System.out.println("Monthly Salary: $" + salary);
            System.out.println("Employment    : " + (isFullTime ? "Full-Time" : "Part-Time"));
            System.out.println("------------------------------------");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Employee Constructor ---");
        
        Employee emp1 = new Employee(101, "Alice Smith", "Software Engineering", 7500.00, true);
        emp1.displayEmployeeDetails();

        System.out.println("--- Testing Setters (Modifying Data) ---");
        emp1.setDepartment("Project Management");
        emp1.setSalary(8200.50);
        
        System.out.println("Updated Dept  : " + emp1.getDepartment());
        System.out.println("Updated Salary: $" + emp1.getSalary());
    }
}
