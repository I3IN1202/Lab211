package fibonacci;

import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class Fibonacci {
    
    public static void main(String[] args) {
           System.out.println("The 45 sequence fibonacci: ");
//           for (int i = 0; i < 45; i++){
               fibonacci(45, 1, 0);
 //          }       
}
    public static int fibonacci(int n, int f1, int f2){
        if (n < 2) 
            return f2;
        System.out.println(f2);
        return fibonacci(n-1, f2, f1 + f2);
    }
}
