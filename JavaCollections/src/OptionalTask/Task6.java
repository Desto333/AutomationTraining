package OptionalTask;

// 6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из
// класса Collections.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Task6 {
    public static void main(String[] args) {
        ArrayList<String> listOfString = new ArrayList<>();
        String text;

        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader("src\\OptionalTask\\textForTask8.txt"))) {
            while ((text = bufferedReader.readLine()) != null) {
                listOfString.add(text);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Collections.sort(listOfString, (string1, string2) -> string1.length() - string2.length());

        listOfString.forEach(System.out::println);
    }
}
