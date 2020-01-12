package ch10.Exception.item76;

import java.util.*;
import java.util.stream.Collectors;

public class Code76 {


    public static Object pop(Object[] elements) {

        int size = elements.length;

        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
    public static void main(String[] args) {

        pop(args);

        Map<Object, Integer> tm = new TreeMap<>();
        Map<Object, Integer> tm2 = new TreeMap<>();
        tm.put("1", 1);
        tm.put("2", 2);
        tm.put("3", 3);
        tm.put(4,4);

        for (Object o : tm.values()) {
            System.out.println(o.toString());
        }

    }
}
