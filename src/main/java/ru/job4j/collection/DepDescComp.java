package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int res = o2.compareTo(o1);
        String[] srt1 = o1.split("/");
        String[] srt2 = o2.split("/");
        int size = Math.min(srt1.length, srt2.length);
        int comp = srt2[0].compareTo(srt1[0]);
        if (comp == 0) {
            res = o1.compareTo(o2);
        } else if (size == 1) {
            res = o2.compareTo(o1);
        }
        return res;
    }
}