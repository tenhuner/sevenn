package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gifu gifu = new Gifu();

        System.out.println("Tervetuloa Gifu-järjestelmään"); // Welcome message and prompt for university name
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
       String university = scanner.nextLine();

        while (true) {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case 1:  // Create a new course
                    System.out.println("Anna kurssin nimi:");
                    String courseName = scanner.nextLine();

                    System.out.println("Anna kurssin ID:");
                    String courseId = scanner.nextLine();

                    System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                    int maxStudents = Integer.parseInt(scanner.nextLine());

                    gifu.addCourse(new Course(courseName, courseId, maxStudents)); // Add the new course to Gifu
                    break;
                case 2: // Create a new student
                    System.out.println("Anna opiskelijan nimi:");
                    String studentName = scanner.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentNumber = scanner.nextLine();
                    gifu.addStudent(new Student(studentName, studentNumber)); // Add the new student to Gifu
                    break;
                case 3: // List all courses
                for (int i = 0; i < gifu.getCourses().size(); i++) {
                    Course course = gifu.getCourses().get(i);
                    System.out.println(i + ") " + course.getId() + " " + course.getName()); // Print course details
                }
                break;
                case 4: // List all students
                for (int i = 0; i < gifu.getStudents().size(); i++) {
                    Student student = gifu.getStudents().get(i);
                    System.out.println(i + ") " + student.getStudentNumber() + " " + student.getName()); // Print student details
                }
                break;
                case 5: // Add a student to a course
                    for (int i = 0; i < gifu.getCourses().size(); i++) {
                        System.out.println(i + ") " + gifu.getCourses().get(i).getId() + " " + gifu.getCourses().get(i).getName()); // Print courses
                    }
                    System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                    int courseIndex = Integer.parseInt(scanner.nextLine());
                    Course course = gifu.getCourse(courseIndex);

                    for (int i = 0; i < gifu.getStudents().size(); i++) {
                        System.out.println(i + ") " + gifu.getStudents().get(i).getStudentNumber() + " " + gifu.getStudents().get(i).getName());
                    }
                    System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                    int studentIndex = Integer.parseInt(scanner.nextLine()); // Read student number
                    Student student = gifu.getStudent(studentIndex);

                    gifu.addEnrollment(new Enrollment(student, course)); // Add enrollment to Gifu
                    break;
                case 6: // Grade students in a course
                    for (int i = 0; i < gifu.getCourses().size(); i++) {
                        System.out.println(i + ") " + gifu.getCourses().get(i).getId() + " " + gifu.getCourses().get(i).getName());
                    }
                    System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                    int courseToGradeIndex = Integer.parseInt(scanner.nextLine());
                    Course courseToGrade = gifu.getCourse(courseToGradeIndex);

                    for (Enrollment enrollment : gifu.getEnrollments()) {
                        if (enrollment.getCourse().equals(courseToGrade)) {
                            System.out.println("Anna arvosana opiskelijalle " + enrollment.getStudent().getStudentNumber() + " " + enrollment.getStudent().getName());
                            int grade = Integer.parseInt(scanner.nextLine());
                            enrollment.setGrade(grade);
                        }
                    }
                    break;
                case 7: // List students in a course
                    for (int i = 0; i < gifu.getCourses().size(); i++) {
                        System.out.println(i + ") " + gifu.getCourses().get(i).getId() + " " + gifu.getCourses().get(i).getName());
                    }
                    System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                    int courseToListIndex = Integer.parseInt(scanner.nextLine());
                    Course courseToList = gifu.getCourse(courseToListIndex);

                    for (Enrollment enrollment : gifu.getEnrollments()) {
                        if (enrollment.getCourse().equals(courseToList)) {
                            System.out.println(enrollment.getStudent().getStudentNumber() + " " + enrollment.getStudent().getName() + ", arvosana: " + enrollment.getGrade());
                        }
                    }
                    break;
                case 8: // List grades for a student
                    for (int i = 0; i < gifu.getStudents().size(); i++) {
                        System.out.println(i + ") " + gifu.getStudents().get(i).getStudentNumber() + " " + gifu.getStudents().get(i).getName());
                    }
                    System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                    int studentToListIndex = Integer.parseInt(scanner.nextLine());
                    Student studentToList = gifu.getStudent(studentToListIndex);

                    System.out.println("Opiskelijan " + studentToList.getStudentNumber() + " " + studentToList.getName() + " arvosanat:");
                    for (Enrollment enrollment : gifu.getEnrollments()) { // Print course details and grade for each enrollment of the student
                        if (enrollment.getStudent().equals(studentToList)) {
                            System.out.println(enrollment.getCourse().getId() + " " + enrollment.getCourse().getName() + ", arvosana: " + enrollment.getGrade());
                        }
                    }
                    break;
                case 9: // List all grades for all students in all courses
                    for (Course c : gifu.getCourses()) {
                        System.out.println(c.getId() + " " + c.getName()); // Print course details
                        for (Enrollment enrollment : gifu.getEnrollments()) { // Print student details and grade for each enrollment in the course
                            if (enrollment.getCourse().equals(c)) {
                                System.out.println(enrollment.getStudent().getStudentNumber() + " " + enrollment.getStudent().getName() + ", arvosana: " + enrollment.getGrade());
                            }
                        }
                    }
                    break;
                case 0: // Exit the program
                    System.out.println("Kiitos ohjelman käytöstä.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Virheellinen komento.");
            }
        }
    }
}
