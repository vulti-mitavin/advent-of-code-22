package ch.grassl.day.day05.impl

import java.util.*

class CargoConfiguration(
    private val stacks: LinkedList<String>,
    private val moves: LinkedList<Move>
) {

    fun getStacks(): LinkedList<String> {
        return stacks
    }

    fun getMoves(): LinkedList<Move> {
        return moves
    }

    fun printStack(): String {
        return stacks
            .filter { it.isNotEmpty() }
            .map { it[0] }
            .toString()
            .replace(Regex("[\\[\\], ]"), "")
    }

    fun applyMoves(mode: Int) {
        for (move in moves) {
            if (stacks[move.from].length >= move.amount) {
                moveChars(move, mode)
            }
        }
    }

    fun moveChars(move: Move, mode: Int) {
        if (mode == 9000) {
            for (i in 0 until move.amount) {
                stacks[move.to] = stacks[move.from][0] + stacks[move.to]
                stacks[move.from] = stacks[move.from].substring(1)
            }
        } else {
            stacks[move.to] = stacks[move.from].substring(0 until move.amount) + stacks[move.to]
            stacks[move.from] = stacks[move.from].substring(move.amount)
        }
    }
}
