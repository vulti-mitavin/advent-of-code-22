package ch.grassl.day03.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @ParameterizedTest
    @CsvSource({"a, 1", "A, 27", "z, 26", "Z, 52", "p, 16", "P, 42", "g, 7", "G, 33"})
    void testItem(char c, int p) {
        Item item = new Item(c);
        assertEquals(p, item.getPriority());
    }
}