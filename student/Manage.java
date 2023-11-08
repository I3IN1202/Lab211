/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Manage {
    ArrayList<Report> lr = new ArrayList<>();
    ArrayList<Student> ls = new ArrayList<>();
    Validation validation = new Validation();

    void menu() {
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
    }

    void createStudent() {
        String name, semester, course;
        
        while (true) {
            
            String id = validation.checkInputString("Enter id: ");
            name = validation.checkInputString("Enter name: ");
            semester = validation.checkInputString("Enter semester: ");
            course = validation.checkInputCourse("Enter course: ");
            
            if (validation.checkStudent(ls, id, name, semester, course)) {
                ls.add(new Student(id, name, semester, course));
            } else {
                System.out.println("It is existed");
            }
            
            if (ls.size() >= 10) {
                String yesorno = validation.inputYN("Do you want to continue(Y/N):");
                if (yesorno.equals("N")) {
                    break;
                }
            }
        }
    }

    ArrayList<Student> listStudentFindByName(ArrayList<Student> listStudent) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        String name = validation.checkInputString("Enter name to search: ");
        for (Student student : listStudent) {
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    void findAndSort() {
        if (ls.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(ls);
        if (listStudentFindByName.isEmpty()) {
            System.err.print("Not exist. ");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : listStudentFindByName) {
                System.out.println(student.toString());;
            }
        }
    }

    Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("====List student found====");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10s%-15s%-15s%-15s\n", count, student.getStudentName(),
                    student.getSemester(), student.getCourseName());
            count++;
        }
        System.out.print("Enter number student: ");
        int choice = validation.checkInputLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice-1);
    }

    ArrayList<Student> getListStudentById(ArrayList<Student> ls, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    void updateOrDelete() {
        String id = validation.checkInputString("Enter id: ");
        ArrayList<Student> listStudentFindByName = getListStudentById(ls,id);
        if (listStudentFindByName.isEmpty()) {
            System.out.println("Not found.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            if (validation.checkInputUD("Do you want update or delete(u/d)? ")) {
                while (true) {
                    String name = validation.checkInputString("Enter name: ");
                    String semester = validation.checkInputString("Enter semester: ");
                    String course = validation.checkInputCourse("Enter course: ");
                    if (!validation.checkStudent(ls, id, name, semester, course)) {
                        System.out.println("Duplicate");
                    } else {
                        if (!name.equalsIgnoreCase(student.getStudentName())) {
                            for (Student change_name : ls) {
                                if (change_name.getId().equals(id)) {
                                    change_name.setStudentName(name);
                                }
                            }
                        }
                        student.setId(id);
                        student.setStudentName(name);
                        student.setSemester(semester);
                        student.setCourseName(course);
                        return;
                    }
                }
            } else {
                ls.remove(student);
            }
        }
    }

    //
    void report() {
        if (ls.isEmpty()) {
            System.err.println("List empty");
            return;
        }

        int size = ls.size();

        for (int i = 0; i < size; i++) {
            for (Student student1 : ls) {
                int total = 0;
                for (Student student2 : ls) {
                    if (student1.getId().equalsIgnoreCase(student2.getId())
                            && student1.getCourseName().equalsIgnoreCase(student2.getCourseName())) {
                        total++;
                    }
                }
                if (validation.checkReport(lr, student1.getStudentName(), student1.getCourseName(), total)) {
                    lr.add(new Report(student1.getStudentName(), student1.getCourseName(), total));
                }
            }
        }
        System.out.println("==== Report ====");
        for (Report report : lr) {
            System.out.println(report);
        }
    }
    
    void test(){
        ls.add(new Student("1", "Pham Hoa", "Spring", "java"));
        ls.add(new Student("2", "Do Hiep", "Summer", ".net"));
        ls.add(new Student("4", "Nguyen huy", "Spring", "c/c++"));
        ls.add(new Student("3", "Pham uyên", "Spring", "java"));
        ls.add(new Student("5", "Do Quang", "Summer", ".net"));
        ls.add(new Student("9", "Nguyen vanh", "Spring", "c/c++"));
        ls.add(new Student("7", "Pham Trường", "Spring", "java"));
        ls.add(new Student("8", "Do hải", "Summer", ".net"));
        ls.add(new Student("6", "Nguyen anh", "Spring", "c/c++"));
    }

    void displayAll() {
        System.out.printf("%-5s%-15s%-15s%-15s\n", "ID","Student name", "semester", "Course Name");
        display(ls);
    }

    void display(ArrayList ls) {
        for (Object o : ls) {
            System.out.println(o);
        }
    }
}
