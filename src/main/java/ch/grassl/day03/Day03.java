package ch.grassl.day03;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day03.impl.importer.ItemImporter;
import ch.grassl.day03.impl.model.Rucksack;
import ch.grassl.day03.impl.RucksackService;

import java.util.List;

public class Day03 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day3.txt";

    public static final int TEAM_SIZE = 3;

    private final List<Rucksack> rucksacks = ItemImporter.getInstance().importData(RESOURCE);
    private final RucksackService service = RucksackService.of(rucksacks);

    @Override
    public void run() {
        result.add(service.findPriorityScore());
        result.add(service.findTeamPriorityScore());
        printResult();
    }
}
