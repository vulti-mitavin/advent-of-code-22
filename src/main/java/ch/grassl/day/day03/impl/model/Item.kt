package ch.grassl.day.day03.impl.model

import java.util.*

class Item(private val type: Char) {
    private val ASCII_START_INDEX_LOWER_CASE_ALPHABET = 96
    private val ASCII_START_INDEX_UPPER_CASE_ALPHABET = 65
    private val ALPHABET_SIZE = 26

    private val priority: Int

    init {
        priority = calculatePriority()
    }

    private fun calculatePriority(): Int {
        return if (type.code > ASCII_START_INDEX_LOWER_CASE_ALPHABET) {
            type.code - ASCII_START_INDEX_LOWER_CASE_ALPHABET
        } else {
            type.code - ASCII_START_INDEX_UPPER_CASE_ALPHABET + ALPHABET_SIZE + 1
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val item = other as Item
        return type == item.type && priority == item.priority
    }

    override fun hashCode(): Int {
        return Objects.hash(type, priority)
    }

    fun getPriority(): Int {
        return priority
    }

}