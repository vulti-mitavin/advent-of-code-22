package ch.grassl.common

import ch.grassl.util.ResourceReader

interface Importer<T> {

    fun importData(resource: String): List<T>

    companion object {
        @JvmStatic
        fun read(resource: String): Array<String> {
            return ResourceReader.of(resource).read()
        }
    }
}