package linearsearch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = getInt("Enter number of array: ");
        int[] a = randomArray(n);
        int m = getInt("Enter search value: ");
        displayArray("The number: ", a);
        linearSearch(a, m);
//        displayIndex(a);
    }
    
    public static int getInt(String request) {
        Scanner sc = new Scanner(System.in);
        System.out.println(request);
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter positive integer!");
            }
        }
        return n;
    }
    
    private static int[] randomArray(int size) {
       Random rd = new Random();
       int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rd.nextInt(size);
        }
        return a;
    }
    
    public static void linearSearch(int[] a, int m) {
    boolean check = false;
    for (int i = 0; i < a.length; i++) {
        if (a[i] == m) {
            System.out.println("Found " + m + " at index: " + i);
            check = true;
        }
    }
        if (!check) {
        System.out.println("Not found in array!");
    }
}
    
    private static void displayArray(String request, int[] a){
        System.out.print(request);
        System.out.println(Arrays.toString(a));
    }
    
//    private static void displayIndex(int[] a){
//        int m = 0;
//        for (int i = 0; i < a.length; i++) {
//            System.out.println("Found " + m + " at index: " + i);
//        }
//    }
}
