package ch.grassl.day.day07.impl

import ch.grassl.day.day07.impl.model.*

private const val DELIMITER = "/"

class FileStructure(
    private val root: File = File(DELIMITER, FileType.DIRECTORY)
) {

    private var currentFile = root

    fun getCurrentPath(): String {
        return root.name + currentFile.getPath().joinToString(DELIMITER)
    }

    fun getFiles(): List<File> {
        return currentFile.getFiles()
    }

    fun getSize(): Int {
        return currentFile.getSize()
    }

    fun getAllDirectories(): ArrayList<File> {
        val dirs = ArrayList<File>()
        dirs.add(root)
        root.getAllDirectories(dirs)
        dirs.sortBy { it.getSize() }
        return dirs
    }

    fun getSmallestDirectoryToDelete(totalSize: Int, freeSpaceRequired: Int): File {
        val currentSize = root.getSize()
        val currentFreeSpace = totalSize - currentSize
        val dirMinSize = freeSpaceRequired - currentFreeSpace

        val dirs = getAllDirectories()

        if (dirMinSize > 0) {
            return dirs.first { it.getSize() >= dirMinSize }
        } else {
            return dirs[0]
        }
    }

    fun getSumOfAllDirectoriesSmallerThan(size: Int): Int {
        return getAllDirectories()
            .filter { it.getSize() <= size }
            .sumOf { it.getSize() }
    }

    fun build(commands: List<Command>) {
        commands.forEach { command ->
            if (command is ChangeDirectory) {
                navigate(command.arg)
            } else if (command is ListDirectory) {
                createFiles(command.output)
            }
        }
        root.calculateSize()
    }

    private fun navigate(arg: String) {
        if (".." == arg) {
            currentFile = if (currentFile.parent == null) root else currentFile.parent!!
        } else {
            if (arg.startsWith(DELIMITER)) {
                currentFile = root
                if (arg.length > 1) {
                    val path = arg.substring(1).split(DELIMITER)
                    navigate(path)
                }
            } else {
                val path = arg.split(DELIMITER)
                navigate(path)
            }
        }
    }

    private fun createFiles(lines: List<String>) {
        currentFile.addFiles(
            lines
                .map { it.split(" ") }
                .map {
                    if (it[0] == "dir") {
                        File(it[1], FileType.DIRECTORY, currentFile)
                    } else {
                        File(it[1], FileType.FILE, currentFile, it[0].toInt())
                    }
                }
        )
    }

    private fun navigate(path: List<String>) {
        for (p in path) {
            currentFile = currentFile.changeFolder(p)
        }
    }
}
