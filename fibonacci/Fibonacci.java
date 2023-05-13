package fibonacci;

import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class Fibonacci {
    
    public static void main(String[] args) {
           System.out.println("The 45 sequence fibonacci: ");
           for (int i = 0; i < 45; i++){
               System.out.print(fibonacci(i) + " ");
           }       
}
    public static int fibonacci(int n){
        long f0 = 0;
        long f1 = 1;
        long fn = 1;
     
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            for (int i = 2 ; i < n; i++){
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }
        }
        return (int) fn;
    }
}

