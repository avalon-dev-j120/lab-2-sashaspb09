package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.*;

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
        File input = new File("assets/countries.txt");
        File output = new File("countries_text_mode_output.txt");
        String text = read(input);
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
