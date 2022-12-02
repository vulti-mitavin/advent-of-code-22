package ch.grassl.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void testRun() {
        Day2 day2 = new Day2();
        day2.run();
        assertEquals("13809", day2.getResult().get(0).toString());
        assertEquals("12316", day2.getResult().get(1).toString());
    }
}