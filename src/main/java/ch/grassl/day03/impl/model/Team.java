package ch.grassl.day03.impl.model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Team {

    private final List<Rucksack> rucksacks;

    public Team(List<Rucksack> rucksacks) {
        this.rucksacks = rucksacks;
    }

    /**
     * Finds the teams badge by removing the duplicates from all items of a rucksack. These items are combined and counted.
     *
     * @return The item that appears in every rucksack
     */
    public Item findBadge() {
        List<Item> teamItems = getCombinedTeamItems();
        Map<Item, Long> itemsCount = getItemsCount(teamItems);

        return itemsCount.entrySet().stream()
                .filter(e -> e.getValue() == rucksacks.size())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Found no Badge for Team, but a Team has to have a Badge."))
                .getKey();
    }

    private List<Item> getCombinedTeamItems() {
        return rucksacks.stream()
                .map(Rucksack::getInventory)
                .map(HashSet::new)
                .flatMap(Set::stream)
                .toList();
    }

    private static Map<Item, Long> getItemsCount(List<Item> teamItems) {
        return teamItems.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
