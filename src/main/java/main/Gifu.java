package main;

import java.util.ArrayList;

public class Gifu {  // Constructor to initialize the lists
    private ArrayList<Course> courses; // Initialize list
    private ArrayList<Student> students; // Initialize list
    private ArrayList<Enrollment> enrollments; // Initialize list

    public Gifu() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }

    public void addCourse(Course course) {  // Method to add a new course 
        courses.add(course); // Add course to the list
    }

    public Course getCourse(int index) { // Method to get a course by number
        return courses.get(index); // Return course at specified number
    }

    public ArrayList<Course> getCourses() { // Method to get the list of courses
        return courses;
    }

    public void addStudent(Student student) { // Method to add a new student
        students.add(student);
    }

    public Student getStudent(int index) { // Method to get a student by number
        return students.get(index);
    }

    public ArrayList<Student> getStudents() { // Method to get the list of students
        return students;
    }

    public void addEnrollment(Enrollment enrollment) { // Method to add a new enrollmen
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments() { // Method to get the list of enrollments
        return enrollments;
    }
}
