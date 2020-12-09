package OptionalTask2;

//Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале
// значений от -M до M с помощью генератора случайных чисел (класс Random).
//4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static int matrixSize;
    public static int range;
    public static int maxElement;

    public static void main(String[] args) {
        int[][] matrix = createMatrixWithRandomValues();
        maxElement = findMaxElements(matrix);
        deleteRowsAndColumns(matrix, maxElement);
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

    static int findMaxElements(int[][] matrix) {
        int maxElement = matrix[matrixSize - 1][matrixSize - 1];
        for (int i = matrixSize - 1; i >= 0; i--) {
            for (int j = matrixSize - 1; j >= 0; j--) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
        return maxElement;
    }

    static void deleteRowsAndColumns(int[][] matrix, int maxElement) {
        int[][] updatedMatrix = new int[matrixSize - 1][matrixSize - 1];
        int REMOVE_ROW = 0;
        int REMOVE_COLUMN = 0;

        try {
            for (int i = 0; i < updatedMatrix.length; i++) {
                for (int j = 0; j < updatedMatrix.length; j++) {
                    if (matrix[i][j] == maxElement) {
                        maxElement = matrix[i][j];
                        REMOVE_ROW = i;
                        REMOVE_COLUMN = j;
                    }
                }
            }

            int p = 0;
            for (int i = 0; i < matrixSize; ++i) {
                if (i == REMOVE_ROW) {
                    continue;
                }
                int q = 0;
                for (int j = 0; j < matrixSize; ++j) {
                    if (j == REMOVE_COLUMN) {
                        continue;
                    }
                    updatedMatrix[p][q] = matrix[i][j];
                    ++q;
                }
                ++p;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, check bounds of array");
        }

        System.out.println("Max element: " + maxElement + ", row: " + REMOVE_ROW + ", column: " + REMOVE_COLUMN + "\n");

        System.out.println("========================Initial matrix==============================");
        printMatrix(updatedMatrix);
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
