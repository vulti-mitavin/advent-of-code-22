package ch.grassl.day03.impl;

import ch.grassl.common.Importer;
import ch.grassl.day03.impl.importer.ItemImporter;
import ch.grassl.day03.impl.model.Rucksack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RucksackServiceTest {

    private final Importer<Rucksack> importer = new ItemImporter();
    private final List<Rucksack> rucksacks = importer.importData(ItemImporterTest.RESOURCE);
    private final RucksackService service = RucksackService.Companion.of(rucksacks);

    @Test
    void testFindPriorityScore() {
        int errorScore = service.findPriorityScore();
        assertEquals(157, errorScore);
    }

    @Test
    void testFindTeamPriorityScore() {
        int errorScore = service.findTeamPriorityScore();
        assertEquals(70, errorScore);
    }
}