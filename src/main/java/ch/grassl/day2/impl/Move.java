package ch.grassl.day2.impl;

import lombok.Getter;

@Getter
public class Move {

    private final Shape opponentMove;
    private final Shape myMove;
    private final int score;

    public Move(Shape opponentMove, Shape myMove) {
        this.opponentMove = opponentMove;
        this.myMove = myMove;
        this.score = calculateScore();
    }

    private int calculateScore() {
        Result result = getResult();
        return result.getScore() + myMove.getScore();
    }

    private Result getResult() {
        if (myMove == Shape.ROCK) {
            if (opponentMove == Shape.ROCK) {
                return Result.DRAW;
            } else if (opponentMove == Shape.PAPER) {
                return Result.LOSS;
            } else {
                return Result.WIN;
            }
        } else if (myMove == Shape.PAPER) {
            if (opponentMove == Shape.PAPER) {
                return Result.DRAW;
            } else if (opponentMove == Shape.SCISSORS) {
                return Result.LOSS;
            } else {
                return Result.WIN;
            }
        } else if (myMove == Shape.SCISSORS) {
            if (opponentMove == Shape.SCISSORS) {
                return Result.DRAW;
            } else if (opponentMove == Shape.ROCK) {
                return Result.LOSS;
            } else {
                return Result.WIN;
            }
        }

        throw new IllegalStateException("No Result rules for Shape: " + myMove);
    }

    private enum Result {
        WIN(6), LOSS(0), DRAW(3);

        @Getter
        private final int score;

        Result(int score) {
            this.score = score;
        }
    }
}
