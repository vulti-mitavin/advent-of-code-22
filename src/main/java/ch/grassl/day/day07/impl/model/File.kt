package ch.grassl.day.day07.impl.model

import java.util.*
import kotlin.collections.ArrayList

class File(
    val name: String,
    val type: FileType,
    val parent: File? = null,
    private var size: Int = 0,
    private val files: ArrayList<File> = ArrayList()
) {

    fun getFiles(): List<File> {
        return this.files
    }

    fun getSize(): Int {
        return this.size
    }

    fun getAllDirectories(dirs: ArrayList<File>): ArrayList<File> {
        for (file in directories()) {
            if (file.hasDirectory()) {
                file.getAllDirectories(dirs)
            }
            dirs.add(file)
        }
        return dirs
    }

    fun changeFolder(p: String): File {
        try {
            return files.first { it.name == p }
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("Error changing folder. File '$name' contains no File '$p'")
        }
    }

    fun getPath(path: LinkedList<String> = LinkedList()): LinkedList<String> {
        if (parent != null) {
            parent.getPath(path)
        } else {
            // don't include root
            return path
        }
        path.add(name)
        return path
    }

    fun addFiles(files: List<File>) {
        this.files.addAll(files)
    }

    fun calculateSize() {
        for (file in directories()) {
            if (file.hasDirectory()) {
                file.calculateSize()
            }
            file.size = file.files
                .sumOf { it.size }
        }
        size = files.sumOf { it.size }
    }

    private fun directories() = this.files.filter { it.type == FileType.DIRECTORY }

    private fun hasDirectory() = this.files.any { it.type == FileType.DIRECTORY }
}

