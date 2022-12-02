package ch.grassl.day1.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CalorieService {

    private final List<Elf> elves;

    public CalorieService(List<Elf> elves) {
        this.elves = elves;
    }

    public Elf findElfWithMostCalories() {
        sort();
        return elves.get(0);
    }

    public int findCalorieBuffer() {
        sort();
        return elves.stream()
                .limit(3)
                .mapToInt(Elf::getCalories)
                .sum();
    }

    private void sort() {
        elves.sort(Comparator.comparing(Elf::getCalories).reversed());
    }
}
