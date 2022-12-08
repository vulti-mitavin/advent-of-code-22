package ch.grassl.day.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {

    @Test
    void testRun() {
        Day02 day02 = new Day02();
        day02.run();
        assertEquals("13809", day02.getResult().get(0).toString());
        assertEquals("12316", day02.getResult().get(1).toString());
    }
}