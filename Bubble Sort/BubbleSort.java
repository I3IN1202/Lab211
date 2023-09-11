package bubble.sort;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Minh Huy
 */
public class BubbleSort {

    public static void BubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static int[] randomArrray(int size) {
        int[] a = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            a[i] += rd.nextInt(size);
        }
        return a;
    }

    
    public static void displayArray(String request, int[] a) {
        System.out.print(request);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: \n");
        int n = getInt();
        int[] a = randomArrray(n);

        
//        System.out.print("Unsorted array: ");
        displayArray("Unsorted array: ",a);

//        System.out.print("Sorted Array: ");
        BubbleSort(a);
        displayArray("Sorted array: ",a);

    }

        public static int getInt() {
        Scanner sc = new Scanner(System.in);
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
}
