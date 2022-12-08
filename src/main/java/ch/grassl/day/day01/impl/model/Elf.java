package ch.grassl.day.day01.impl.model;

import lombok.Getter;

public class Elf {

    @Getter
    private final int calories;

    public Elf(int calories) {
        this.calories = calories;
    }
}
