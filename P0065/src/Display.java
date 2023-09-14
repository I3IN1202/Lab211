
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Display {

    void displayResult(ArrayList<Student> listStudent) {
        Classification classifier = new Classification();
        HashMap<Student, String> classifiedList = classifier.classifyStudent(listStudent);
        HashMap<String, Double> statistic = classifier.getPercentTypeStudent(listStudent);
        //loop used to access each student in list
        for (Student student : listStudent) {
            System.out.println("------ Student" + (listStudent.indexOf(student) + 1) + " Info ------");
            System.out.println("Name:" + student.getName());
            System.out.println("Classes:" + student.getClasses());
            System.out.printf("AVG:%.1f\n", (student.getChemistryPoint() + student.getMathPoint() + student.getPhysicsPoint())/3);
            System.out.println("Type:" + classifiedList.get(student));
        }
        System.out.println("--------Classification Info -----");
        //loop used to access each map entry in statistic
        for (Map.Entry<String, Double> entry : statistic.entrySet()) {
            String type = entry.getKey();
            Double percent = entry.getValue();
            System.out.println(type + ": " + (percent * 100) + "%");
        }
    }
    
}
