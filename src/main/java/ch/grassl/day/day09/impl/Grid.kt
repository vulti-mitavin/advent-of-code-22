package ch.grassl.day.day09.impl

import ch.grassl.day.day09.impl.model.Direction
import ch.grassl.day.day09.impl.model.Field
import ch.grassl.day.day09.impl.model.Move
import ch.grassl.day.day09.impl.model.State
import kotlin.math.abs

class Grid(
    private val moves: List<Move>,
    private val size: Int = 10
) {

    private var fields: Array<Array<Field>> = Array(size) { Array(size) { Field() } }

    private var currentHead = 0 to 0
    private var currentTail = 0 to 0

    init {
        setStart()
    }

    fun countVisited(): Int {
        return fields.sumOf { fields ->
            fields.count { field -> field.getSecondaryState() == State.VISITED_BY_TAIL }
        }
    }

    fun applyMoves(print: Boolean = false) {
        currentHead = fields.size / 2 to fields.size / 2
        fields[currentHead.first][currentHead.second].setPrimaryState(State.HEAD)
        if (print) println("== INITIAL STATE ==")
        if (print) print("\n$this\n")

        for (move in moves) {
            applyMove(print, move, moves[0].direction)
        }
    }

    private fun applyMove(
        print: Boolean,
        move: Move,
        initialDirection: Direction
    ) {
        var currentDirection = initialDirection
        if (print) print("\n== ${move.direction} ${move.steps} ==\n")

        for (step in 0 until move.steps) {

            val diff = abs((currentHead.first + currentHead.second) - (currentTail.first + currentTail.second))

            if (move.direction != currentDirection && diff < 2) {
                when (move.direction) {
                    Direction.U -> moveHeadUp()
                    Direction.R -> moveHeadRight()
                    Direction.D -> moveHeadDown()
                    Direction.L -> moveHeadLeft()
                }
                currentDirection = move.direction
            } else {
                doMove(currentDirection)
            }

            if (print) print("\n$this\n")
        }
    }

    private fun moveUp() {
        moveHeadUp()
        moveTailUp()
    }

    private fun moveRight() {
        moveHeadRight()
        moveTailRight()
    }

    private fun moveDown() {
        moveHeadDown()
        moveTailDown()
    }

    private fun moveLeft() {
        moveHeadLeft()
        moveTailLeft()
    }

    private fun moveTailUp() {
        val oldTail = currentTail
        currentTail = currentHead.first + 1 to currentHead.second
        updateTail(oldTail)
    }

    private fun moveHeadDown() {
        val oldHead = currentHead
        currentHead = currentHead.first + 1 to currentHead.second
        updateHead(oldHead)
    }

    private fun moveHeadUp() {
        val oldHead = currentHead
        currentHead = currentHead.first - 1 to currentHead.second
        updateHead(oldHead)
    }

    private fun moveTailDown() {
        val oldTail = currentTail
        currentTail = currentHead.first - 1 to currentHead.second
        updateTail(oldTail)
    }

    private fun moveTailRight() {
        val oldTail = currentTail
        currentTail = currentHead.first to currentHead.second - 1
        updateTail(oldTail)
    }

    private fun moveHeadLeft() {
        val oldHead = currentHead
        currentHead = currentHead.first to currentHead.second - 1
        updateHead(oldHead)
    }

    private fun moveHeadRight() {
        val oldHead = currentHead
        currentHead = currentHead.first to currentHead.second + 1
        updateHead(oldHead)
    }

    private fun moveTailLeft() {
        val oldTail = currentTail
        currentTail = currentHead.first to currentHead.second + 1
        updateTail(oldTail)
    }

    private fun doMove(currentDirection: Direction) {
        when (currentDirection) {
            Direction.U -> moveUp()
            Direction.R -> moveRight()
            Direction.D -> moveDown()
            Direction.L -> moveLeft()
        }
    }

    private fun updateHead(oldHead: Pair<Int, Int>) {
        val field = fields[currentHead.first][currentHead.second]
        field.setPrimaryState(State.HEAD)
        resetHead(oldHead)
    }

    private fun resetHead(oldHead: Pair<Int, Int>) {
        fields[oldHead.first][oldHead.second].setPrimaryState(null)
    }

    private fun updateTail(oldTail: Pair<Int, Int>) {
        fields[currentTail.first][currentTail.second].setPrimaryState(State.TAIL)
        resetTail(oldTail)
    }

    private fun resetTail(oldTail: Pair<Int, Int>) {
        val oldfield = fields[oldTail.first][oldTail.second]
        oldfield.setPrimaryState(null)
        if (oldTail != 0 to 0 && oldfield.getSecondaryState() != State.START) {
            oldfield.setSecondaryState(State.VISITED_BY_TAIL)
        }
    }

    private fun setStart() {
        fields[size / 2][size / 2].setSecondaryState(State.START)
    }

    fun getFields(): Array<Array<Field>> {
        return fields
    }

    override fun toString(): String {
        var string = ""
        for (column in fields) {
            string += column.joinToString(" ") + "\n"
        }
        return string
    }
}
