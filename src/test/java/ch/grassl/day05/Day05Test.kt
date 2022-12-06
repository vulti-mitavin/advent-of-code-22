package ch.grassl.day05

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day05Test {

    @Test
    fun testRun() {
        val day05 = Day05()
        day05.run()
        assertEquals("BZLVHBWQF", day05.result[0])
        assertEquals("TDGJQTZSL", day05.result[1])
    }
}