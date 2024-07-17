package main;
public class Course {
    private String name;
    private String id;
    private int maxStudents;

    public Course(String name, String id, int maxStudents) { // Constructor to initialize course attributes
        this.name = name;
        this.id = id;
        this.maxStudents = maxStudents;
    }

    public String getName() { // Getter for course name
        return name;
    }

    public String getId() { // Getter for course ID
        return id;
    }

    public int getMaxStudents() { // Getter for maximum number of students
        return maxStudents;
    }
}
