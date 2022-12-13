package ch.grassl.day.day10

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day10Test {

    @Test
    fun run() {
        val day10 = Day10()
        day10.run()
        assertEquals(14060, day10.result[0])
    }
}