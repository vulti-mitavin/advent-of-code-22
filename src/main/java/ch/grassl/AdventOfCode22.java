package ch.grassl;

import ch.grassl.common.AdventOfCodeDay;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdventOfCode22 {

    public static final String CLASSPATH = "ch.grassl";

    public static void main(String[] args) throws InstantiationException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Reflections reflections = new Reflections(CLASSPATH);

        // Get all days
        List<Class<? extends AdventOfCodeDay>> days = new ArrayList<>(reflections.getSubTypesOf(AdventOfCodeDay.class));
        days.sort(new AdventOfCodeDayClassComparator().reversed());
        // Run all days
        for (Class<? extends AdventOfCodeDay> day : days) {
            day.getDeclaredConstructor().newInstance().run();
        }
    }

    private static class AdventOfCodeDayClassComparator implements Comparator<Class<? extends AdventOfCodeDay>> {

        @Override
        public int compare(Class<? extends AdventOfCodeDay> o1, Class<? extends AdventOfCodeDay> o2) {
            return o1.getName().compareTo(o2.getName());
        }

        @Override
        public Comparator<Class<? extends AdventOfCodeDay>> reversed() {
            return Comparator.super.reversed();
        }
    }
}
