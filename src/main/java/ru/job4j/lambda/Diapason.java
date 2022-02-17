package ru.job4j.lambda;
/**
 * 5. Подсчет функции в диапазоне.
 * @version 1.0
 * @author Dmitry Artamonov
 * @since 16.02.2022
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class Diapason {
    /**
     * Метод реализующий подсчет функции в диапазоне.
     * @param end - конец диапазонаю
     * @param start - начало диапазона.
     * @param func - функция.
     * @return - результат подсчета.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; end > i; i++) {
            result.add(func.apply(i));
        }
        return result;
    }
}
