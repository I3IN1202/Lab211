/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = getInt("Enter number of array: ");
        int[] a = {1,2,3,4,5,6,1,7};//randomArrray(n);
        int x = getInt("Enter search value: ");
        displayArray("Sorted array: ", a);
        int m = a.length;
        binarySearch(a, x, 0, m-1);
    }

    public static int getInt(String request) {
        Scanner sc = new Scanner(System.in);
        System.out.println(request);
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter positive integer!");
            }
        }
        return n;
    }

    public static int[] randomArrray(int size) {
        int[] a = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            a[i] += rd.nextInt(size);
        }
        return a;
    }

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

    
    public static int binarySearch(int[] a, int x, int low, int high) {
    if (high >= low) {
        int mid = low + (high - low) / 2;
        
        if (a[mid] == x) {
            System.out.println("Found " + x + " at index: " + mid);
        } else if (a[mid] > x) {
            return binarySearch(a, x, low, mid - 1);
        } else {
            return binarySearch(a, x, mid + 1, high);
        }
    } else {
        System.out.println("Not found in array!");
    }
    return -1;
}
    
    public static void displayArray(String request, int[] a) {
        System.out.print(request);
        BubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
