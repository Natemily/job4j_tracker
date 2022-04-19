package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Students> levelOf(List<Students> students, int bound) {
        return students.stream()
                .filter(st -> st != null)
                .sorted(Comparator.reverseOrder())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}