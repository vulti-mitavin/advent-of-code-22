package ch.grassl.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    @Test
    void restRun() {
        Day01 day01 = new Day01();
        day01.run();
        assertEquals(71124, day01.getResult().get(0));
        assertEquals(204639, day01.getResult().get(1));
    }
}