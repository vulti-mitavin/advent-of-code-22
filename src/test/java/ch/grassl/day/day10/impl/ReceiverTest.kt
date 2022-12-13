package ch.grassl.day.day10.impl

import ch.grassl.day.day10.impl.importer.InstructionImporter
import ch.grassl.day.day10.impl.importer.InstructionImporterTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReceiverTest {

    private val importer = InstructionImporter()

    @Test
    fun getSignalStrengths() {
        val instructions = importer.importData(InstructionImporterTest.RESOURCE_2)
        val receiver = Receiver(instructions)
        val signalStrengths = receiver.getSignalStrengths()
        assertEquals(420, signalStrengths.getValue(20))
        assertEquals(1140, signalStrengths.getValue(60))
        assertEquals(1800, signalStrengths.getValue(100))
        assertEquals(2940, signalStrengths.getValue(140))
        assertEquals(2880, signalStrengths.getValue(180))
        assertEquals(3960, signalStrengths.getValue(220))
    }


    @Test
    fun sumSignalStrengths() {
        val instructions = importer.importData(InstructionImporterTest.RESOURCE_2)
        val receiver = Receiver(instructions)
        println(receiver.toString())
        assertEquals(13140, receiver.sumSignalStrengths())
    }
}