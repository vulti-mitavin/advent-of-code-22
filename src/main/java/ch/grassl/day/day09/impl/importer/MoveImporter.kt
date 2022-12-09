package ch.grassl.day.day09.impl.importer

import ch.grassl.common.Importer
import ch.grassl.day.day09.impl.model.Direction
import ch.grassl.day.day09.impl.model.Move
import java.util.LinkedList

class MoveImporter : Importer<LinkedList<Move>> {

    override fun importData(resource: String): LinkedList<Move> {
        val lines = Importer.read(resource)
        return mapToMoves(lines)
    }

    private fun mapToMoves(lines: Array<String>): LinkedList<Move> {
        return LinkedList(lines
            .map { it.split(" ") }
            .map { Move(Direction.valueOf(it[0]), it[1].toInt()) })
    }
}
