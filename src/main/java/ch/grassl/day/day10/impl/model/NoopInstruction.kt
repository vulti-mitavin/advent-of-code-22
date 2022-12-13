package ch.grassl.day.day10.impl.model

import ch.grassl.day.day10.impl.CPU

class NoopInstruction : Instruction {

    override fun process(cpu: CPU) {
        // no operation
        cpu.endCycle()
    }
}