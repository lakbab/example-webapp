package example.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lists {

    public static <T> List<T> create() {
        return new ArrayList<T>();
    }

    public static <T> List<T> create(int size) {
        return new ArrayList<T>(size);
    }

    public static <T> List<T> create(T... items) {
        List<T> list = create(items.length);
        Collections.addAll(list, items);
        return list;
    }

    public static <T> T first(List<T> list) {
        return first(list, null);
    }

    public static <T> T first(List<T> list, T defaultValue) {
        return isNotEmpty(list) ? list.get(0) : defaultValue;
    }

    public static boolean isEmpty(List<?> list) {
        return (list == null) || list.isEmpty();
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static <T> void each(Iterable<T> items, Closure<T> closure) {
        for (T item : items) {
            closure.execute(item);
        }
    }

    public static <T> List<T> select(Iterable<T> items, Matcher<T> matcher) {
        List<T> result = create();
        for (T item : items) {
            if (matcher.matches(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> List<T> reject(Iterable<T> items, Matcher<T> matcher) {
        List<T> result = create();
        for (T item : items) {
            if (!matcher.matches(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T, U> List<U> map(Iterable<T> items, Function<T, U> function) {
        List<U> result = create();
        for (T item : items) {
            result.add(function.execute(item));
        }
        return result;
    }

    public static <T, U> U reduce(Iterable<T> items, U initial, Reducer<T, U> reducer) {
        U result = initial;
        for (T item : items) {
            result = reducer.reduce(item, result);
        }
        return result;
    }
}
