package ch.grassl.day2.impl;

import lombok.Getter;

enum Result {
    WIN(6), LOSS(0), DRAW(3);

    @Getter
    private final int score;

    Result(int score) {
        this.score = score;
    }
}
