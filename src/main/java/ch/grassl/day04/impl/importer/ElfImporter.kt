package ch.grassl.day04.impl.importer

import ch.grassl.common.Importer
import ch.grassl.day04.impl.model.Elf
import ch.grassl.util.ResourceReader

class ElfImporter : Importer<List<Pair<Elf, Elf>>> {

    override fun importData(resource: String): List<Pair<Elf, Elf>> {
        val lines = ResourceReader.of(resource).read()
        return mapToPairs(lines)
    }

    private fun mapToPairs(lines: Array<String>): List<Pair<Elf, Elf>> {
        return lines
            .map { line ->
                val section = line.split(",")
                section
                    .map { it.split("-") }
                    .map { IntRange(it[0].toInt(), it[1].toInt()) }}
            .map { Pair(Elf(it[0]), Elf(it[1])) }
    }
}