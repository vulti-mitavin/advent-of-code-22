package ch.grassl.day01.impl;

import ch.grassl.day01.impl.importer.ElfImporter;
import ch.grassl.day01.impl.model.Elf;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElfServiceTest {

    private final List<Elf> elves = ElfImporter.getInstance().importData("/day01/day1_test.txt");
    private final ElfService elfService = new ElfService(elves);

    @Test
    void findElfWithMostCalories() {
        Elf elfWithMostCalories = elfService.findElfWithMostCalories();
        assertEquals(24000, elfWithMostCalories.getCalories());
    }

    @Test
    void findCalorieBuffer() {
        int calorieBuffer = elfService.findCalorieBuffer();
        assertEquals(45000, calorieBuffer);
    }
}