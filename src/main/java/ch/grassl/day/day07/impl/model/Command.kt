package ch.grassl.day.day07.impl.model

const val COMMAND_PREFIX = "$"

abstract class Command {
    abstract fun getName(): String
}


class ChangeDirectory(
    val arg: String
) : Command() {

    override fun getName(): String {
        return "cd"
    }
}

class ListDirectory(
    val output: List<String> = ArrayList()
) : Command() {

    override fun getName(): String {
        return "ls"
    }
}
