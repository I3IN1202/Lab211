/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerworker;

import java.util.ArrayList;
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
                System.out.println(msg);
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
                System.out.println(msg);
                n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    break;
                }
                {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
            }
        }
        return n;
    }

    Worker getWorker(String id, ArrayList<Worker> wList) {
          for (Worker o : wList) {
              if (o.getId().equals(id)) {
                  return o;
              }
        }
          return null;
    }

    String getCode(String msg, String err ,ArrayList<Worker> wList, int mode) {
        String s;
        while (true) {
            System.out.println(msg);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && getWorker(s, wList) == null)
                        || (mode == 2 && getWorker(s, wList) != null)) {
                    break;
                }
                System.err.println(err);
            }
        }
        return s;
    }
    
    String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
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
}
