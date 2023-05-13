
package bubble.sort;

import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class BubbleSort {

    static void BubbleSort(int[] a){
        boolean sort = true;
        for(int i=0; i < a.length - 1; i++){
            for (int j=0; j < a.length - 1 - i; j++ ){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    sort = false;
                }
            }   
        }
        if (sort){
            System.out.println("Perfect Array!");
            return;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array: ");
        int n = Validation.getInt();
        int[] arr = new int [n];
        
        for (int i=0; i < n; i++){
            arr[i] = Validation.getInt();
        } 
        
        System.out.println("Array: ");
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        
        BubbleSort(arr);
        System.out.println("\nSorted Array: ");
        
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
}
