
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
    
    HashMap<Student, String> classifyStudent (ArrayList<Student> listStudent) {
        HashMap<Student, String> classifiedList = new HashMap<>();
        //loop used to access each student in list
        for (Student student : listStudent) {
            double avg = (student.getChemistryPoint() + student.getMathPoint() + student.getPhysicsPoint()) / 3;
            String type;
            //compare less than avg with 4
            if(avg < 4) {
                type = "D";
            }//check avg in range of 4 to less than 6
            else if (4 <= avg && avg < 6) {
                type = "C";
            }//check avg in range of 6 to 7.5
            else if (6 <= avg && avg <= 7.5){
                type = "B";
            }
            else {
                type = "A";
            }
            classifiedList.put(student, type);
        }
        return classifiedList;
    }
    
    
    HashMap<String, Double> getPercentTypeStudent (ArrayList<Student> listStudent) {
        HashMap<Student, String> classifiedList = classifyStudent(listStudent);
        HashMap<String, Double> statistic = new HashMap<>();
        double numberOfTypeA = 0;
        double numberOfTypeB = 0;
        double numberOfTypeC = 0;
        double numberOfTypeD = 0;
        //loop used to access each student in list
        for (Student student : listStudent) {
            String type = classifiedList.get(student);
            //check value of type
            switch(type) {
                case "A":
                    numberOfTypeA++;
                    break;
                case "B":
                    numberOfTypeB++;
                    break;
                case "C":
                    numberOfTypeC++;
                    break;
                default:
                    numberOfTypeD++;
            }
        }
        statistic.put("A", numberOfTypeA / listStudent.size());
        statistic.put("B", numberOfTypeB / listStudent.size());
        statistic.put("C", numberOfTypeC / listStudent.size());
        statistic.put("D", numberOfTypeD / listStudent.size());
        return statistic;
    }
    
}
