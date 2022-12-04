package ch.grassl.common

import org.slf4j.LoggerFactory
import java.util.*

abstract class AdventOfCodeDay {

    private val log = LoggerFactory.getLogger(this.javaClass)

    val result = LinkedList<Any>()

    abstract fun run()

    fun printResult() {
        val day = this.javaClass.simpleName
        log.info("----------- {} ------------", day)
        result.forEach {
            log.info("{}: The {}. result is: {}", day, result.indexOf(it) + 1, it)
        }
    }
}
