/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageexpense;

import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Validation validation = new Validation();
        Manager manager = new Manager();
        int id = 0;
        while (true) {
            manager.menu();
            int choice = validation.checkInput("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    manager.addExpense();
                    break;
                case 2:
                    manager.displayAll();
                    break;
                case 3:
                    manager.displayAll();
                    manager.deleteExpense();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
