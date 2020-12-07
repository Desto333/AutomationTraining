package OptionalTask1;

// Задание. Ввести n чисел с консоли.
//  6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int[] numbers = createAndSaveInputNumbers(5);
        findNumberContainingIncreasingDigits(numbers);
    }

    static int[] createAndSaveInputNumbers(int numbersQuantity) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[numbersQuantity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    static void findNumberContainingIncreasingDigits(int[] numbers) {
        int numberWithIncreasingDigits = 0;
        for (int number : numbers) {
            String[] tempArr = String.valueOf(Math.abs(number)).split("");
            Arrays.sort(tempArr);
            String sortedNumber = String.join("", tempArr);
            if (String.valueOf(Math.abs(number)).equals(sortedNumber)) {
                numberWithIncreasingDigits = number;
                break;
            }
        }
        System.out.println(numberWithIncreasingDigits != 0
                ? "The number is: " + numberWithIncreasingDigits : "There is no number with increasing digits");
    }
}
