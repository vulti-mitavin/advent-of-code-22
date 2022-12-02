package ch.grassl.day01.impl;

import ch.grassl.day01.impl.model.Elf;

import java.util.Comparator;
import java.util.List;

public class ElfService {

    private final List<Elf> elves;

    public ElfService(List<Elf> elves) {
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
