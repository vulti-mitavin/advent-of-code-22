package ch.grassl.day.day10

import ch.grassl.common.AdventOfCodeDay
import ch.grassl.day.day10.impl.Receiver
import ch.grassl.day.day10.impl.importer.InstructionImporter

class Day10 : AdventOfCodeDay() {

    companion object {
        const val RESOURCE = "/day10.txt"
    }

    override fun run() {
        val receiver = Receiver(InstructionImporter().importData(RESOURCE))
        result.add(receiver.sumSignalStrengths())
        result.add(receiver)
        printResult()
    }
}