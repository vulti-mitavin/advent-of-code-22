package ch.grassl.day02.impl.model;

import lombok.Getter;

public enum Shape {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    @Getter
    private final int score;

    Shape(int score) {
        this.score = score;
    }
}
