package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.BufferedReader;
import ru.avalon.java.j20.labs.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Задание №3
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных с
 * использованием буферизованных типов данных".
 */
public class Task3 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        File output = new File("countries_buffered_mode_output.txt");
        Collection<String> lines = read(input);
        write(output, lines);
    }

    /**
     * Выполняет чтение указанного файла в коллекцию строк.
     *
     * <p>Каждый элемент коллекции представляет собой
     * отдельную строку файла.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private Collection<String> read(File file) throws IOException {
        try (FileReader reader = new FileReader(file);
             BufferedReader input = new BufferedReader(reader)) {
            Collection<String> buffer = new LinkedList<>();

            String line;
            while ((line = input.readLine()) != null) {
                buffer.add(line);
            }
            return new ArrayList<>(buffer);
        }
    }

    /**
     * Выполняет запись коллекции строковых элементов в файл.
     *
     * <p>Каждый элемент коллекции должен быть записан в
     * файл отдельной строкой.
     *
     * @param file файл
     * @param collection коллекция строк
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, Collection<String> collection) throws IOException {
        try (PrintWriter output = new PrintWriter(file)) {
            for (String line : collection) output.println(line);
        }
    }
}
