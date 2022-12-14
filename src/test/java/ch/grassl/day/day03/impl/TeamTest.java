package ch.grassl.day.day03.impl;

import ch.grassl.day.day03.impl.importer.ItemImporter;
import ch.grassl.day.day03.impl.model.Item;
import ch.grassl.day.day03.impl.model.Rucksack;
import ch.grassl.day.day03.impl.model.Team;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamTest {

    private final ItemImporter importer = new ItemImporter();
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