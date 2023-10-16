/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    
    int checkInputLimit(int min, int max){
        while(true){
            try {
                int choice = Integer.getInteger(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]");
                System.out.println("Enter again: ");
            }
        }
    }
    
    String checkInputString(){
        while (true){
            String result = sc.nextLine().trim();
            if (result.isEmpty()){
                System.err.println("Not empty!");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    boolean checkInputYN(){
        while (true) {            
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")){
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y or N");
            System.out.println("Enter again: ");
        }
    }
    
    boolean checkInputUD(){
        while (true) {            
            String result = checkInputString();
            if (result.equalsIgnoreCase("U")){
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input U or D");
            System.out.println("Enter again: ");
        }
    }
    
    String checkInputCourse(){
        while (true) {            
            String result = checkInputString();
            if (result.equalsIgnoreCase("java") 
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")){
                return result;
            }
            System.err.println("There are only three course: Java, .Net, C/C++");
            System.out.println("Enter again: ");
        }
    }
    
    boolean checkStudent(ArrayList<Student> list, String id, String studentName, String semester, String courseName){
        int size = list.size();
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId()) 
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())){
                return false;
            }
        }
        return true;
    }
    
    boolean checkReport(ArrayList<Report> lr, String name, String course, int total){
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()){
                return false;
            }
        }
        return true;
    }
    
    boolean checkID(ArrayList<Student> list, String id, String studentName){
        for (Student student : list) {
            if(id.equalsIgnoreCase(student.getId())
                    && !studentName.equalsIgnoreCase(student.getStudentName())){
                return false;
            }
        }
        return true;
    }
}
