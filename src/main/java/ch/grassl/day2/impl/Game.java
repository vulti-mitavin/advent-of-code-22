package ch.grassl.day2.impl;

import java.util.List;

public class Game {

    private final List<Move> moves;

    public Game(String resource) {
        this(MoveImporter.getInstance().importData(resource));
    }

    public Game(List<Move> moves) {
        this.moves = moves;
    }

    public int getScore() {
        return moves.stream()
                .mapToInt(Move::getScore)
                .sum();
    }
}
