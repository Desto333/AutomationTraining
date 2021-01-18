package optionalTask;

// 2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src" +
                "\\resources\\fileForTask2.txt"))) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                list.add(string.replaceAll(" public ", " private "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter printWriter = new PrintWriter("src\\resources\\fileForTask2.txt")) {
            list.forEach(printWriter::println);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

