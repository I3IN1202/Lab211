/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageexpense;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Manager {

    Validation validation = new Validation();
    ArrayList<Expense> le = new ArrayList<>();

    void menu() {
        System.out.println("====Handy Expense program=====");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }

    void addExpense() {
        int id = 1;
        if (!le.isEmpty()) {
            id = le.get(le.size() - 1).getId() + 1;
        }

        Date dateinput = validation.getDate("Enter date: ", "Date invalid", "dd/MM/yyyy");
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy");
        String date = s.format(dateinput);

        double amount = validation.checkDouble("Enter Amount: ", 0, Double.MAX_VALUE);
        String content = validation.inputString("Enter Content: ");
        le.add(new Expense(id, date, amount, content));
        System.out.println("Add success!");
    }

    void displayAll() {
        double total = 0;
        if (le.isEmpty()) {
            System.err.println("List empty!");
        }
        System.out.printf("%-5s%-15s%-20s%-15s\n", "ID", "Date", "Amount of money",
                "Content");
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-5s%-15s%-20s%-15s\n", le.get(i).getId(), le.get(i).getDate(), le.get(i).getAmount(),
                    le.get(i).getContent());
            total += le.get(i).getAmount();
        }
        System.out.printf("Total: %.2f\n", total);
    }

    void deleteExpense() {
        while (true) {
            int id = validation.inputInt("Enter id: ");
            int checkIdExist = validation.checkIdExist(le, id);
            if (checkIdExist != -1) {
                le.remove(checkIdExist);
                System.out.println("Delete an expense successful");
                for (int i = id - 1; i < le.size(); i++) {
                    le.get(i).setId(le.get(i).getId() - 1);
                }
                break;
            } else {
                System.err.println("Delete an expense fail");
            }
        }

    }
}
