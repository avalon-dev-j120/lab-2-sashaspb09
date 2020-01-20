package ru.avalon.java.j20.labs.tasks;

import java.io.ByteArrayOutputStream;
import ru.avalon.java.j20.labs.Task;
import java.nio.*;
import java.nio.file.*;

import java.io.*;

/**
 * Задание №1
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в двоичном режиме".
 */
public class Task1 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        
         
       Path path = Paths.get("/home/sasha_deepin/Documents/lab-2-sashaspb09-develop/src/ru/avalon/java/j20/labs", "test.txt");
       File input = path.toFile();
        File output = new File("/home/sasha_deepin/Documents/lab-2-sashaspb09-develop/src/ru/avalon/java/j20/labs","countries_binary_mode_output.txt");
        String text = read(input);
       // System.out.println(text);
        write(output, text);
    }

    /**
     * Выполняет чтение указанного файла в двоичном режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        try (InputStream input = new FileInputStream(file);
              ByteArrayOutputStream output = new ByteArrayOutputStream(16)) {

            byte[] buffer = new byte[16];
            int len;
            while ((len = input.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }

            byte[] bytes = output.toByteArray();
            return new String(bytes);
        }
    }

    /**
     * Выполняет запись текстоых данных в файл в двоичном
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
        byte[] bytes = text.getBytes();
        try (OutputStream output = new FileOutputStream(file)) {
                output.write(bytes);
                //3.2 37 min
        }
    }
}
