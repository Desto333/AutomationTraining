package OptionalTask;

// 2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        long inputNumber = 0;
        StringBuilder tempString = new StringBuilder();

        try {
            inputNumber = scanner.nextLong();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }

        for (String digit : String.valueOf(inputNumber).split("")) {
            stack.push(digit);
        }

        while (!stack.isEmpty()) {
            tempString.append(stack.pop());
        }

        System.out.println(Long.parseLong(String.valueOf(tempString)));
    }
}
