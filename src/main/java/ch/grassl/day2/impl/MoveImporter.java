package ch.grassl.day2.impl;

import ch.grassl.common.Importer;
import ch.grassl.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MoveImporter implements Importer<Move> {

    public static MoveImporter getInstance() {
        return new MoveImporter();
    }

    @Override
    public List<Move> importData(String resource) {
        String[] data = Importer.read(resource);
        return mapToMoves(data);
    }

    private static List<Move> mapToMoves(String[] data) {
        List<Move> moves = new ArrayList<>();
        for (String datum : data) {
            if (!Util.isEmpty(datum)) {
                moves.add(
                        mapToMove(datum)
                );
            }
        }
        return moves;
    }

    private static Move mapToMove(String datum) {
        String[] split = datum.split(" ");
        return new Move(getShape(split[0]), getShape(split[1]));
    }

    private static Shape getShape(String s) {
        return switch (s) {
            case "A", "X" -> Shape.ROCK;
            case "B", "Y" -> Shape.PAPER;
            case "C", "Z" -> Shape.SCISSORS;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}
