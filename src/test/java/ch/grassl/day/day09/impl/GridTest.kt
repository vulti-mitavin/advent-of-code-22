package ch.grassl.day.day09.impl

import ch.grassl.day.day09.impl.importer.MoveImporter
import ch.grassl.day.day09.impl.model.State
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class GridTest {

    private val moves = MoveImporter().importData(MoveImporterTest.RESOURCE)
    private val gridSize = 20

    @Test
    fun testInit() {
        val grid = Grid(moves, gridSize)
        assertEquals(gridSize, grid.getFields().size)
        assertEquals(gridSize, grid.getFields()[0].size)
    }

    @Test
    fun testPrint() {
        val grid = Grid(moves, gridSize)
        print(grid)
        assertEquals(State.START, grid.getFields()[grid.getFields().size / 2][grid.getFields().size / 2].getState())
    }


    @Test
    fun testApplyMoves() {
        val grid = Grid(moves, gridSize)
        grid.applyMoves(true)
    }

    @Test
    fun testCountVisited() {
        val grid = Grid(moves, gridSize)
        grid.applyMoves()
        assertEquals(14, grid.countVisited())
    }
}