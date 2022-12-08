package ch.grassl.day.day04.impl

import ch.grassl.day.day04.impl.importer.ElfImporter
import ch.grassl.day.day04.impl.model.Elf
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class ElfImporterTest {

    private lateinit var data: List<Pair<Elf, Elf>>

    companion object {
        const val RESOURCE = "/day04/day4_test.txt"
    }
    val importer = ElfImporter()

    @BeforeEach
    fun init() {
        data = importer.importData(RESOURCE)
    }

    @Test
    fun testImportData() {
        assertEquals(6, data.size)
    }

    @Test
    fun testImportedData() {
        assertEquals(Pair(Elf(2..4), Elf(6..8)), data[0])
        assertEquals(Pair(Elf(2..3), Elf(4..5)), data[1])
        assertEquals(Pair(Elf(5..7), Elf(7..9)), data[2])
        assertEquals(Pair(Elf(2..8), Elf(3..7)), data[3])
        assertEquals(Pair(Elf(6..6), Elf(4..6)), data[4])
        assertEquals(Pair(Elf(2..6), Elf(4..8)), data[5])
    }
}