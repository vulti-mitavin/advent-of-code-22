package ch.grassl.day.day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day08Test {

    @Test
    void testRun() {
        Day08 day08 = new Day08();
        day08.run();
        assertEquals(1763, day08.getResult().get(0));
        assertEquals(671160, day08.getResult().get(1));
    }
}