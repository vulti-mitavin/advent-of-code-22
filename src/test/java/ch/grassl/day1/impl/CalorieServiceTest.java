package ch.grassl.day1.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalorieServiceTest {

    private final List<Elf> elves = ElfImporter.getInstance().importData("/day1_test.txt");
    private final CalorieService calorieService = new CalorieService(elves);

    @Test
    void findElfWithMostCalories() {
        Elf elfWithMostCalories = calorieService.findElfWithMostCalories();
        assertEquals(24000, elfWithMostCalories.getCalories());
    }

    @Test
    void findCalorieBuffer() {
        int calorieBuffer = calorieService.findCalorieBuffer();
        assertEquals(45000, calorieBuffer);
    }
}