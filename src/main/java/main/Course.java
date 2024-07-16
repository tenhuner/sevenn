package main;
public class Course {
    private String name;
    private String id;
    private int maxStudents;

    public Course(String name, String id, int maxStudents) {
        this.name = name;
        this.id = id;
        this.maxStudents = maxStudents;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getMaxStudents() {
        return maxStudents;
    }
}
