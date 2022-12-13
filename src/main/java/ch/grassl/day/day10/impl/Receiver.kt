package ch.grassl.day.day10.impl

import ch.grassl.day.day10.impl.model.Instruction

class Receiver(
    instructions: List<Instruction>
) {

    private val cpu: CPU = CPU()

    init {
        cpu.start(instructions)
    }

    fun sumSignalStrengths(): Int {
        return getSignalStrengths().values.sumOf { it }
    }

    fun getSignalStrengths(): Map<Int, Int> {
        val map = HashMap<Int, Int>()
        for (i in 20..220 step 40) {
            map[i] = cpu.stateAt(i) * i
        }
        return map
    }

    override fun toString(): String {
        var screen = "\n"
        for (i in 0 until cpu.getHistory().size step 40) {
            for (cycle in i until i + 40) {
                val screenPosition = if (cycle >= 40) cycle % 40 else cycle
                val range = IntRange(cpu.getHistory()[cycle].state - 1, cpu.getHistory()[cycle].state + 1)
                screen += if (range.contains(screenPosition)) "X" else "."
            }
            screen += "\n"
        }
        return screen.substring(0..screen.length - 2)
    }
}