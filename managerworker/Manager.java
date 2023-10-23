/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerworker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Manager {
    private Scanner sc = new Scanner(System.in);
    Validation validation = new Validation();
    ArrayList<Worker> wList = new ArrayList<>();
    ArrayList<SalaryHistory> shList = new ArrayList<>();
    
    void addWorker(){
        String id, name, workLocation;
        int age;
        double salary;
        
        id = validation.getCode("Enter worker id: ","Id should be unique or not empty!",wList, 1);
        System.out.println("Enter worker name: ");
        name = sc.nextLine();
        age = validation.checkInput("Enter worker age: ", 18, 50);
        salary = validation.checkDouble("Enter worker salary: ", 0, Double.MAX_VALUE);
        System.out.println("Enter work location: ");
        workLocation = sc.nextLine();
        wList.add(new Worker(id, name, age, salary, workLocation));
    }
    
    void changeSalary(int mode){
        String id = validation.getCode("Enter worker id: ", "Id must exit in database or not null", wList, 2);
        double money = validation.checkDouble("Amount of money: ", 0, Double.MAX_VALUE);
        Worker o = validation.getWorker(id, wList);
        double update = 0;
        String status = "";
        
        if (mode == 1) {
            update = o.getSalary() + money;
            status = "UP";
        } else if (mode == 2) {
            update = o.getSalary() - money;
            status = "Down";
        }
        o.setSalary(update);
        shList.add(new SalaryHistory(id, o.getName(), o.getAge(), o.getSalary(), status, LocalDate.MAX));
    }
    
    void menu(){
        System.out.println("====== Worker Manager =====");
        System.out.println("1. Add Worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display Information Salary");
        System.out.println("5. Exit");
    }
    
    void displayTitle(int option) {
        //check value of option
        switch(option) {
            case 1:
                System.out.println("--------- Add Worker ----------");
                break;
            case 2:
                System.out.println("------- Up/Down Salary --------");
                break;
            case 3:
                System.out.println("------- Up/Down Salary --------");
                break;
            case 4:
                System.out.println("--------------------Display Information Salary-----------------------");
                break;
        }
    }
    
    void getInformationSalary(){
        display(shList);
    }
    
    void displayAll(){
        display(wList);
    }
            
    void display(ArrayList list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}