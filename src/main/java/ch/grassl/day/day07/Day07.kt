package ch.grassl.day.day07

import ch.grassl.common.AdventOfCodeDay
import ch.grassl.day.day07.impl.FileStructure
import ch.grassl.day.day07.impl.importer.CommandLineImporter

private const val TOTAL_DISK_SPACE = 70000000
private const val UPDATE_FREE_SPACE = 30000000
private const val RESOURCE = "/day07.txt"

class Day07 : AdventOfCodeDay() {

    override fun run() {
        val commands = CommandLineImporter().importData(RESOURCE)
        val fs = FileStructure()
        fs.build(commands)
        result.add(fs.getSumOfAllDirectoriesSmallerThan(100000))
        result.add(fs.getSmallestDirectoryToDelete(TOTAL_DISK_SPACE, UPDATE_FREE_SPACE).getSize())
        printResult()
    }
}