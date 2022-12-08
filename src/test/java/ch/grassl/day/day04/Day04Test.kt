package ch.grassl.day.day04

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day04Test {

    @Test
    fun testRun() {
        val day04 = Day04()
        day04.run()
        assertEquals(471, day04.result[0])
        assertEquals(888, day04.result[1])
    }
}