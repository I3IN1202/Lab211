package bubble.sort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class BubbleSort {

    static void BubbleSort(int[] a) {
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

    private static int[] createArrray(int size) {
        int[] a = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = rd.nextInt(100);
        }
        return a;
    }

    private static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.print(a[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        int n = Validation.getInt();
        int[] a = createArrray(n);

        System.out.println("Unsorted array: ");
        display(a);

        System.out.println("\nSorted Array: ");
        BubbleSort(a);
        display(a);

    }
}
