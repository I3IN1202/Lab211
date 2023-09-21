package fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class Fibonacci {

    public static void main(String[] args) {
        int[] a = new int[46];
        fibo(0, a, 45);
        display(a);
    }
    
    public static void fibo(int n, int[] a, int end){
        if (n < 2){
            a[n] = n;
        }else{
            a[n] = a[n-1] + a[n-2];
        }
        if(n < end){
            n++;
            fibo(n, a, end);
        }
    }
    
    public static void display(int[] a){
        System.out.println("The 45 sequence fibonacci: ");
        for(int i = 0; i < a.length - 1; i++){
              System.out.print(a[i]+", ");
        }
//       System.out.println((a[a.length-1]));
    }
}
