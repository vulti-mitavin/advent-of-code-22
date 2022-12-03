package ch.grassl.day03.impl;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Item {

    private static final int ASCII_START_INDEX_LOWER_CASE_ALPHABET = 96;
    private static final int ASCII_START_INDEX_UPPER_CASE_ALPHABET = 65;
    private static final int ALPHABET_SIZE = 26;

    private final char type;
    private final int priority;

    public Item(char type) {
        this.type = type;
        this.priority = calculatePriority();
    }

    private int calculatePriority() {
        if (this.type > ASCII_START_INDEX_LOWER_CASE_ALPHABET) {
            return this.type - ASCII_START_INDEX_LOWER_CASE_ALPHABET;
        } else {
            return this.type - ASCII_START_INDEX_UPPER_CASE_ALPHABET + ALPHABET_SIZE + 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return type == item.type && priority == item.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, priority);
    }
}
