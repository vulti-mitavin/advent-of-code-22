package ch.grassl.day03.impl;

import ch.grassl.common.Importer;
import ch.grassl.day03.impl.importer.ItemImporter;
import ch.grassl.day03.impl.model.Item;
import ch.grassl.day03.impl.model.Rucksack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemImporterTest {

    protected static final String RESOURCE = "/day3_test.txt";

    private final Importer<Rucksack> importer = ItemImporter.getInstance();
    private final List<Rucksack> rucksacks = importer.importData(RESOURCE);

    @Test
    void testImportData() {
        assertEquals(6, rucksacks.size());
    }

    @Test
    void testImportedData_1() {
        Rucksack rucksack = rucksacks.get(0);
        assertEquals(new Item('v'), rucksack.getFront().get(0));
        assertEquals(new Item('h'), rucksack.getBack().get(0));
        assertEquals(12, rucksack.getFront().size());
        assertEquals(12, rucksack.getBack().size());
    }

    @Test
    void testImportedData_2() {
        Rucksack rucksack = rucksacks.get(1);
        assertEquals(new Item('j'), rucksack.getFront().get(0));
        assertEquals(new Item('r'), rucksack.getBack().get(0));
        assertEquals(16, rucksack.getFront().size());
        assertEquals(16, rucksack.getBack().size());
    }

    @Test
    void testImportedData_3() {
        Rucksack rucksack = rucksacks.get(2);
        assertEquals(new Item('P'), rucksack.getFront().get(0));
        assertEquals(new Item('v'), rucksack.getBack().get(0));
        assertEquals(9, rucksack.getFront().size());
        assertEquals(9, rucksack.getBack().size());
    }

    @Test
    void testImportedData_4() {
        Rucksack rucksack = rucksacks.get(3);
        assertEquals(new Item('w'), rucksack.getFront().get(0));
        assertEquals(new Item('j'), rucksack.getBack().get(0));
        assertEquals(15, rucksack.getFront().size());
        assertEquals(15, rucksack.getBack().size());
    }

    @Test
    void testImportedData_5() {
        Rucksack rucksack = rucksacks.get(4);
        assertEquals(new Item('t'), rucksack.getFront().get(0));
        assertEquals(new Item('Q'), rucksack.getBack().get(0));
        assertEquals(8, rucksack.getFront().size());
        assertEquals(8, rucksack.getBack().size());
    }

    @Test
    void testImportedData_6() {
        Rucksack rucksack = rucksacks.get(5);
        assertEquals(new Item('C'), rucksack.getFront().get(0));
        assertEquals(new Item('w'), rucksack.getBack().get(0));
        assertEquals(12, rucksack.getFront().size());
        assertEquals(12, rucksack.getBack().size());
    }
}