package ch.grassl.day.day10.impl.model

import ch.grassl.day.day10.impl.CPU

interface Instruction {
    fun process(cpu: CPU)
}
