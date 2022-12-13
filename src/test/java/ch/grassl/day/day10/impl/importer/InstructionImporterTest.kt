package ch.grassl.day.day10.impl.importer

import ch.grassl.day.day10.impl.model.AddInstruction
import ch.grassl.day.day10.impl.model.NoopInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class InstructionImporterTest {

    companion object {
        const val RESOURCE_1 = "/day10/day10_test_1.txt"
        const val RESOURCE_2 = "/day10/day10_test_2.txt"
    }

    private val importer = InstructionImporter()

    @Test
    fun importData_1() {
        val instructions = importer.importData(RESOURCE_1)
        assertTrue(instructions[0] is NoopInstruction)
        assertEquals(AddInstruction(3), instructions[1])
        assertEquals(AddInstruction(-5), instructions[2])
    }

    @Test
    fun importData_2() {
        val instructions = importer.importData(RESOURCE_2)
        assertEquals(146, instructions.size)
    }
}