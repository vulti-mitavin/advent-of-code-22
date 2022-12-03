package ch.grassl.day03.impl.importer

import ch.grassl.common.Importer
import ch.grassl.day03.impl.model.Item
import ch.grassl.day03.impl.model.Rucksack
import ch.grassl.util.ResourceReader

class ItemImporter : Importer<Rucksack> {

    override fun importData(resource: String?): List<Rucksack> {
        val rucksacks = ArrayList<Rucksack>()
        val lines = ResourceReader.of(resource).read()
        for (line in lines) {
            if (!line.isNullOrEmpty()) {
                rucksacks.add(
                    mapToRucksack(line)
                )
            }
        }
        return rucksacks
    }

    private fun mapToRucksack(line: String): Rucksack {
        val half = line.length / 2
        val itemsFront = line.substring(0, half)
        val itemsBack = line.substring(half)
        return Rucksack.Builder()
            .front(mapToItems(itemsFront))
            .back(mapToItems(itemsBack))
            .build()
    }

    private fun mapToItems(items: String): List<Item> {
        return items
            .map { Item(it) }
    }
}