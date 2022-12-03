package ch.grassl.day02.impl;

import ch.grassl.common.Importer;
import ch.grassl.day02.impl.model.Move;

import java.util.List;

public class Game {

    private final List<Move> moves;

    public Game(List<Move> moves) {
        this.moves = moves;
    }

    public Game(Importer<Move> importer, String resource) {
        this.moves = importer.importData(resource);
    }

    public int getScore() {
        return moves.stream()
                .mapToInt(Move::getScore)
                .sum();
    }

    @Override
    public String toString() {
        return String.valueOf(getScore());
    }
}
