package ch.grassl.day05.impl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CargoConfigurationTest {

    private val importer = PuzzleImporter(3, 3, 5)

    @Test
    fun testApplyMoves9000() {
        val cargoConfig = importer.importData(PuzzleImporterTest.RESOURCE)
        cargoConfig.applyMoves(9000)
        assertEquals("C", cargoConfig.getStacks()[0])
        assertEquals("M", cargoConfig.getStacks()[1])
        assertEquals("ZNDP", cargoConfig.getStacks()[2])
    }


    @Test
    fun testPrintStack9000() {
        val cargoConfig = importer.importData(PuzzleImporterTest.RESOURCE)
        cargoConfig.applyMoves(9000)
        assertEquals("CMZ", cargoConfig.printStack())
    }

    @Test
    fun testApplyMoves9001() {
        val cargoConfig = importer.importData(PuzzleImporterTest.RESOURCE)
        cargoConfig.applyMoves(9001)
        assertEquals("M", cargoConfig.getStacks()[0])
        assertEquals("C", cargoConfig.getStacks()[1])
        assertEquals("DNZP", cargoConfig.getStacks()[2])
    }


    @Test
    fun testPrintStack9001() {
        val cargoConfig =
            importer.importData(PuzzleImporterTest.RESOURCE)
        cargoConfig.applyMoves(9001)
        assertEquals("MCD", cargoConfig.printStack())
    }
}