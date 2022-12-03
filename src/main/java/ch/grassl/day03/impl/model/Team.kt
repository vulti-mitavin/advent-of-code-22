package ch.grassl.day03.impl.model

class Team(private val rucksacks: List<Rucksack>) {

    /**
     * Finds the teams badge by removing the duplicates from all items of a rucksack. These items are combined and counted.
     *
     * @return The item that appears in every rucksack
     */
    fun findBadge(): Item {
        val teamItems: List<Item> = getCombinedTeamItems()
        val itemsCount: Map<Item, Int> = getItemsCount(teamItems)

        return itemsCount.entries
            .firstOrNull { it.value == rucksacks.size }
            .let {
                checkNotNull(it)
                it.key
            }
    }

    private fun getCombinedTeamItems(): List<Item> {
        return rucksacks
            .map { it.getInventory() }
            .map { HashSet(it) }
            .flatMap { it.toList() }
    }

    private fun getItemsCount(teamItems: List<Item>): Map<Item, Int> {
        return teamItems
            .groupingBy { it }
            .eachCount()
    }
}