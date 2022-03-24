package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (s, s1) -> map.put(s, s1);
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        int i = 1;
        for (String s : list) {
            biCon.accept(i++, s);
        }

        BiPredicate<Integer, String> biPred = (s, s1) -> (s % 2 == 0 || s1.length() == 4);
        for (Integer s : map.keySet()) {
            if (biPred.test(s, map.get(s))) {
                System.out.println("key: " + s + " value: " + map.get(s));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        List<String> strings = List.of("one", "two", "three", "one", "two", "three");
        for (String s : strings) {
            func.apply(s);
            con.accept(func.apply(s));
        }
    }
}