package OptionalTask;

// 5.     В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов,
// которые имеют средний балл более 7.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("src\\OptionalTask\\fileForTask5.txt"))) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                StringBuilder stringBuilder = new StringBuilder();
                int grade = Integer.parseInt(string.replaceAll("[^0-9]", ""));
                if (grade > 7) {
                    stringBuilder.append(string.substring(0, string.indexOf(" ")).toUpperCase()).append(" ").append(grade);
                } else {
                    stringBuilder.append(string, 0, string.indexOf(" ")).append(" ").append(grade);
                }
                students.add(stringBuilder.toString());
            }
        } catch (IOException e) {
            e.getMessage();
        }

        try (FileWriter fileWriter = new FileWriter("src\\OptionalTask\\fileForTask5.txt")) {
            for (String student : students) {
                fileWriter.write(student + "\n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
