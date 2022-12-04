package ch.grassl.day04.impl

class SectionService private constructor(private val pairs: List<Pair<Elf, Elf>>) {

    companion object {
        fun of(pairs: List<Pair<Elf, Elf>>): SectionService {
            return SectionService(pairs)
        }
    }

    fun numberOfPairsWithEnclosingSections(): Int {
        return pairs
            .count { pair ->
                pair.first.isSectionRangeIncluding(pair.second) || pair.second.isSectionRangeIncluding(pair.first)
            }
    }

    fun numberOfPairsWithOverlappingSections(): Int {
        return pairs
            .count { pair ->
                pair.first.isSectionRangeOverlapping(pair.second) || pair.second.isSectionRangeOverlapping(pair.first)
            }
    }
}