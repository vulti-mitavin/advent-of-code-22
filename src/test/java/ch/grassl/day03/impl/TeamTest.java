package ch.grassl.day03.impl;

import ch.grassl.common.Importer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    private final Importer<Rucksack> importer = ItemImporter.getInstance();
    private final List<Rucksack> rucksacks = importer.importData(ItemImporterTest.RESOURCE);

    @Test
    void testFindBadge_1() {
        Team team = new Team(Arrays.asList(rucksacks.get(0), rucksacks.get(1), rucksacks.get(2)));
        Item badge = team.findBadge();
        assertEquals(new Item('r'), badge);
    }

    @Test
    void testFindBadge_2() {
        Team team = new Team(Arrays.asList(rucksacks.get(3), rucksacks.get(4), rucksacks.get(5)));
        Item badge = team.findBadge();
        assertEquals(new Item('Z'), badge);
    }
}