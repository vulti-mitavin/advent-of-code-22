package ch.grassl.day.day09.impl

import ch.grassl.day.day09.impl.importer.MoveImporter
import ch.grassl.day.day09.impl.model.Direction
import ch.grassl.day.day09.impl.model.Move
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MoveImporterTest {

    companion object {
        const val RESOURCE = "/day09/day09_test.txt"
    }

    private val importer = MoveImporter()

    @Test
    fun importData() {
        val moves = importer.importData(RESOURCE)
        assertEquals(Move(Direction.R, 4), moves[0])
        assertEquals(Move(Direction.U, 4), moves[1])
        assertEquals(Move(Direction.L, 3), moves[2])
        assertEquals(Move(Direction.D, 1), moves[3])
    }
}