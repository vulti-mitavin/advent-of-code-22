package ch.grassl.day04

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day04Test {

    @Test
    fun testRun() {
        val day04 = Day04()
        day04.run()
        assertEquals(471, day04.result[0])
        assertEquals(888, day04.result[1])
    }
}