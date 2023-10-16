/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Validation validation = new Validation();
        Manage manage = new Manage();
        list.add(new Student("1", "Pham Ngoc Hoa", "Spring", "java"));
        list.add(new Student("2", "Do Quang Hiep", "Summer", ".net"));
        list.add(new Student("3", "Nguyen Xuan Cuong", "Spring", "c/c++"));
        
        int count = 3;
        while (true){
            manage.menu();
            int choice = validation.checkInputLimit(1, 5);
            switch (choice){
                case 1:
                    manage.createStudent(count, list);
                    break;
                case 2: 
                    manage.findAndSort(list);
                    break;
                case 3:
                    manage.updateOrDelete(count, list);
                    break;
                case 4:
                    manage.report(list);
                    break;
                case 5:
                    return;
            }        
        }
    }
    
}
