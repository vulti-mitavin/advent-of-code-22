package ch.grassl.day04

import ch.grassl.common.AdventOfCodeDay
import ch.grassl.day04.impl.SectionService
import ch.grassl.day04.impl.importer.ElfImporter

class Day04 : AdventOfCodeDay() {

    companion object {
        const val RESOURCE = "/day4.txt"
    }

    override fun run() {
        val pairs = ElfImporter().importData(RESOURCE)
        result.add(SectionService.of(pairs).numberOfPairsWithEnclosingSections())
        result.add(SectionService.of(pairs).numberOfPairsWithOverlappingSections())
        printResult()
    }
}