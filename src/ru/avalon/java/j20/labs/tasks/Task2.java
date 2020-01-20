package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Задание №2
 *
 * <p>
 * Тема: "Потоковый ввод-вывод. Чтение и запись данных в текстовом режиме".
 */
public class Task2 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
          Path path = Paths.get("/home/sasha_deepin/Documents/lab-2-sashaspb09-develop/src/ru/avalon/java/j20/labs", "test.txt");
       File input = path.toFile();
        File output = new File("/home/sasha_deepin/Documents/lab-2-sashaspb09-develop/src/ru/avalon/java/j20/labs","countries_text_mode_output.txt");
     
        String text = read(input);
     //   System.out.println(text );
        write(output, text);
    }

    /**
     * Выполняет чтение указанного файла в текстовом режиме.
     *
     * <p>
     * Весь текст файла возвращается в виде одного экземпляра типа
     * {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        try (InputStream input = new FileInputStream(file);
                Reader reader = new InputStreamReader(input)) {
            StringBuilder text = new StringBuilder();
            char[] buffer = new char[16];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                      
                    text.append(buffer, 0, len);
            }
                         
        return text.toString();
        }
    }

    /**
     * Выполняет запись текстоых данных в файл в текстовом режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        }
    }
}
