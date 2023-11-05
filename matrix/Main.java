/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Display display = new Display();
        Validation validation = new Validation();
        int choice;
        do {
            display.DisplayMenu();
            choice = validation.getInt("Your choice: ", 1, 4);
            switch(choice){
                case 1: 
                    display.displayAddition();
                    break;
                case 2:
                    display.displaySubtraction();
                    break;
                case 3:
                    display.displayMultiplication();
                    break;
                case 4:
                    System.exit(0);
                    break;
                
            }
        }
        while (true);
    }
    
}
