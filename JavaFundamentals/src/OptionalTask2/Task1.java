package OptionalTask2;

// Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений
// от -M до M с помощью генератора случайных чисел (класс Random).
// 1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static int matrixSize;
    public static int range;

    public static void main(String[] args) {
        int[][] matrix = createMatrixWithRandomValues();
        sortMatrixByColumn(matrix, 2);
        sortMatrixByLine(matrix, 2);
    }

    static int[][] createMatrixWithRandomValues() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Please, enter the size of matrix");
        matrixSize = scanner.nextInt();
        System.out.println("Please, enter the range value (you should enter x to make range from -x to x)");
        range = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = random.nextInt((range * 2) + 1) - range;
            }
        }
        System.out.println("========================Initial matrix==============================");
        printMatrix(matrix);
        return matrix;
    }

    static void sortMatrixByLine(int[][] matrix, int rowIndex) {
        try {
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize - 1; j++) {
                    if (matrix[rowIndex][j + 1] < matrix[rowIndex][j]) {
                        for (int k = 0; k < matrixSize; k++) {
                            int temp = matrix[k][j];
                            matrix[k][j] = matrix[k][j + 1];
                            matrix[k][j + 1] = temp;
                        }
                    }
                }
            }
            System.out.println("======================Sorted by line #" + (rowIndex + 1) +
                    " matrix=====================");
            printMatrix(matrix);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Number of line to sort must be less than matrix size");
        }
    }

    static void sortMatrixByColumn(int[][] matrix, int columnIndex) {
        try {
            for (int i = 0; i < matrixSize; i++) {
                for (int k = i + 1; k < matrixSize; k++) {
                    if (matrix[i][columnIndex] > matrix[k][columnIndex]) {
                        for (int j = 0; j < matrixSize; j++) {
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[k][j];
                            matrix[k][j] = temp;
                        }
                    }
                }
            }
            System.out.println("======================Sorted by column #" + (columnIndex + 1) +
                    " matrix====================");
            printMatrix(matrix);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Number of column to sort must be less than matrix size");
        }
    }

    static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] array : matrix) {
            for (int anInt : array) {
                System.out.print(String.format("%4d", anInt));
            }
            System.out.println();
        }
        System.out.println();
    }
}
