package OptionalTask1;

// Задание. Ввести n чисел с консоли.
// 2.     Вывести числа в порядке возрастания (убывания) значений их длины.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Integer[] numbers = createAndSaveInputNumbers(5);
        Arrays.stream(numbers).sorted(new SortNaturalOrder()).forEach(System.out::println);
        Arrays.stream(numbers).sorted(new SortReverseOrder()).forEach(System.out::println);
    }

    public static Integer[] createAndSaveInputNumbers(int numbersQuantity) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = new Integer[numbersQuantity];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }
}

class SortNaturalOrder implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (String.valueOf(o1).length() > String.valueOf(o2).length()) {
            return 1;
        } else if (String.valueOf(o1).length() < String.valueOf(o2).length()) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}

class SortReverseOrder implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (String.valueOf(o1).length() > String.valueOf(o2).length()) {
            return -1;
        } else if (String.valueOf(o1).length() < String.valueOf(o2).length()) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}
