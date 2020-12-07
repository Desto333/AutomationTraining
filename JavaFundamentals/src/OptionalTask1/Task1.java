package OptionalTask1;

// Ввести n чисел с консоли.
//1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = createAndSaveInputNumbers(5);
        printShortestNumber(numbers);
        printLongestNumber(numbers);
    }

    static int[] createAndSaveInputNumbers(int numbersQuantity) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[numbersQuantity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    static void printShortestNumber(int[] numbers) {
        int minLength = String.valueOf(numbers[0]).length();
        int shortestNumber = numbers[0];
        for (int number : numbers) {
            if (String.valueOf(number).length() < minLength) {
                minLength = String.valueOf(number).length();
                shortestNumber = number;
            }
        }
        System.out.println("The shortest number is: " + shortestNumber + ". It's length is:  " + minLength);
    }

    static void printLongestNumber(int[] numbers) {
        int maxLength = 0;
        int longestNumber = 0;
        for (int number : numbers) {
            if (String.valueOf(number).length() > maxLength) {
                maxLength = String.valueOf(number).length();
                longestNumber = number;
            }
        }
        System.out.println("The longest number is: " + longestNumber + ". It's length is:  " + maxLength);
    }
}
