package ch.grassl.day.day03.impl.model

import java.util.stream.Stream

class Rucksack private constructor(
    front: List<Item>,
    back: List<Item>
) {

    var front = front
        private set

    var back = back
        private set

    fun getErrorPriority(): Int {
        return findError().getPriority()
    }

    fun findError(): Item {
        val uniqueFront: Set<Item> = HashSet(front)
        val uniqueBack: Set<Item> = HashSet(back)

        return uniqueFront.stream()
            .filter(uniqueBack::contains)
            .findFirst()
            .orElseThrow {
                IllegalStateException("No error found in Backpack. There has to be an error.")
            }
    }

    fun getInventory(): List<Item> {
        return Stream.concat(front.stream(), back.stream()).toList()
    }

    data class Builder(
        var front: List<Item> = ArrayList(),
        var back: List<Item> = ArrayList()
    ) {

        fun front(front: List<Item>) = apply { this.front = front }
        fun back(back: List<Item>) = apply { this.back = back }
        fun build() = Rucksack(front, back)
    }
}