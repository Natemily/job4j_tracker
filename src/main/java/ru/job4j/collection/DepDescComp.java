package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] srt1 = o1.split("/");
        String[] srt2 = o2.split("/");
        int comp = srt2[0].compareTo(srt1[0]);
        return comp != 0 ? comp : o1.compareTo(o2);
    }
}