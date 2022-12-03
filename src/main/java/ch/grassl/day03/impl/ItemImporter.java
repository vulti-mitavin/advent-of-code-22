package ch.grassl.day03.impl;

import ch.grassl.common.Importer;
import ch.grassl.util.ResourceReader;
import ch.grassl.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ItemImporter implements Importer<Rucksack> {

    public static ItemImporter getInstance() {
        return new ItemImporter();
    }

    @Override
    public List<Rucksack> importData(String resource) {
        String[] lines = ResourceReader.of(resource).read();
        return mapToRucksacks(lines);
    }

    private List<Rucksack> mapToRucksacks(String[] lines) {
        List<Rucksack> rucksacks = new ArrayList<>();
        for (String line : lines) {
            if (!Util.isEmpty(line)) {
                rucksacks.add(mapToRucksack(line));
            }
        }
        return rucksacks;
    }

    private Rucksack mapToRucksack(String line) {
        String itemsFront = line.substring(0, line.length() / 2);
        String itemsBack = line.substring(line.length() / 2);
        return Rucksack.builder()
                .front(mapToItems(itemsFront))
                .back(mapToItems(itemsBack))
                .build();
    }

    private static List<Item> mapToItems(String items) {
        return items.chars()
                .mapToObj(c -> (char) c)
                .map(Item::new)
                .toList();
    }
}
