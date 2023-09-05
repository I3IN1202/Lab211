package fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Minh Huy
 */
public class Fibonacci {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();   
        // Step 1: Use recursion to find 45 sequence Fibonacci
        find45sequenceFibonacci(list, 0, true);
        // Step 2: Display to screen 45 sequence Fibonacci
        display(list);
    }

    // Use recursion to 45 sequence Fibonacci
    public static void find45sequenceFibonacci(ArrayList<Integer> list, int count, boolean check) {
      
        // compare number with 0 or 1
        if (count == 0 || count == 1) {
            list.add(count);
            if(check == false)
            System.out.println(" The number " + (count + 1) + " : " + list.get(count));
        } else {
            int number = list.get(count - 2) + list.get(count - 1);
            list.add(number);
            if(check == false)
            System.out.println(" The number " + (count + 1) + "  : " + list.get(count - 1)
                    + " + " + list.get(count - 2) + "  = " + list.get(count));
        }
        count++;
        // compare count with 45 to stop recursive
        if (count == 45) {
            return;
        }
        find45sequenceFibonacci(list, count, check);
    }
    
    
    //Display to screen 45 sequence Fibonacci
    public static void display(ArrayList<Integer> list) {
          
        System.out.println("The 45 sequence fibonacci: ");
        // loop use to access first element to before last element of array
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(list.get(list.size() - 1));
        
        getInput();
    }

    public static void getInput(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
    }
}
