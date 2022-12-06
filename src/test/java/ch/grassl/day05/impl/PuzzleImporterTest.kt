package ch.grassl.day05.impl

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PuzzleImporterTest {

    companion object {
        const val RESOURCE = "/day5_test.txt"
    }

    private val importer = PuzzleImporter(3, 3, 5)

    @Test
    fun testImportData_Stacks() {
        val cargoConfig = importer.importData(RESOURCE)
        assertEquals(3, cargoConfig.getStacks().size)
        assertEquals("NZ", cargoConfig.getStacks()[0])
        assertEquals("DCM", cargoConfig.getStacks()[1])
        assertEquals("P", cargoConfig.getStacks()[2])
    }

    @Test
    fun testImportData_Moves() {
        val cargoConfig = importer.importData(RESOURCE)
        assertEquals(5, cargoConfig.getMoves().size)
        assertEquals(Move(1, 1, 0), cargoConfig.getMoves()[0])
        assertEquals(Move(3, 0, 2), cargoConfig.getMoves()[1])
        assertEquals(Move(10, 2, 0), cargoConfig.getMoves()[2])
        assertEquals(Move(2, 1, 0), cargoConfig.getMoves()[3])
        assertEquals(Move(1, 0, 1), cargoConfig.getMoves()[4])
    }
}