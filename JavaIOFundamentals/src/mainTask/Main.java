package mainTask;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        if (file.exists() && file.isDirectory()) {
            writeDirectoryTreeViewToFile(file);
        } else if (file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
            getTXTFileInfo(file);
        } else {
            throw new NoSuchFileException("Please, enter correct filepath!!");
        }
    }

    public static void writeDirectoryTreeViewToFile(File file) {
        try (FileWriter fileWriter = new FileWriter("src\\MainTask\\resources\\treeView.txt")) {
            ArrayDeque<Element> stack = new ArrayDeque<>();
            stack.add(new Element("-", file));
            while (!stack.isEmpty()) {
                Element element = stack.pollLast();
                fileWriter.write(element.toString() + "\n");
                if (element.getFile().isDirectory()) {
                    File[] files = element.getFile().listFiles();
                    for (int i = (files != null ? files.length : 0) - 1; i >= 0; i--) {
                        if (files != null && files[i].isDirectory()) {
                            stack.add(new Element(element.getPrefix() + "-", files[i]));
                        }
                        if (files != null && files[i].isFile()) {
                            int intend = Paths.get(files[i].getPath()).getNameCount() - Paths.get(file.getPath()).getNameCount();
                            StringBuilder intendCollector = new StringBuilder();
                            for (int j = 0; j <= intend; j++) {
                                intendCollector.append(" ");
                            }
                            fileWriter.write(intendCollector.toString() + files[i].getName() + "\n");
                        }
                        if (i == 0) {
                            fileWriter.write("\n");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void getTXTFileInfo(File file) {
        long directoryQuantity = 0;
        long fileQuantity = 0;
        long totalLengthOfFileNames = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.startsWith("-")) {
                    directoryQuantity++;
                } else if (line.startsWith(" ")) {
                    fileQuantity++;
                    totalLengthOfFileNames += line.trim().length();
                }
            }

            System.out.println("Total quantity of directories: " + directoryQuantity);
            System.out.println("Total quantity of files: " + fileQuantity);
            System.out.println("Average quantity of files in directory: " + (double) fileQuantity / directoryQuantity);
            System.out.println("Average file name length: " + (double) totalLengthOfFileNames / fileQuantity);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

class Element {
    private final String prefix;
    private final File file;

    public Element(String prefix, File file) {
        this.prefix = prefix;
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public String toString() {
        String result = " ";
        if (file.isDirectory()) {
            result = prefix + file.getName();
        }
        return result;
    }
}
