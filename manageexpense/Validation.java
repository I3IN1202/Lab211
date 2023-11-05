/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageexpense;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    
    int checkInput(String msg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= max && n >= min) {
                    break;
                }
                {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter in range " + min + ", " + max);
            }
        }
        return n;
    }

    double checkDouble(String msg, double min, double max) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("Must be greater than 0");
                } else if (min < n && n <= max) {
                    break;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter number!");
            }
        }
        return n;
    }

    Date getDate(String msg, String err, String format){
        SimpleDateFormat s = new SimpleDateFormat(format);
        Date date = null;
        s.setLenient(false);
        while (true) {            
            try {
                System.out.print(msg);
                String input = sc.nextLine();
                date = s.parse(input);
                break;
            } catch (ParseException e) {
                System.out.println(err);
            }
        }
        return date;
    }

    int checkIdExist(ArrayList<Expense> le, int id) {
        for (int i = 0; i < le.size(); i++) {
            if (le.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    String inputString(String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Try again!");
                continue;
            }
            break;
        } while (true);
        return input;
    }

    int inputInt(String msg){
        while (true) {            
            try {
                System.out.print(msg);
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Input again!");
            }
        }
    }
    
//    boolean checkExisted(ArrayList<Expense> le, String date, double amount, String content){
//        for (Expense e : le) {
//            if (date.equalsIgnoreCase(e.getDate())
//                    && amount == e.getAmount()
//                    && content.equalsIgnoreCase(e.getContent())) {
//                return false;
//            }
//        }
//        return true;
//    }
}
