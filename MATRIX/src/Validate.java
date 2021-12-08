
import java.util.Scanner;
public class Validate {
    Scanner sc = new Scanner(System.in);
    public int getChoice(){
        int number = 0;
        System.out.print("Enter your choice: ");
        do{
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 1 && number > 4) {
                    System.out.print("Input number 1-4: ");
                    continue;
                }
            } catch (Exception e) {
                System.out.print("Please input valid number: ");
                continue;
            }
            break;
        }while(true);
        return number;
    }
    public void printMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }
     public int getNumber(int i, int j) {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        while (true) {
            try {
                System.out.format("Enter matrix[%d][%d]: ",i,j);
                id = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("please try again ");
                continue;
            }
            break;
        }
        return id;
    }
    public int[][] getMatrix(int row, int col){
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = getNumber(i, j);
            }
        }
        return matrix;
    }
     public int getSize(String mess) {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        while (true) {
            try {
                System.out.format(mess);
                id = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("please try again ");
                continue;
            }
            break;
        }
        return id;
    }
    public void add(){
        int row1 = getSize("Enter row of matrix 1: ");
        int col1 = getSize("Enter cols of matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        int row2 = 0;
        int col2 = 0;
        do{
            row2 = getSize("Enter row of matrix 2: ");
            if(row2 != row1){
                System.out.println("Row 2 must equal row 1:");
                continue;
            }
            col2 = getSize("Enter col of matrix 2: ");
            if(col2 != col1){
                System.out.println("Col 2 must equal col 1:");
                continue;
            }
            break;
        }while(true);
        int matrix2[][] = getMatrix(row2, col2);
        int matrix3[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Result: ");
        printMatrix(matrix1, row1, col1);
        System.out.println("+");
        printMatrix(matrix2, row1, col1);
        System.out.println("=");
        printMatrix(matrix3, row1, col1);
    }
     public void sub(){
        int row1 = getSize("Enter row of matrix 1: ");
        int col1 = getSize("Enter cols of matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        int row2 = 0;
        int col2 = 0;
        do{
            row2 = getSize("Enter row of matrix 2: ");
            if(row2 != row1){
                System.out.println("Row 2 must equal row 1:");
                continue;
            }
            col2 = getSize("Enter col of matrix 2: ");
            if(col2 != col1){
                System.out.println("Col 2 must equal col 1:");
                continue;
            }
            break;
        }while(true);
        int matrix2[][] = getMatrix(row2, col2);
        int matrix3[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        System.out.println("Result: ");
        printMatrix(matrix1, row1, col1);
        System.out.println("-");
        printMatrix(matrix2, row1, col1);
        System.out.println("=");
        printMatrix(matrix3, row1, col1);
    }
     public void multi(){
        int row1 = getSize("Enter row of matrix 1: ");
        int col1 = getSize("Enter cols of matrix 1: ");
        int matrix1[][] = getMatrix(row1, col1);
        int row2 = 0;
        int col2 = 0;
        do{
            row2 = getSize("Enter row of matrix 2: ");
            if(row2 != col1){
                System.out.println("row 2 must equal col 1:");
                continue;
            }
            col2 = getSize("Enter col of matrix 2: ");
            break;
        }while(true);
        int matrix2[][] = getMatrix(row2, col2);
        int matrix3[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
               for (int k = 0; k < row2; k++) {
                    matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("Result: ");
        printMatrix(matrix1, row1, col1);
        System.out.println("x");
        printMatrix(matrix2, row2, col2);
        System.out.println("=");
        printMatrix(matrix3, row1, col2);
    }
     public void printMatrix(int matrix[][], int row, int col){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
}
