package optionalTask;

// Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        File file = new File("src\\resources\\fileForTask1.txt");

        writeRandomNumbersToFile(file);
        sortNumbersInFile(file);
    }

    public static void writeRandomNumbersToFile(File file) {
        Random random = new Random();

        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < 20; i++) {
                int randomNumber = random.nextInt();
                System.out.println(randomNumber);
                fileWriter.write(randomNumber + "\n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void sortNumbersInFile(File file) {
        List<Integer> listOfNumbers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                listOfNumbers.add(Integer.parseInt(bufferedReader.readLine()));
            }
        } catch (IOException e) {
            e.getMessage();
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            listOfNumbers.stream().sorted(Comparator.comparingInt(x -> x)).forEach(number -> {
                printWriter.print(number + "\n");
            });
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

