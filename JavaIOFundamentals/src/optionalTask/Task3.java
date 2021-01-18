package optionalTask;

// 3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\resources\\fileForTask3.dat"))) {
            while (bufferedReader.ready()) {
                StringBuffer reverseString = new StringBuffer(bufferedReader.readLine());
                list.add(reverseString.reverse().toString());
            }
        } catch (IOException e) {
            e.getMessage();
        }

        try (FileWriter fileWriter = new FileWriter("src\\resources\\fileForTask3.dat")) {
            for (String string : list) {
                fileWriter.write(string + "\n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
