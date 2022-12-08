package ch.grassl.day.day04.impl

import ch.grassl.day.day04.impl.model.Elf
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ElfTest {

    @Test
    fun testIncludesSectionRange() {
        assertTrue(Elf(2..5).isSectionRangeIncluding(Elf(3..4)))
    }

    @Test
    fun testIncludesSectionRange_2() {
        assertTrue(Elf(2..5).isSectionRangeIncluding(Elf(3..3)))
    }

    @Test
    fun testIncludesSectionRange_3() {
        assertTrue(Elf(3..3).isSectionRangeIncluding(Elf(3..3)))
    }

    @Test
    fun testDoesNotIncludeSectionRange_1() {
        assertFalse(Elf(2..5).isSectionRangeIncluding(Elf(1..4)))
    }

    @Test
    fun testDoesNotIncludeSectionRange_2() {
        assertFalse(Elf(1..5).isSectionRangeIncluding(Elf(2..9)))
    }

    @Test
    fun testDoesNotIncludesSectionRange_3() {
        assertFalse(Elf(3..3).isSectionRangeIncluding(Elf(2..5)))
    }

    @Test
    fun testOverlapsSectionRange_1() {
        assertTrue(Elf(1..3).isSectionRangeOverlapping(Elf(2..5)))
    }

    @Test
    fun testOverlapsSectionRange_2() {
        assertTrue(Elf(4..7).isSectionRangeOverlapping(Elf(2..5)))
    }

    @Test
    fun testOverlapsSectionRange_3() {
        assertTrue(Elf(2..8).isSectionRangeOverlapping(Elf(3..7)))
    }

    @Test
    fun testDoesNotOverlapsSectionRange_1() {
        assertFalse(Elf(1..3).isSectionRangeOverlapping(Elf(4..7)))
    }

    @Test
    fun testDoesNotOverlapsSectionRange_2() {
        assertFalse(Elf(3..7).isSectionRangeOverlapping(Elf(2..8)))
    }
}