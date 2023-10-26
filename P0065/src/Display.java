
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
    GetUserInputData data = new GetUserInputData();
    Classification classifier = new Classification();

    void display() {
        ArrayList<Student> ls = new ArrayList<>();
        classifier.createStudent(ls);
        displayInformationStudent(ls);
        HashMap<String, Double> getPercentTypeStudent = classifier.getPercentTypeStudent(ls);
        System.out.println("--------Classification Info -----");
        for (Map.Entry<String, Double> entry : getPercentTypeStudent.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + ": " + (value * 100) + "%");
        }
    }
    
    void displayInformationStudent(ArrayList<Student> ls){
        int i = 0;
        for (Student o : ls) {
            System.out.println("------Student " + (++i) + " info-------");
            System.out.println("Name: " + o.name);
            System.out.println("Classes: " + o.Classes);
            System.out.println("AVG: " + (o.getChemistryPoint() + o.getMathPoint() + o.getPhysicsPoint())/3);
            System.out.println("Type: " + o.getType());
        }
    }
}
