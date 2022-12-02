package ch.grassl.day1;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day1.impl.CalorieService;
import ch.grassl.day1.impl.Elf;
import ch.grassl.day1.impl.ElfImporter;

import java.util.List;

public class Day1 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day1.txt";

    @Override
    public void run() {
        List<Elf> elves = ElfImporter.getInstance().importData(RESOURCE);
        CalorieService calorieService = new CalorieService(elves);

        Elf elf = calorieService.findElfWithMostCalories();
        int calorieBuffer = calorieService.findCalorieBuffer();

        result.add(elf.getCalories());
        result.add(calorieBuffer);
        printResult();
    }
}
