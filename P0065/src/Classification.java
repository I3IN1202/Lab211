
import java.util.ArrayList;
import java.util.HashMap;

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
    
    void createStudent(ArrayList<Student> listStudent) {
        
        System.out.println("====== Management Student Program ======");
        //loop used to let user enter student data
        do {            
            String name = data.inputString("Name:");
            String classes = data.inputString("Classes:");
            double maths = data.inputDouble("Maths:", "Maths", 0, 10);
            double chemistry = data.inputDouble("Chemistry:", "Chemistry", 0, 10);
            double physics = data.inputDouble("Physics:", "Physics", 0, 10);
            double avg = (maths + chemistry + physics)/3;
            char type;
            if (avg > 7.5) {
                type = 'A';
            } else if (avg >= 6 && avg <= 7.5) {
                type = 'B';
            } else if (avg >= 4 && avg < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            listStudent.add(new Student(name, classes, maths, chemistry, physics, type));
            String userDecision = data.inputYN("Do you want to enter more student information?(Y/N):");
            //compare equality of userDecision with N
            if(userDecision.equals("N")) {
                break;
            }
        } while (true);
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
    
}
