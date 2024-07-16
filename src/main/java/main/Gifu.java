package main;

import java.util.ArrayList;

public class Gifu {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Enrollment> enrollments;

    public Gifu() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(int index) {
        return courses.get(index);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }
}
