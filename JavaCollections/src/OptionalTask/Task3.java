package OptionalTask;

// 3.   Создать список из элементов каталога и его подкаталогов.

import java.io.File;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();
        Queue<File> fileQueue = new LinkedList<>();
        File initFolder = new File("C:\\Users\\User\\Downloads");
        Collections.addAll(fileQueue, initFolder.listFiles());

        while (!fileQueue.isEmpty()) {
            File currentFile = fileQueue.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileQueue, currentFile.listFiles());
            } else {
                fileList.add(currentFile.getAbsolutePath());
            }
        }

        fileList.forEach(System.out::println);
    }
}
