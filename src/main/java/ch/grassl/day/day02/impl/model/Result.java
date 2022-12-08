package ch.grassl.day.day02.impl.model;

import lombok.Getter;

public enum Result {
    WIN(6), LOSS(0), DRAW(3);

    @Getter
    private final int score;

    Result(int score) {
        this.score = score;
    }
}
