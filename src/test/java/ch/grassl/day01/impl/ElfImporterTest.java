package ch.grassl.day01.impl;

import ch.grassl.day01.impl.model.Elf;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElfImporterTest {

    private static final String RESOURCE = "/day1_test.txt";

    @Test
    void importElves_1() {
        List<Elf> elves = ElfImporter.getInstance().importData(RESOURCE);
        assertEquals(5, elves.size());
        assertEquals(6000, elves.get(0).getCalories());
        assertEquals(4000, elves.get(1).getCalories());
        assertEquals(11000, elves.get(2).getCalories());
        assertEquals(24000, elves.get(3).getCalories());
    }
}