package OptionalTask;

// 1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

import java.io.*;
import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> listOfString = new ArrayList<>();
        String text;

        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader("src\\OptionalTask\\textForTask1.txt"))) {
            while ((text = bufferedReader.readLine()) != null) {
                listOfString.add(text);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter("src\\OptionalTask\\textForTask1.txt"))) {
            for (int i = listOfString.size() - 1; i >= 0; i--) {
                bufferedWriter.write(listOfString.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
