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
        ArrayList<Student> ls = new ArrayList<>();
        Validation validation = new Validation();
        Manage manage = new Manage();
        ls.add(new Student("1", "Pham Hoa", "Spring", "java"));
        ls.add(new Student("2", "Do Hiep", "Summer", ".net"));
        ls.add(new Student("3", "Nguyen huy", "Spring", "c/c++"));
        ls.add(new Student("4", "Pham uyên", "Spring", "java"));
        ls.add(new Student("5", "Do Quang", "Summer", ".net"));
        ls.add(new Student("6", "Nguyen vanh", "Spring", "c/c++"));
        ls.add(new Student("7", "Pham Trường", "Spring", "java"));
        ls.add(new Student("8", "Do hải", "Summer", ".net"));
        ls.add(new Student("9", "Nguyen anh", "Spring", "c/c++"));
        
        while (true) {
            manage.menu();
            int choice = validation.checkInputLimit(1, 5);
            switch (choice) {
                case 1:
                    manage.displayAll();
                    manage.createStudent();
                    break;
                case 2:
                    manage.displayAll();
                    manage.findAndSort();
                    break;
                case 3:
                    manage.displayAll();
                    manage.updateOrDelete();
                    break;
                case 4:
                    manage.report();
                    break;
                case 5:
                    return;
            }
        }
    }
}
