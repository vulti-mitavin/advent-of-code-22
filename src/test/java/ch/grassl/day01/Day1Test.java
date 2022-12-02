package ch.grassl.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    void restRun() {
        Day1 day1 = new Day1();
        day1.run();
        assertEquals(71124, day1.getResult().get(0));
        assertEquals(204639, day1.getResult().get(1));
    }
}