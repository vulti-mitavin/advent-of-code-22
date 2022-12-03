package ch.grassl.day02;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day02.impl.Game;
import ch.grassl.day02.impl.importer.MoveImporter;
import ch.grassl.day02.impl.importer.StrategyImporter;

public class Day02 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day2.txt";

    @Override
    public void run() {
        result.add(new Game(MoveImporter.getInstance(), RESOURCE));
        result.add(new Game(StrategyImporter.getInstance(), RESOURCE));
        printResult();
    }
}
