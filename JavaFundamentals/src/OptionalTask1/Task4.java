package OptionalTask1;

//  Задание. Ввести n чисел с консоли.
//  4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = createAndSaveInputNumbers(5);
        printFirstNumberWithMinimumDigits(findNumberOfMinimumDifferentDigits(numbers), numbers);

    }

    static int[] createAndSaveInputNumbers(int numbersQuantity) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[numbersQuantity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    static long findNumberOfMinimumDifferentDigits(int[] numbers) {
        long numberOfMinimalDigits = String.valueOf(numbers[0]).chars().distinct().count();
        for (int number : numbers) {
            long tempNumberOfMinimalDigits = String.valueOf(number).chars().distinct().count();
            if (tempNumberOfMinimalDigits < numberOfMinimalDigits) {
                numberOfMinimalDigits = tempNumberOfMinimalDigits;
            }
        }
        return numberOfMinimalDigits;
    }

    static void printFirstNumberWithMinimumDigits(long numberOfDigits, int[] numbers) {
        for (int number : numbers) {
            if (String.valueOf(number).chars().distinct().count() == numberOfDigits) {
                System.out.println(number);
                break;
            }
        }
    }
}
