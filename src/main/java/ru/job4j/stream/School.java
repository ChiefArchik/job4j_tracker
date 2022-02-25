package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        predict = x -> x.getScore() >= 50;
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
