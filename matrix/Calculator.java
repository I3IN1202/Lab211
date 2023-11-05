/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author ADMIN
 */
public class Calculator {
    int[][] additionMatrix(int[][] matrix1, int[][] matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
                
            }
            
        }
        return result;
    }
    
    int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
                
            }
            
        }
        return result;
    }
    
    int[][] multiplication(int[][] matrix1, int[][] matrix2){
        int row1 = matrix1.length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    result[i][j] += matrix2[k][j] * matrix1[i][k] ;
                }
            }
            
        }
        return result;
    }
}
