package ch.grassl.day.day10.impl

import ch.grassl.day.day10.impl.model.Instruction
import java.util.*

class CPU(
    var state: Int = 1,
    private var number: Int = 1,
    private var history: LinkedList<CPU> = LinkedList<CPU>()
) {

    fun start(instructions: List<Instruction>) {
        for (instruction in instructions) {
            instruction.process(this)
            number++
        }
    }

    fun stateAt(cycle: Int): Int {
        return history[cycle - 1].state
    }

    fun endCycle() {
        history.add(
            CPU(this.state, this.number, LinkedList(this.history))
        )
    }

    fun getHistory(): List<CPU> {
        return history
    }
}