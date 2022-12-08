package ch.grassl.day.day05

import ch.grassl.common.AdventOfCodeDay
import ch.grassl.day.day05.impl.PuzzleImporter

class Day05 : AdventOfCodeDay() {

    companion object {
        const val RESOURCE = "/day5.txt"
    }

    override fun run() {
        val cargoConfig9000 = PuzzleImporter(9, 8, 10).importData(RESOURCE)
        val cargoConfig9001 = PuzzleImporter(9, 8, 10).importData(RESOURCE)
        cargoConfig9000.applyMoves(9000)
        cargoConfig9001.applyMoves(9001)
        result.add(cargoConfig9000.printStack())
        result.add(cargoConfig9001.printStack())
        printResult()
    }
}