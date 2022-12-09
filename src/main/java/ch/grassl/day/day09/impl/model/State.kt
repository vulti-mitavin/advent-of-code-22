package ch.grassl.day.day09.impl.model

enum class State(private val s: String) {
    START("s"), TAIL("T"), HEAD("H"), VISITED_BY_TAIL("X"), EMPTY(".");

    override fun toString(): String {
        return s
    }
}