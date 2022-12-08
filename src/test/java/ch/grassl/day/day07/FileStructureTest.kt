package ch.grassl.day.day07

import ch.grassl.day.day07.CommandLineImporterTest.Companion.RESOURCE
import ch.grassl.day.day07.impl.model.ChangeDirectory
import ch.grassl.day.day07.impl.importer.CommandLineImporter
import ch.grassl.day.day07.impl.FileStructure
import ch.grassl.day.day07.impl.model.ListDirectory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class FileStructureTest {

    private var fs = FileStructure()

    @BeforeEach
    fun reset() {
        fs = FileStructure()
    }

    @Test
    fun processList_1() {
        val ls = ListDirectory(listOf(
            "dir A"
        ))
        fs.build(listOf(
            ls,
            ChangeDirectory("A")
        ))
        assertEquals("/A", fs.getCurrentPath())
    }

    @Test
    fun processList_2() {
        val ls = ListDirectory(listOf(
            "dir A",
            "dir B"
        ))
        fs.build(listOf(
            ls
        ))
        assertEquals(2, fs.getFiles().size)
    }

    @Test
    fun processList_3() {
        val ls = ListDirectory(listOf(
            "dir A",
            "123 fileA"
        ))
        fs.build(listOf(
            ls
        ))
        assertEquals(2, fs.getFiles().size)
    }

    @Test
    fun processList_4() {
        val ls = ListDirectory(listOf(
            "dir A",
            "123 fileA",
            "123 fileB"
        ))
        fs.build(listOf(
            ls
        ))
        assertEquals(3, fs.getFiles().size)
    }

    @Test
    fun processChangeDirRoot() {
        fs.build(listOf(ChangeDirectory("/")))
        assertEquals("/", fs.getCurrentPath())
    }

    @Test
    fun processChangeDirRelative_1() {
        val ls = ListDirectory(listOf(
            "dir A"
        ))
        fs.build(listOf(ls, ChangeDirectory("A")))
        assertEquals("/A", fs.getCurrentPath())
    }

    @Test
    fun processChangeDirRelative_2() {
        val lsA = ListDirectory(listOf(
            "dir A"
        ))
        val lsB = ListDirectory(listOf(
            "dir B"
        ))
        fs.build(listOf(lsA, ChangeDirectory("A"), lsB, ChangeDirectory("B")))
        assertEquals("/A/B", fs.getCurrentPath())
    }

    @Test
    fun processChangeDirRelative_3() {
        val lsA = ListDirectory(listOf(
            "dir A"
        ))
        val lsB = ListDirectory(listOf(
            "dir B"
        ))
        fs.build(listOf(lsA, ChangeDirectory("A"), lsB, ChangeDirectory("/"), ChangeDirectory("A/B")))
        assertEquals("/A/B", fs.getCurrentPath())
    }

    @Test
    fun processChangeDirAbsolute() {
        val lsA = ListDirectory(listOf(
            "dir A"
        ))
        val lsB = ListDirectory(listOf(
            "dir B"
        ))
        fs.build(listOf(lsA, ChangeDirectory("A"), lsB, ChangeDirectory("/A/B")))
        assertEquals("/A/B", fs.getCurrentPath())
    }

    @Test
    fun navigate() {
        val lsA = ListDirectory(listOf(
            "dir A"
        ))
        val lsB = ListDirectory(listOf(
            "dir B"
        ))
        fs.build(listOf(lsA, ChangeDirectory("A")))
        assertEquals("/A", fs.getCurrentPath())
        fs.build(listOf(lsB, ChangeDirectory("B")))
        assertEquals("/A/B", fs.getCurrentPath())
        fs.build(listOf(ChangeDirectory("..")))
        assertEquals("/A", fs.getCurrentPath())
        fs.build(listOf(ChangeDirectory("..")))
        assertEquals("/", fs.getCurrentPath())
        fs.build(listOf(ChangeDirectory("A/B")))
        assertEquals("/A/B", fs.getCurrentPath())
    }

    @Test
    fun fileSize_1() {
        val ls = ListDirectory(listOf(
            "dir A",
            "123 fileA"
        ))
        fs.build(listOf(
            ls
        ))
        assertEquals(123, fs.getSize())
    }

    @Test
    fun fileSize_2() {
        val ls = ListDirectory(listOf(
            "dir A",
            "123 fileA",
            "1000 fileA"
        ))
        fs.build(listOf(
            ls
        ))
        assertEquals(1123, fs.getSize())
    }

    @Test
    fun fileSize_3() {
        var ls = ListDirectory(listOf(
            "dir A",
            "123 fileA",
            "1000 fileA"
        ))
        fs.build(listOf(ls))
        assertEquals(3, fs.getFiles().size)
        assertEquals(1123, fs.getSize())

        ls = ListDirectory(listOf(
            "dir B",
            "100 fileC"
        ))
        fs.build(listOf(ls))
        assertEquals(5, fs.getFiles().size)
        assertEquals(1223, fs.getSize())
    }

    @Test
    fun getAllFilesBiggerThan_1() {
        val ls = ListDirectory(listOf(
            "dir A",
            "123 fileA",
            "1000 fileB"
        ))
        fs.build(listOf(ls))
        assertEquals(1123, fs.getSumOfAllDirectoriesSmallerThan(1500))
    }

    @Test
    fun getAllFilesBiggerThan_2() {
        var ls = ListDirectory(listOf(
            "dir A",
            "200 fileA",
            "1000 fileB"
        ))
        fs.build(listOf(ls, ChangeDirectory("A")))

        ls = ListDirectory(listOf(
            "123 fileC",
            "1000 fileD"
        ))
        fs.build(listOf(ls))

        assertEquals(1123, fs.getSumOfAllDirectoriesSmallerThan(1150))
    }

    @Test
    fun testInput_SumOfDirsSmallerThan() {
        val commands = CommandLineImporter().importData(RESOURCE)
        fs.build(commands)
        assertEquals(95437, fs.getSumOfAllDirectoriesSmallerThan(100000))
    }

    @Test
    fun testInput_AllDirs() {
        val commands = CommandLineImporter().importData(RESOURCE)
        fs.build(commands)
        val dirs = fs.getAllDirectories()
        assertEquals("e", dirs[0].name)
        assertEquals("a", dirs[1].name)
        assertEquals("d", dirs[2].name)
        assertEquals("/", dirs[3].name)
    }

    @Test
    fun testInput_SmallestDirToDelete() {
        val commands = CommandLineImporter().importData(RESOURCE)
        fs.build(commands)
        val dir = fs.getSmallestDirectoryToDelete(70000000, 30000000)
        assertEquals(24933642, dir.getSize())
        assertEquals("d", dir.name)
    }
}