/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerworker;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation validation = new Validation();
        Manager manager = new Manager();

        while (true) {
            manager.menu();
            int choice = validation.checkInput("Enter your choice: ", 1, 6);
            switch (choice) {
                case 1:
                    manager.displayTitle(choice);
                    manager.addWorker();
                    break;
                case 2:
                    manager.displayTitle(choice);
                    manager.changeSalary(1);
                    break;
                case 3:
                    manager.displayTitle(choice);
                    manager.changeSalary(2);
                    break;
                case 4:
                    manager.displayTitle(choice);
                    manager.getInformationSalary();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

}
