package ch.grassl.day03

import ch.grassl.common.AdventOfCodeDay
import ch.grassl.day03.impl.RucksackService
import ch.grassl.day03.impl.importer.ItemImporter

class Day03 : AdventOfCodeDay() {

    companion object {
        const val TEAM_SIZE = 3
        private const val RESOURCE = "/day3.txt"
    }
    private val rucksacks = ItemImporter().importData(RESOURCE)
    private val service = RucksackService.of(rucksacks)

    override fun run() {
        result.add(service.findPriorityScore())
        result.add(service.findTeamPriorityScore())
        printResult()
    }
}