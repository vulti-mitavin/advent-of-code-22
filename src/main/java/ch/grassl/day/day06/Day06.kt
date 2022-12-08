package ch.grassl.day.day06

import ch.grassl.common.AdventOfCodeDay
import ch.grassl.day.day06.impl.SignalReader

class Day06 : AdventOfCodeDay() {

    companion object {
        const val RESOURCE = "/day6.txt"
    }

    override fun run() {
        result.add(SignalReader().findMarker(RESOURCE, 4))
        result.add(SignalReader().findMarker(RESOURCE, 14))
        printResult()
    }
}