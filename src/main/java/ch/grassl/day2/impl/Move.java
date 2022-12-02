package ch.grassl.day2.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Move {

    private final Shape opponentMove;
    private final Shape myMove;
    private final Result result;
    private final int score;

    public Move(Shape opponentMove, Result result) {
        this.opponentMove = opponentMove;
        this.result = result;
        this.myMove = getMyMove();
        this.score = calculateScore();
    }

    private int calculateScore() {
        return result.getScore() + myMove.getScore();
    }

    private Shape getMyMove() {
        if (opponentMove == Shape.ROCK) {
            return switch (result) {
                case WIN -> Shape.PAPER;
                case DRAW -> Shape.ROCK;
                case LOSS -> Shape.SCISSORS;
            };
        } else if (opponentMove == Shape.PAPER) {
            return switch (result) {
                case WIN -> Shape.SCISSORS;
                case DRAW -> Shape.PAPER;
                case LOSS -> Shape.ROCK;
            };
        } else if (opponentMove == Shape.SCISSORS) {
            return switch (result) {
                case WIN -> Shape.ROCK;
                case DRAW -> Shape.SCISSORS;
                case LOSS -> Shape.PAPER;
            };
        }
        throw new IllegalStateException("No Result rules for Shape: " + opponentMove);
    }
}
