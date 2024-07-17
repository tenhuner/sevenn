package main;

public class Student { //Constructor to initialize student attributes
    private String name;
    private String studentNumber;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public String getName() { // Getter for student name
        return name;
    }

    public String getStudentNumber() { // Getter for student number
        return studentNumber;
    }
}
