package ch.grassl.day.day02;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day.day02.impl.Game;
import ch.grassl.day.day02.impl.importer.MoveImporter;
import ch.grassl.day.day02.impl.importer.StrategyImporter;

public class Day02 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day2.txt";

    @Override
    public void run() {
        getResult().add(new Game(MoveImporter.getInstance(), RESOURCE));
        getResult().add(new Game(StrategyImporter.getInstance(), RESOURCE));
        printResult();
    }
}
