package ch.grassl.day.day06

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day06Test {

    @Test
    fun testRun() {
        val day06 = Day06()
        day06.run()
        assertEquals(1544, day06.result[0])
        assertEquals(2145, day06.result[1])
    }
}