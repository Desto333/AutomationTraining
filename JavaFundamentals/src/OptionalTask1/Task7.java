package OptionalTask1;

//Задание. Ввести n чисел с консоли.
//7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task7 {
    public static void main(String[] args) {
        int[] numbers = createAndSaveInputNumbers(5);
        findNumberConsistingOfDifferentDigits(numbers);
    }

    static int[] createAndSaveInputNumbers(int numbersQuantity) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[numbersQuantity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    static void findNumberConsistingOfDifferentDigits(int[] numbers) {
        int numberWithDifferentDigits = 0;
        for (int number : numbers) {
            String[] initialArr = String.valueOf(Math.abs(number)).split("");
            Set<String> set = new LinkedHashSet<>(Arrays.asList(initialArr));
            String correctedNumber = String.join("", set.toArray(new String[set.size()]));
            if (String.valueOf(Math.abs(number)).equals(correctedNumber)) {
                numberWithDifferentDigits = number;
                break;
            }
        }
        System.out.println(numberWithDifferentDigits != 0
                ? "The number is: " + numberWithDifferentDigits : "There is no number with different digits");
    }
}
