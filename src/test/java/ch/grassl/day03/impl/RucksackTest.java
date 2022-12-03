package ch.grassl.day03.impl;

import ch.grassl.common.Importer;
import ch.grassl.day03.impl.importer.ItemImporter;
import ch.grassl.day03.impl.model.Item;
import ch.grassl.day03.impl.model.Rucksack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RucksackTest {

    private final Importer<Rucksack> importer = new ItemImporter();
    private final List<Rucksack> rucksacks = importer.importData(ItemImporterTest.RESOURCE);

    @ParameterizedTest
    @CsvSource({"0, p", "1, L", "2, P", "3, v", "4, t", "5, s"})
    void testFindError(int i, char c) {
        Rucksack rucksack = rucksacks.get(i);
        assertEquals(new Item(c), rucksack.findError());
    }

    @Test
    void testGetInventory() {
        Rucksack rucksack = rucksacks.get(0);
        assertEquals(24, rucksack.getInventory().size());
        assertEquals(new Item('v'), rucksack.getInventory().get(0));
        assertEquals(new Item('p'), rucksack.getInventory().get(rucksack.getInventory().size() - 1));
    }
}