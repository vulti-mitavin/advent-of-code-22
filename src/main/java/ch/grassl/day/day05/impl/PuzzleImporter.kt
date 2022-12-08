package ch.grassl.day.day05.impl

import ch.grassl.common.Importer
import java.util.*

class PuzzleImporter(
    private val numberOfStacks: Int,
    private val numberOfStackRows: Int,
    private val startIndexMoves: Int
) : Importer<CargoConfiguration> {

    override fun importData(resource: String): CargoConfiguration {
        val data = Importer.read(resource)
        return mapToCargoConfiguration(data)
    }

    private fun mapToCargoConfiguration(data: Array<String>): CargoConfiguration {
        val stacks = mapToStacks(data)
        val moves = mapToMoves(data)
        return CargoConfiguration(stacks, moves)
    }

    private fun mapToStacks(data: Array<String>): LinkedList<String> {
        val stacks = Array(numberOfStacks) { "" }
        data
            .takeWhile { data.indexOf(it) < numberOfStackRows }
            .map { datum ->
                var i = 0
                var stack = 0
                while (i < datum.length) {
                    if (' ' != datum[i]) {
                        val triple = datum.slice(i until i + 3)
                        if (triple.matches(Regex("\\[\\w]"))) {
                            stacks[stack] += triple[1].toString()
                        }
                    }
                    stack++
                    i += 4
                }
            }
        return LinkedList(stacks.toList())
    }

    private fun mapToMoves(data: Array<String>): LinkedList<Move> {
        val moves = LinkedList<Move>()
        data
            .slice(startIndexMoves until data.size)
            .map { it.split(" ") }
            .map {
                moves.add(
                    Move(it[1].toInt(), it[3].toInt() - 1, it[5].toInt() - 1)
                )
            }
        return moves
    }
}