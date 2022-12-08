package ch.grassl.day.day07

import ch.grassl.day.day07.impl.importer.CommandLineImporter
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class CommandLineImporterTest {

    companion object {
        const val RESOURCE = "/day07/day07_test.txt"
    }

    private val importer = CommandLineImporter()

    @Test
    fun importData() {
        val commands = importer.importData(RESOURCE)
        assertNotNull(commands)
    }

    @Test
    fun importedData() {
        val commands = importer.importData(RESOURCE)
        assertEquals(10, commands.size)
    }
}