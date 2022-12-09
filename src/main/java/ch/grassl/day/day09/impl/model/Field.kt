package ch.grassl.day.day09.impl.model

class Field(
    private var primary: State? = null,
    private var secondary: State = State.EMPTY
) {

    fun setPrimaryState(state: State?) {
        primary = state
    }

    fun setSecondaryState(state: State) {
        secondary = state
    }

    fun getState(): State? {
        return if (primary != null) primary else secondary
    }

    fun getSecondaryState(): State {
        return secondary
    }

    override fun toString(): String {
        return getState().toString()
    }
}