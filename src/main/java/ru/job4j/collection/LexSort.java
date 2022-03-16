package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] linesLeft = left.split(". ");
        String[] linesRight = right.split(". ");
        return Integer.compare(Integer.parseInt(linesLeft[0]),
                Integer.parseInt(linesRight[0]));
    }
}