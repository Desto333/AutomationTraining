package mainTask;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class mainTaskRecursion {
    static File sourceFile;
    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws NoSuchFileException {
        sourceFile = new File(args[0]);
        processFile(sourceFile);
    }

    public static void processFile(File file) throws NoSuchFileException {
        if (file.exists() && file.isDirectory()) {
            createListOfFileAndDirectories(file);
            try (FileWriter fileWriter = new FileWriter("src\\resources\\treeView.txt")) {
                for (int i = 1; i < strings.size(); i++) {
                    fileWriter.write(strings.get(i) + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            createListOfFileAndDirectories(file);
        } else if (file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
            getTXTFileInfo(file);
        } else {
            throw new NoSuchFileException("Please, enter correct filepath!!");
        }
    }

    public static void createListOfFileAndDirectories(File sourceFile) {
        strings.add("");
        strings.add(getFileOrDirectoryNameWithPrefix(sourceFile));
        File[] files = sourceFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                createListOfFileAndDirectories(file);
            } else {
                strings.add(getFileOrDirectoryNameWithPrefix(file));
            }
        }
    }

    public static void getTXTFileInfo(File file) {
        long directoryQuantity = 0;
        long fileQuantity = 0;
        long totalLengthOfFileNames = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.startsWith("|-")) {
                    directoryQuantity++;
                } else if (line.startsWith("| ")) {
                    fileQuantity++;
                    totalLengthOfFileNames += line.trim().length();
                }
            }

            System.out.println("Total quantity of directories: " + directoryQuantity);
            System.out.println("Total quantity of files: " + fileQuantity);
            System.out.println("Average quantity of files in directory: " + (double) fileQuantity / directoryQuantity);
            System.out.println("Average file name length: " + (double) totalLengthOfFileNames / fileQuantity);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getFileOrDirectoryNameWithPrefix(File file) {
        StringBuilder stringBuilder = new StringBuilder("|");
        int depthLevel = Paths.get(file.getPath()).getNameCount() - Paths.get(sourceFile.getPath()).getNameCount() + 1;
        if (file.isDirectory()) {
            stringBuilder.append("-".repeat(depthLevel));
        } else {
            stringBuilder.append(" ".repeat(depthLevel));
        }
        return stringBuilder.toString() + file.getName();
    }
}
