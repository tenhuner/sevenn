package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gifu gifu = new Gifu();

        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
       String university = scanner.nextLine();

        while (true) {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case 1:
                    System.out.println("Anna kurssin nimi:");
                    String courseName = scanner.nextLine();

                    System.out.println("Anna kurssin ID:");
                    String courseId = scanner.nextLine();

                    System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                    int maxStudents = Integer.parseInt(scanner.nextLine());

                    gifu.addCourse(new Course(courseName, courseId, maxStudents));
                    break;
                case 2:
                    System.out.print("Anna opiskelijan nimi:");
                    String studentName = scanner.nextLine();
                    System.out.print("Anna opiskelijan opiskelijanumero:");
                    String studentNumber = scanner.nextLine();
                    gifu.addStudent(new Student(studentName, studentNumber));
                    break;
                case 3:
                for (int i = 0; i < gifu.getCourses().size(); i++) {
                    Course course = gifu.getCourses().get(i);
                    System.out.println(i + ") " + course.getId() + " " + course.getName());
                }
                break;
                case 4:
                for (int i = 0; i < gifu.getStudents().size(); i++) {
                    Student student = gifu.getStudents().get(i);
                    System.out.println(i + ") " + student.getStudentNumber() + " " + student.getName());
                }
                break;
                case 5:
                    for (int i = 0; i < gifu.getCourses().size(); i++) {
                        System.out.println(i + ") " + gifu.getCourses().get(i).getId() + " " + gifu.getCourses().get(i).getName());
                    }
                    System.out.print("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                    int courseIndex = Integer.parseInt(scanner.nextLine());
                    Course course = gifu.getCourse(courseIndex);

                    for (int i = 0; i < gifu.getStudents().size(); i++) {
                        System.out.println(i + ") " + gifu.getStudents().get(i).getStudentNumber() + " " + gifu.getStudents().get(i).getName());
                    }
                    System.out.print("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                    int studentIndex = Integer.parseInt(scanner.nextLine());
                    Student student = gifu.getStudent(studentIndex);

                    gifu.addEnrollment(new Enrollment(student, course));
                    break;
                case 6:
                    for (int i = 0; i < gifu.getCourses().size(); i++) {
                        System.out.println(i + ") " + gifu.getCourses().get(i).getId() + " " + gifu.getCourses().get(i).getName());
                    }
                    System.out.print("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                    int courseToGradeIndex = Integer.parseInt(scanner.nextLine());
                    Course courseToGrade = gifu.getCourse(courseToGradeIndex);

                    for (Enrollment enrollment : gifu.getEnrollments()) {
                        if (enrollment.getCourse().equals(courseToGrade)) {
                            System.out.print("Anna arvosana opiskelijalle " + enrollment.getStudent().getStudentNumber() + " " + enrollment.getStudent().getName() + ": ");
                            int grade = Integer.parseInt(scanner.nextLine());
                            enrollment.setGrade(grade);
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < gifu.getCourses().size(); i++) {
                        System.out.println(i + ") " + gifu.getCourses().get(i).getId() + " " + gifu.getCourses().get(i).getName());
                    }
                    System.out.print("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                    int courseToListIndex = Integer.parseInt(scanner.nextLine());
                    Course courseToList = gifu.getCourse(courseToListIndex);

                    for (Enrollment enrollment : gifu.getEnrollments()) {
                        if (enrollment.getCourse().equals(courseToList)) {
                            System.out.println(enrollment.getStudent().getStudentNumber() + " " + enrollment.getStudent().getName() + ", arvosana:" + enrollment.getGrade());
                        }
                    }
                    break;
                case 8:
                    for (int i = 0; i < gifu.getStudents().size(); i++) {
                        System.out.println(i + ") " + gifu.getStudents().get(i).getStudentNumber() + " " + gifu.getStudents().get(i).getName());
                    }
                    System.out.print("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                    int studentToListIndex = Integer.parseInt(scanner.nextLine());
                    Student studentToList = gifu.getStudent(studentToListIndex);

                    System.out.println("Opiskelijan " + studentToList.getStudentNumber() + " " + studentToList.getName() + " arvosanat:");
                    for (Enrollment enrollment : gifu.getEnrollments()) {
                        if (enrollment.getStudent().equals(studentToList)) {
                            System.out.println(enrollment.getCourse().getId() + " " + enrollment.getCourse().getName() + ", arvosana:" + enrollment.getGrade());
                        }
                    }
                    break;
                case 9:
                    for (Course c : gifu.getCourses()) {
                        System.out.println(c.getId() + " " + c.getName());
                        for (Enrollment enrollment : gifu.getEnrollments()) {
                            if (enrollment.getCourse().equals(c)) {
                                System.out.println(enrollment.getStudent().getStudentNumber() + " " + enrollment.getStudent().getName() + ", arvosana:" + enrollment.getGrade());
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Virheellinen komento.");
            }
        }
    }
}
