package SMfinal.controller;

import java.util.ArrayList;

import SMfinal.common.*;
import SMfinal.view.*;
import SMfinal.model.*;

public class SchoolManagement extends Menu<String> {

    int id = 0;
    static String[] menu = { "Create", "Find and Sort", "Update/Delete", "Report", "Exit" };
    private StudentManager list = new StudentManager();
    private Library lib = new Library();
    Validation val = new Validation();

    public SchoolManagement() {
        super("Welcome to Student Management System", menu);
    }
    // --------------------------------------------------

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                list.addStudent(addStudent());
                break;
            case 2:
                searching();
                list.sort();
                list.display();
                break;
            case 3:
                int id = lib.getInt("Enter id: ", 0, this.id);
                String choice = lib.getString("Update/Delete(U/D)");
                if (choice.equals("U")) {
                    update(id);
                }
                if (choice.equals("D")) {
                    list.remove(id);
                }
                break;
            case 4:
                list.generateReport();
                break;
            case 5:
                System.exit(0);
        }
    }
    // --------------------------------------------------

    private void searching() {

        ArrayList<Student> rs = null;
        String input1;

        input1 = lib.getString("Enter student name:");

        rs = list.search(c -> (c.getStudentName().toUpperCase().contains(input1.toUpperCase())));

        if (rs != null) {
            list.display(rs);
        }

    }
    // ----------------------------------------------------------

    public Student addStudent() {
        id++;
        String studentName = lib.getString("Enter student name ");
        int semester = lib.getInt("Enter semester", 1, 9);
        String course = lib.getCourseName("Enter course Name ");
        return new Student(id, studentName, semester, course);
    }
    // --------------------------------------------------------

    private void update(int id) {
        String[] mu = { "Student name ", "Semester", "Course name", "Exit" };
        Menu m = new Menu("Update student", mu) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        String studentName = lib.getString("Enter new student name ");
                        for (Student student : list.list) {
                            if (student.getId() == id) {
                                student.setStudentName(studentName);
                                System.out.println(student);
                            }
                        }
                        break;
                    case 2:
                        int semester = lib.getInt("Enter new semester name ", 1, 9);
                        for (Student student : list.list) {
                            if (student.getId() == id) {
                                student.setSemester(semester);
                                System.out.println(student);
                            }
                        }
                        break;
                    case 3:
                        String course = lib.getCourseName("Enter course Name ");
                        for (Student student : list.list) {
                            if (student.getId() == id) {
                                student.setCourseName(course);
                                System.out.println(student);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Back to  main menu");
                    default:
                        return;
                }
            }
        };
        m.run();
    }

    // ------------------------------------------------------------------------------
    public static void main(String[] args) {
        SchoolManagement sc = new SchoolManagement();
        sc.run();
    }
}
