package ch.grassl.day06.impl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SignalReaderTest {

    companion object {
        val RESOURCES = listOf(
            "/day06/day6_test.txt",
            "/day06/day6_test_2.txt",
            "/day06/day6_test_3.txt",
            "/day06/day6_test_4.txt",
            "/day06/day6_test_5.txt"
        )
    }

    private val service = SignalReader()

    @ParameterizedTest
    @CsvSource("0, 7", "1, 5", "2, 6", "3, 10", "4, 11")
    fun testPacketStartIndex(case: Int, expectedIndex: Int) {
        val index = service.findMarker(RESOURCES[case], 4)
        assertEquals(expectedIndex, index)
    }

    @ParameterizedTest
    @CsvSource("0, 19", "1, 23", "2, 23", "3, 29", "4, 26")
    fun testMessageStartIndex(case: Int, expectedIndex: Int) {
        val index = service.findMarker(RESOURCES[case], 14)
        assertEquals(expectedIndex, index)
    }
}