package ch.grassl.day04.impl

class Elf(private val sectionRange: IntRange) {

    private fun IntRange.includes(other: IntRange): Boolean {
        return this.first <= other.first && this.last >= other.last
    }

    private fun IntRange.overlaps(other: IntRange): Boolean {
        return this.contains(other.first) || this.contains(other.last)
    }

    fun isSectionRangeIncluding(other: Elf): Boolean {
        val thisRange = this.sectionRange
        val otherRange = other.sectionRange
        return thisRange.includes(otherRange)
    }

    fun isSectionRangeOverlapping(other: Elf): Boolean {
        val thisRange = this.sectionRange
        val otherRange = other.sectionRange
        return thisRange.overlaps(otherRange)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Elf
        return sectionRange == other.sectionRange
    }

    override fun hashCode(): Int {
        return sectionRange.hashCode()
    }
}
