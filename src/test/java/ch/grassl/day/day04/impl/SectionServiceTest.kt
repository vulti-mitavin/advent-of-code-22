package ch.grassl.day.day04.impl

import ch.grassl.day.day04.impl.ElfImporterTest.Companion.RESOURCE
import ch.grassl.day.day04.impl.importer.ElfImporter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SectionServiceTest {

    val importer = ElfImporter()
    private lateinit var service: SectionService

    @Test
    fun testNumberOfPairsWithEnclosingSections() {
        service = SectionService.of(importer.importData(RESOURCE))
        assertEquals(2, service.numberOfPairsWithEnclosingSections())
    }

    @Test
    fun testNumberOfPairsWithEnclosingSections_2() {
        service = SectionService.of(importer.importData("/day04/day4_test_2.txt"))
        assertEquals(4, service.numberOfPairsWithEnclosingSections())
    }

    @Test
    fun testNumberOfPairsWithOverlappingSections() {
        service = SectionService.of(importer.importData(RESOURCE))
        assertEquals(4, service.numberOfPairsWithOverlappingSections())
    }

    @Test
    fun testNumberOfPairsWithOverlappingSections_2() {
        service = SectionService.of(importer.importData("/day04/day4_test_2.txt"))
        assertEquals(8, service.numberOfPairsWithOverlappingSections())
    }
}