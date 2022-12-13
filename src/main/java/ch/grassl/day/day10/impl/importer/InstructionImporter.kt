package ch.grassl.day.day10.impl.importer

import ch.grassl.common.Importer
import ch.grassl.day.day10.impl.model.AddInstruction
import ch.grassl.day.day10.impl.model.Instruction
import ch.grassl.day.day10.impl.model.NoopInstruction
import java.lang.IllegalArgumentException

class InstructionImporter : Importer<List<Instruction>> {

    override fun importData(resource: String): List<Instruction> {
        val lines = Importer.read(resource)
        return mapToInstructions(lines)
    }

    private fun mapToInstructions(lines: Array<String>): List<Instruction> {
        return lines.map { line ->
            if (line == "noop") NoopInstruction() else {
                val split = line.split(" ")
                when (split[0]) {
                    "addx" -> AddInstruction(split[1].toInt())
                    else -> throw IllegalArgumentException()
                }
            }
        }
    }
}