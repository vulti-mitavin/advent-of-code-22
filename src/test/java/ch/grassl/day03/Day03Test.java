package ch.grassl.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    @Test
    void testRun() {
        Day03 day03 = new Day03();
        day03.run();
        assertEquals("7863", day03.getResult().get(0).toString());
        assertEquals("2488", day03.getResult().get(1).toString());
    }
}