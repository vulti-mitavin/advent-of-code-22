package ch.grassl.day2.impl;

import ch.grassl.common.Importer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveImporterTest {

    public static final String RESOURCE = "/day2_test.txt";

    private final Importer<Move> importer = MoveImporter.getInstance();

    @Test
    void testImportData() {
        List<Move> moves = importer.importData(RESOURCE);
        assertEquals(3, moves.size());
    }

    @Test
    void testMoves() {
        List<Move> moves = importer.importData(RESOURCE);
        assertEquals(new Move(Shape.ROCK, Shape.PAPER), moves.get(0));
        assertEquals(new Move(Shape.PAPER, Shape.ROCK), moves.get(1));
        assertEquals(new Move(Shape.SCISSORS, Shape.SCISSORS), moves.get(2));
    }

    @Test
    void testMovesScore() {
        List<Move> moves = importer.importData(RESOURCE);
        assertEquals(8, moves.get(0).getScore());
        assertEquals(1, moves.get(1).getScore());
        assertEquals(6, moves.get(2).getScore());
    }
}