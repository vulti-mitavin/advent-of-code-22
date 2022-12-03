package ch.grassl.day03.impl;

import lombok.Builder;
import lombok.Getter;

import java.util.*;
import java.util.stream.Stream;

@Getter
@Builder
public class Rucksack {

    private List<Item> front;
    private List<Item> back;

    public Item findError() {
        Set<Item> uniqueFront = new HashSet<>(front);
        Set<Item> uniqueBack = new HashSet<>(back);
        return uniqueFront.stream()
                .filter(uniqueBack::contains)
                .findFirst()
                .orElse(null);
    }

    public List<Item> getInventory() {
        return Stream.concat(front.stream(), back.stream()).toList();
    }
}
