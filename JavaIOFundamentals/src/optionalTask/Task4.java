package optionalTask;

// Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        File file = new File("src\\resources\\fileForTask4.txt");
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(" ");
                StringBuilder stringBuilder = new StringBuilder();
                for (String word : words) {
                    if (word.length() > 2) {
                        stringBuilder.append(word.toUpperCase() + " ");
                    } else {
                        stringBuilder.append(word + " ");
                    }
                }
                list.add(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length() - 1);
            }

            try (FileWriter fileWriter = new FileWriter("src\\resources\\fileForTask4.txt")) {
                for (String line : list) {
                    fileWriter.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
