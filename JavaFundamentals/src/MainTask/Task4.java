package MainTask;

// 4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Сумма аргументов: " + Arrays.stream(args).mapToInt(Integer::parseInt).sum());
        System.out.println("Произведение аргументов: " + Arrays.stream(args).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b));
    }
}