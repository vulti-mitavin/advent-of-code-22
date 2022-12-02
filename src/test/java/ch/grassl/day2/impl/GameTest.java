package ch.grassl.day2.impl;

import ch.grassl.common.Importer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private static final String RESOURCE_2 = "/day2_test_2.txt";

    private final Importer<Move> importer = MoveImporter.getInstance();

    @Test
    void testGetScore() {
        List<Move> moves = importer.importData(MoveImporterTest.RESOURCE);
        Game game = new Game(moves);
        assertEquals(15, game.getScore());
    }

    @Test
    void testGetScore_2() {
        List<Move> moves = importer.importData(RESOURCE_2);
        Game game = new Game(moves);
        assertEquals(25, game.getScore());
    }
}