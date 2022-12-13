package ch.grassl.day.day10.impl.model

import ch.grassl.day.day10.impl.CPU

class AddInstruction(private val operator: Int) : Instruction {

    override fun process(cpu: CPU) {
        cpu.endCycle()
        cpu.endCycle()
        cpu.state = cpu.state + operator
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AddInstruction

        if (operator != other.operator) return false

        return true
    }

    override fun hashCode(): Int {
        return operator
    }
}