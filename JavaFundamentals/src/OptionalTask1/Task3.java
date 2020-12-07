package OptionalTask1;

// Ввести n чисел с консоли.
// 3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int[] numbers = createAndSaveInputNumbers(5);
        printNumbersWithLengthBelowAverage(numbers);
        System.out.println();
        printNumbersWithLengthAboveAverage(numbers);
    }

    static int[] createAndSaveInputNumbers(int numbersQuantity) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[numbersQuantity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    static double calculateAverageNumberLength(int[] numbers) {
        double sumOfNumbersLength = 0;
        for (int number : numbers) {
            sumOfNumbersLength += String.valueOf(number).length();
        }
        return sumOfNumbersLength / numbers.length;
    }

    static void printNumbersWithLengthAboveAverage(int[] numbers) {
        int[] filteredArray = Arrays.stream(numbers).filter(number -> String.valueOf(number).length() >
                calculateAverageNumberLength(numbers)).toArray();
        System.out.println("Numbers with length above average:");
        for (int number : filteredArray) {
            System.out.print(number + " - " + String.valueOf(number).length() + " ");
        }
    }

    static void printNumbersWithLengthBelowAverage(int[] numbers) {
        int[] filteredArray = Arrays.stream(numbers).filter(number -> String.valueOf(number).length() <
                calculateAverageNumberLength(numbers)).toArray();
        System.out.println("Numbers with length below average:");
        for (int number : filteredArray) {
            System.out.print(number + " - " + String.valueOf(number).length() + " ");
        }
    }
}
