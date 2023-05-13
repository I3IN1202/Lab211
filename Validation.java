/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.sort;

import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    static int getInt(){
        int n;
        while (true){
            try {
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e){
                   System.out.println("Please enter integer!");
            }
        } 
        
//        return n;
    }
}