
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class GetUserInputData {

    double inputDouble(String msg, String type, double min, double max) {
        Scanner sc = new Scanner(System.in);
        String input;
        double doubleNum;
        //loop used to let user enter valid double in range
        do {
            System.out.print(msg);
            input = sc.nextLine();
            //check empty input
            if (input.isEmpty()) {
                System.out.println(type + " is digit");
            } else {
                try {
                    doubleNum = Double.parseDouble(input);
                    //compare less than of doubleNum with min
                    if (doubleNum < min) {
                        System.out.println(type + " is greater than equal zero");
                    } //comapre greater than of doubleNum with max
                    else if (doubleNum > max) {
                        System.out.println(type + " is less than equal ten");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(type + " is digit");
                }
            }
        } while (true);
        return doubleNum;
    }

    String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        //loop used to let user enter valid string
        do {            
            System.out.print(msg);
            input = sc.nextLine();
            //check empty input
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! try again");
                continue;
            }
            break;
        } while (true);
        return input;
    }

    String inputYN(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        //loop used to let user enter valid string
        do {    
            System.out.print(msg);
            input = sc.nextLine();
            //check empty input
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! try again");
                continue;
            }
            //check unequality input with Y and N
            else if (!input.equals("Y") && !input.equals("N")){
                System.out.println("Input must be Y or N! Try again!");
            }
            break;
        } while (true);
        return input;
    }
}
