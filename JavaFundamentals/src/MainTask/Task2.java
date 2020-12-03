package MainTask;

// 2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.

import java.util.Arrays;
import java.util.Comparator;

public class Task2 {
    public static void main(String[] args) {
        Arrays.stream(args).sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }
}
