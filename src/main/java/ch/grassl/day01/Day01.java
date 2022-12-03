package ch.grassl.day01;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day01.impl.ElfService;
import ch.grassl.day01.impl.model.Elf;
import ch.grassl.day01.impl.importer.ElfImporter;

import java.util.List;

public class Day01 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day1.txt";

    @Override
    public void run() {
        List<Elf> elves = ElfImporter.getInstance().importData(RESOURCE);
        ElfService elfService = new ElfService(elves);

        Elf elf = elfService.findElfWithMostCalories();
        int calorieBuffer = elfService.findCalorieBuffer();

        result.add(elf.getCalories());
        result.add(calorieBuffer);
        printResult();
    }
}
