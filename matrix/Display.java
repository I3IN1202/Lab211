/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Display {

    Validation validation = new Validation();
    Calculator calculator = new Calculator();
    Scanner sc = new Scanner(System.in);

    void DisplayMenu() {
        System.out.println("=====Calculator program====");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    int[][] getMatrix(int row, int column) {
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String message = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix[i][j] = validation.getMatrix(message);
            }
        }
        return matrix;
    }

    void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                System.out.format("[%d]", matrix[i][j]);
            }
            System.out.println();
        }
    }

    boolean displayAddition() {
        System.out.println("--------- Addition ------------");

        int row1 = validation.getInt("Enter row matrix1: ", 1, Integer.MAX_VALUE);
        int col1 = validation.getInt("Enter row matrix1: ", 1, Integer.MAX_VALUE);
        int[][] matrix1 = getMatrix(row1, col1);

        while (true) {
            int row2 = validation.getInt("Enter row matrix2: ", 1, Integer.MAX_VALUE);
            int col2 = validation.getInt("Enter row matrix2: ", 1, Integer.MAX_VALUE);

            if (row1 != row2 || col1 != col2) {
                System.out.println("Row and Col must be euqal");
            } else {
                int[][] matrix2 = getMatrix(row2, col2);
                System.out.println("------Result------");
                displayMatrix(matrix1);
                System.out.println("+");
                displayMatrix(matrix2);
                System.out.println("=");
                int[][] result = calculator.additionMatrix(matrix1, matrix2);
                displayMatrix(result);
                return true;
            }
        }
    }

    void displaySubtraction() {
        System.out.println("--------- Subtraction ------------");
    }

    void displayMultiplication() {
        System.out.println("--------- Multiplication ------------");
    }
}
