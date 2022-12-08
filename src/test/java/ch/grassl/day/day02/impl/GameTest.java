package ch.grassl.day.day02.impl;

import ch.grassl.common.Importer;
import ch.grassl.day.day02.impl.importer.MoveImporter;
import ch.grassl.day.day02.impl.importer.StrategyImporter;
import ch.grassl.day.day02.impl.model.Move;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private static final String RESOURCE_2 = "/day02/day2_test_2.txt";

    private Importer<List<Move>> importer;

    @Test
    void testGetScoreWithStrategyImport() {
        importer = StrategyImporter.getInstance();
        List<Move> moves = importer.importData(StrategyImporterTest.RESOURCE);
        Game game = new Game(moves);
        assertEquals(12, game.getScore());
    }

    @Test
    void testGetScoreWithMoveImport() {
        importer = MoveImporter.getInstance();
        List<Move> moves = importer.importData(StrategyImporterTest.RESOURCE);
        Game game = new Game(moves);
        assertEquals(15, game.getScore());
    }

    @Test
    void testGetScoreWithStrategyImport_2() {
        importer = StrategyImporter.getInstance();
        List<Move> moves = importer.importData(RESOURCE_2);
        Game game = new Game(moves);
        assertEquals(31, game.getScore());
    }

    @Test
    void testGetScoreWithMoveImport_2() {
        importer = MoveImporter.getInstance();
        List<Move> moves = importer.importData(RESOURCE_2);
        Game game = new Game(moves);
        assertEquals(25, game.getScore());
    }
}