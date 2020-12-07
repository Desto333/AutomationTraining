package OptionalTask1;

// Задание. Ввести n чисел с консоли.
// 5.Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int[] numbers = createAndSaveInputNumbers(5);
        findQuantityOfNumbersContainingOnlyEvenDigits(numbers);
        findQuantityOfNumbersWithEqualNumberOfOddAndEvenDigits(numbers);
    }

    static int[] createAndSaveInputNumbers(int numbersQuantity) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[numbersQuantity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    static void findQuantityOfNumbersContainingOnlyEvenDigits(int[] numbers) {
        int quantityOfNumbers = (int) Arrays.stream(numbers).filter(number ->
                String.valueOf(number).matches("(-)?[2468]+")).count();

        System.out.println("The quantity of numbers, containing only even digits: " + quantityOfNumbers);
    }

    static void findQuantityOfNumbersWithEqualNumberOfOddAndEvenDigits(int[] numbers) {
        int quantityOfNumbers = 0;
        for (int number : numbers) {
            int odd = 0;
            int even = 0;
            String numberAsString = String.valueOf(Math.abs(number));
            for (int i = 0; i < numberAsString.length(); i++) {
                if (Character.isDigit(numberAsString.charAt(i)) &&
                        Character.getNumericValue(numberAsString.charAt(i)) % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            if (odd == even) {
                quantityOfNumbers++;
            }
        }

        System.out.println("The quantity of numbers, containing equal amount of odd and even digits: " + quantityOfNumbers);
    }

}
