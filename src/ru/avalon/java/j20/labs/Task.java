package ru.avalon.java.j20.labs;

/**
 * Абстрактное представление о задаче лабораторной работы.
 */
public interface Task {

    /**
     * Запускает задачу на исполнение.
     *
     * @throws Exception в случае возникновения в процессе
     * выполнения задания исключительной ситуации.
     */
    void run() throws Exception;
}
