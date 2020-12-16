package OptionalTask;

// 7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}».
// Проверить правильность расстановки скобок. Использовать стек.

import java.util.Stack;

public class Task7 {
    public static void main(String[] args) {
        String string = "({[]})";
        Stack<Character> stack = new Stack<>();

        stack.push(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{') {
                stack.push(string.charAt(i));
            } else if (string.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    break;
                }
            } else if (string.charAt(i) == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    break;
                }
            } else if (string.charAt(i) == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Correct order of brackets");
        } else {
            System.out.println("Wrong order of brackets");
        }
    }
}
