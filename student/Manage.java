/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ADMIN
 */
public class Manage {
    void menu(){
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
    }
    Validation validation = new Validation();
    
    //Allow users create new student
    void createStudent(int count, ArrayList<Student> list){
        if(count > 10){
            System.out.print("Do you want to continue (Y/N): ");
            if (!validation.checkInputYN()) {
                return;
            }
        }
        while (true) {            
            System.out.print("Enter id: ");
            String id = validation.checkInputString();
            System.out.print("Enter name student: ");
            String name = validation.checkInputString();
            if (!validation.checkID(list, id, name)) {
                System.err.println("Id has exist student. Please re-input");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = validation.checkInputString();
            System.out.print("Enter name course: ");
            String course = validation.checkInputCourse();
            if (validation.checkStudent(list, id, name, semester, course)) {
                list.add(new Student(id, name, semester, course));
                count++;
                System.out.println("Add student success.");
                return;
            }
            System.err.println("Duplicate.");
        }
    }
    
    ArrayList<Student> listStudentFindByName(ArrayList<Student> list){
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = validation.checkInputString();
        for (Student student : list) {
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }
    
    void findAndSort(ArrayList<Student> list){
        if (list.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(list);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist. ");
        } else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }
    
    Student getStudentByListFound(ArrayList<Student> listStudentFindByName){
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name", 
                "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10s%-15s%-15s%-15s\n", count, student.getStudentName(),
                    student.getSemester(), student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = validation.checkInputLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice-1);
    }
    
    ArrayList<Student> getListStudentById(ArrayList<Student> list, String id){
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    
    void updateOrDelete(int count, ArrayList<Student> list){
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter id: ");
        String id = validation.checkInputString();
        ArrayList<Student> listStudentFindByName = getListStudentById(list, id);
        
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not found");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if (validation.checkInputUD()) {
                System.out.print("Enter name student: ");
                String name = validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = validation.checkInputString();
                System.out.print("Enter name course: ");
                String course = validation.checkInputCourse();
                
                if (validation.checkStudent(list, id, name, semester, course)) {
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    System.err.println("Update success. ");
                }
                return;
            } else {
                list.remove(student);
                count--;
                System.err.println("Delete success.");
                return;
            }       
        }
    }
    
    void report(ArrayList<Student> list){
        if (list.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        
        ArrayList<Report> lr = new ArrayList<>();
        int size = lr.size();
        
        for (int i = 0; i < size; i++) {
            int total=0;
            for (Student student1 : list) {
                for (Student student2 : list) {
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
        
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-15s|%-15s|%-5d\n", lr.get(i).getStudentName(), lr.get(i).getCourseName(),
                            lr.get(i).getTotalCourse());
        }
    }
}
