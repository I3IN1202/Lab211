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
    ArrayList<Student> ls = new ArrayList();
    
    int checkInputLimit(int min, int max){
        while(true){
            try {
                int choice = Integer.parseInt(sc.nextLine());
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
    
    String checkInputString(String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if(input.isEmpty()) {
                System.out.println("Input cannot be empty. Try again!");
                continue;
            }
            break;
        } while (true);
        return input;
    }
    
    String inputYN(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {    
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! try again");
                continue;
            }
            else if (!input.equals("Y") && !input.equals("N")){
                System.out.println("Input must be Y or N! Try again!");
            }
            break;
        } while (true);
        return input;
    }
    
    boolean checkInputUD(String msg){
        System.out.println(msg);
        while (true) {   
            String result = sc.nextLine();
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
    
    String checkInputCourse(String msg){
        System.out.print(msg);
        while (true) {  
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("java") 
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")){
                return result;
            }
            System.err.println("There are only three course: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }
    
    boolean checkStudent(ArrayList<Student> ls, String id, String studentName, String semester, String courseName){
        int size = ls.size();
        for (Student student : ls) {
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
    
    boolean checkIdExist(ArrayList<Student> ls ,String id, String name) {
    for (Student student : ls) {
      if (id.equalsIgnoreCase(student.getId())
              || !name.equalsIgnoreCase(student.getStudentName())) {
          return false;
      }
    }
    return true;
  }
}
