package ch.grassl.day2;

import ch.grassl.common.AdventOfCodeDay;
import ch.grassl.day2.impl.Game;

public class Day2 extends AdventOfCodeDay {

    private static final String RESOURCE = "/day2.txt";

    @Override
    public void run() {
        Game game = new Game(RESOURCE);
        result.add(game.getScore());
        printResult();
    }
}
