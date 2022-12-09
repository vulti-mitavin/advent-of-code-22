package ch.grassl.day.day09

import ch.grassl.common.AdventOfCodeDay
import ch.grassl.day.day09.impl.Grid
import ch.grassl.day.day09.impl.importer.MoveImporter

class Day09 : AdventOfCodeDay() {

    companion object {
        const val RESOURCE = "/day09.txt"
    }

    override fun run() {
        val grid = Grid(MoveImporter().importData(RESOURCE), 1000)
        grid.applyMoves(false)
        result.add(grid.countVisited())
        printResult()
    }
}