package ch.grassl.day.day01;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day.day01.impl.ElfService;
import ch.grassl.day.day01.impl.importer.ElfImporter;
import ch.grassl.day.day01.impl.model.Elf;

import java.util.List;

public class Day01 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day1.txt";

    @Override
    public void run() {
        List<Elf> elves = ElfImporter.getInstance().importData(RESOURCE);
        ElfService elfService = new ElfService(elves);

        Elf elf = elfService.findElfWithMostCalories();
        int calorieBuffer = elfService.findCalorieBuffer();

        getResult().add(elf.getCalories());
        getResult().add(calorieBuffer);
        printResult();
    }
}
