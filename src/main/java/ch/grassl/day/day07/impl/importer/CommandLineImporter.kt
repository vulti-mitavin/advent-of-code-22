package ch.grassl.day.day07.impl.importer

import ch.grassl.common.Importer
import ch.grassl.day.day07.impl.model.COMMAND_PREFIX
import ch.grassl.day.day07.impl.model.ChangeDirectory
import ch.grassl.day.day07.impl.model.Command
import ch.grassl.day.day07.impl.model.ListDirectory
import java.lang.IllegalArgumentException

class CommandLineImporter : Importer<List<Command>> {

    override fun importData(resource: String): List<Command> {
        val data = Importer.read(resource)
        return mapToFileStructure(data)
    }

    private fun mapToFileStructure(data: Array<String>): List<Command> {
        val commands = ArrayList<Command>()
        for (i in data.indices) {
            if (data[i].startsWith(COMMAND_PREFIX)) {
                commands.add(createCommand(data, i))
            }
        }
        return commands
    }

    private fun createCommand(lines: Array<String>, i: Int): Command {
        val command = lines[i].split(" ")
        return when (command[1]) {
            "cd" -> ChangeDirectory(command[2])
            "ls" -> {
                val output = lines
                    .slice(i + 1 until lines.size)
                    .takeWhile { !it.startsWith(COMMAND_PREFIX) }
                ListDirectory(output)
            }
            else -> throw IllegalArgumentException("No Implementation for command: $command")
        }
    }
}