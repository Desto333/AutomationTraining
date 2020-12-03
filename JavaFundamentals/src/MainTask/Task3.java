package MainTask;

//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int outputQuantity = 10;

        for (int i = 0; i < outputQuantity; i++) {
            System.out.println(random.nextInt(100));
        }

        System.out.println();

        for (int i = 0; i < outputQuantity; i++) {
            System.out.print(random.nextInt(100) + "  ");
        }

    }
}
