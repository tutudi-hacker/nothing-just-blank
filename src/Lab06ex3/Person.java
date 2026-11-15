package Lab06ex3;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    protected String studentId;

    public Student(String name, String studentId) {
        super(name);
        this.studentId = studentId;
    }
}

class OnlineStudent extends Student {
    private String zoomId;

    public OnlineStudent(String name, String studentId, String zoomId) {
        super(name, studentId);
        this.zoomId = zoomId;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Zoom ID: " + this.zoomId);
    }
}

 class Main {
    public static void main(String[] args) {
        OnlineStudent onlineStudent = new OnlineStudent("Alice Johnson", "S10245", "zoom_alice_99");
        onlineStudent.displayInfo();
    }
}
