package OptionalTask2;

//Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале
// значений от -M до M с помощью генератора случайных чисел (класс Random).
//3.     Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static int matrixSize;
    public static int range;

    public static void main(String[] args) {
        int[][] matrix = createMatrixWithRandomValues();
        calculateSumOfElementsBetweenPositiveElementsOfRow(matrix);
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
        printMatrix(matrix);
        return matrix;
    }

    static void calculateSumOfElementsBetweenPositiveElementsOfRow(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrix[i][j] > 0) {
                    try {
                        for (int k = j + 1; matrix[i][k] <= 0 & k < matrixSize; k++) {
                            sum += matrix[i][k];
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Row #" + i + " doesn't have 2nd positive element");
                    }
                    System.out.println("row #" + i + ", sum: " + sum);
                    break;
                }
            }
        }
        System.out.println("The sum of elements between 1st and 2nd positive elements of each row is: " + sum);
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
