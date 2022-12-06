package ch.grassl.day06

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day06Test {

    @Test
    fun testRun() {
        val day06 = Day06()
        day06.run()
        assertEquals(1544, day06.result[0])
        assertEquals(2145, day06.result[1])
    }
}