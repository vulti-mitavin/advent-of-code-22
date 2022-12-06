package ch.grassl.day06.impl

import ch.grassl.util.ResourceReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun <T> Array<T>.pop(item: T) {
    for (i in 0 until this.size - 1) {
        this[i] = this[i + 1]
    }
    this[this.size - 1] = item
}

class SignalReader {

    fun findMarker(resource: String, sequenceSize: Int): Int {
        val uri = ResourceReader::class.java.getResource(resource)?.toURI()

        if (uri != null) {
            try {
                FileReader(File(uri)).use { return findLastIndexOfUniqueCharacterSequence(it, sequenceSize) }
            } catch (e: IOException) {
                return -1
            }
        } else {
            return -1
        }
    }

    private fun findLastIndexOfUniqueCharacterSequence(stream: FileReader, sequenceSize: Int): Int {
        val arr = Array(sequenceSize) { ' ' }

        var read = stream.read()
        var count = 0
        while (read != -1) {
            arr.pop(read.toChar())
            count++
            if (containsOnlyUniqueCharacters(arr)) {
                break
            }
            read = stream.read()
        }

        return count
    }

    private fun containsOnlyUniqueCharacters(arr: Array<Char>) =
        arr.toHashSet().size == arr.size && !arr.toHashSet().contains(' ')
}