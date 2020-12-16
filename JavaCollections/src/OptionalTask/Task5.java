package OptionalTask;

// 5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец,
// а положительные — в начало списка.

import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>() {{
            add(10);
            add(-9);
            add(8);
            add(-7);
            add(6);
            add(-5);
            add(4);
            add(-3);
            add(2);
            add(-1);
        }};

        listOfNumbers.stream().sorted((x, y) -> y - x).forEach(System.out::println);
    }
}
