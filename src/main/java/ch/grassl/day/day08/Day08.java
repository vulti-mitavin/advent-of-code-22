package ch.grassl.day.day08;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day.day08.impl.Grid;
import ch.grassl.day.day08.impl.GridImporter;

public class Day08 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day08.txt";

    @Override
    public void run() {
        Grid grid = GridImporter.of().importData(RESOURCE);
        getResult().add(grid.numberOfVisibleTrees());
        getResult().add(grid.findHighestScenicScore());
        printResult();
    }
}
