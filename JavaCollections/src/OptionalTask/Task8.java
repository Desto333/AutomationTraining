package OptionalTask;

//8. Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром
// букв, считать одинаковыми. Использовать класс HashSet.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Task8 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        String text = "";

        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader("src\\OptionalTask\\textForTask8.txt"))) {
            while ((text = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(text, ".,!?:;()\"- \n");
                while (stringTokenizer.hasMoreTokens()) {
                    hashSet.add(stringTokenizer.nextToken().toLowerCase());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        hashSet.forEach(System.out::println);
    }
}
