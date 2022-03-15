package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = 0;
        int size = left.length() <= right.length()
                ? left.length() - 1
                : right.length() - 1;
        for (int i = 0; i <= size; i++) {
            res = Character.compare(left.charAt(i), right.charAt(i));
            if (res != 0) {
                break;
            }
        }
        if (res == 0) {
            res = Integer.compare(left.length(), right.length());
        }
        return res;
    }
}