package ch.grassl.day1.impl;

import lombok.Getter;

public class Elf {

    @Getter
    private final int calories;

    public Elf(int calories) {
        this.calories = calories;
    }
}
