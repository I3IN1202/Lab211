/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Student {
    String name;
    String Classes;
    double mathPoint, chemistryPoint, physicsPoint;
    char type;

    public Student() {
    }

    public Student(String name, String Classes, double mathPoint, double chemistryPoint, double physicsPoint, char type) {
        this.name = name;
        this.Classes = Classes;
        this.mathPoint = mathPoint;
        this.chemistryPoint = chemistryPoint;
        this.physicsPoint = physicsPoint;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return Classes;
    }

    public void setClasses(String Classes) {
        this.Classes = Classes;
    }
    

    public double getMathPoint() {
        return mathPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public double getChemistryPoint() {
        return chemistryPoint;
    }

    public void setChemistryPoint(double chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    public double getPhysicsPoint() {
        return physicsPoint;
    }

    public void setPhysicsPoint(double physicsPoint) {
        this.physicsPoint = physicsPoint;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }   
}
