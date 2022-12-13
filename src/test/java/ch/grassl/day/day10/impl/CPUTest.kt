package ch.grassl.day.day10.impl

import ch.grassl.day.day10.impl.importer.InstructionImporter
import ch.grassl.day.day10.impl.importer.InstructionImporterTest.Companion.RESOURCE_1
import ch.grassl.day.day10.impl.importer.InstructionImporterTest.Companion.RESOURCE_2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CPUTest {

    private val importer = InstructionImporter()

    @Test
    fun start_1() {
        val instructions = importer.importData(RESOURCE_1)
        val cpu = CPU()
        cpu.start(instructions)
        assertEquals(-1, cpu.state)
        assertEquals(1, cpu.stateAt(1))
        assertEquals(1, cpu.stateAt(2))
        assertEquals(1, cpu.stateAt(3))
        assertEquals(4, cpu.stateAt(4))
        assertEquals(4, cpu.stateAt(5))
    }

    @Test
    fun start_2() {
        val instructions = importer.importData(RESOURCE_2)
        val cpu = CPU()
        cpu.start(instructions)
        assertEquals(240, cpu.getHistory().size)
    }
}