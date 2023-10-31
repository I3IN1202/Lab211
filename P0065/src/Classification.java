
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
public class Classification {
    
    GetUserInputData data = new GetUserInputData();
    ArrayList<Student> listStudent = new ArrayList<>();
    
    void createStudent(ArrayList<Student> listStudent) {
        
        System.out.println("====== Management Student Program ======");
        //loop used to let user enter student data
        do {            
            String name = data.inputString("Name:");
            String classes = data.inputString("Classes:");
            double maths = data.inputDouble("Maths:", "Maths", 0, 10);
            double chemistry = data.inputDouble("Chemistry:", "Chemistry", 0, 10);
            double physics = data.inputDouble("Physics:", "Physics", 0, 10);
//            double avg = (maths + chemistry + physics)/3;
//            char type = 'A';
//            if (avg > 7.5) {
//                type = 'A';
//            } else if (avg >= 6 && avg <= 7.5) {
//                type = 'B';
//            } else if (avg >= 4 && avg < 6) {
//                type = 'C';
//            } else {
//                type = 'D';
//            }
            listStudent.add(new Student(name, classes, maths, chemistry, physics, 'A'));
            String userDecision = data.inputYN("Do you want to enter more student information?(Y/N):");
            if(userDecision.equals("N")) {
                break;
            }
        } while (true);
    }
    
    void averangeStudent (ArrayList<Student> listStudent){
        for (Student o : listStudent) {
            double avg = (o.getChemistryPoint() + o.getMathPoint() + o.getPhysicsPoint())/3;
            if (avg > 7.5) {
                o.setType('A');
            } else if (avg >= 6 && avg <= 7.5) {
                o.setType('B');
            } else if (avg >= 4 && avg < 6) {
                o.setType('C');
            } else {
               o.setType('D');
            }
        }
    }
    
    HashMap<String, Double> getPercentTypeStudent (ArrayList<Student> listStudent) {
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        double numberOfTypeA = 0;
        double numberOfTypeB = 0;
        double numberOfTypeC = 0;
        double numberOfTypeD = 0;
        //loop used to access each student in list
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getType() == 'A') {
                numberOfTypeA++;
            }
            if (listStudent.get(i).getType() == 'B') {
                numberOfTypeB++;
            }
            if (listStudent.get(i).getType() == 'C') {
                numberOfTypeC++;
            }
            if (listStudent.get(i).getType() == 'D') {
                numberOfTypeD++;
            }
        }
        getPercentTypeStudent.put("A", numberOfTypeA / listStudent.size());
        getPercentTypeStudent.put("B", numberOfTypeB / listStudent.size());
        getPercentTypeStudent.put("C", numberOfTypeC / listStudent.size());
        getPercentTypeStudent.put("D", numberOfTypeD / listStudent.size());
        return getPercentTypeStudent;
    }
    
    void display() {
        createStudent(listStudent);
        averangeStudent(listStudent);
        displayInformationStudent(listStudent);
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(listStudent);
        System.out.println("--------Classification Info -----");
        for (Map.Entry<String, Double> entry : getPercentTypeStudent.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + ": " + (value * 100) + "%");
        }
    }
    
    void displayInformationStudent(ArrayList<Student> listStudent){
        int i = 0;
        for (Student o : listStudent) {
            System.out.println("------Student " + (++i) + " info-------");
            System.out.println("Name: " + o.name);
            System.out.println("Classes: " + o.Classes);
//            double avg = (o.getChemistryPoint() + o.getMathPoint() + o.getPhysicsPoint()) / 3.0;
//            System.out.println("AVG: " + String.format("%.1f", avg)); // Sử dụng String.format để định dạng AVG
            System.out.println("AVG: " + (o.getChemistryPoint() + o.getMathPoint() + o.getPhysicsPoint())/3);
            System.out.println("Type: " + o.getType());
        }
    }
}
