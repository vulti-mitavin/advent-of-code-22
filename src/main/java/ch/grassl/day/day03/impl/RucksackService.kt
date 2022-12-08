package ch.grassl.day.day03.impl

import ch.grassl.day.day03.Day03.Companion.TEAM_SIZE
import ch.grassl.day.day03.impl.model.Rucksack
import ch.grassl.day.day03.impl.model.Team

class RucksackService private constructor(private val rucksacks: List<Rucksack>) {

    companion object {
        fun of(rucksacks: List<Rucksack>): RucksackService {
            return RucksackService(rucksacks)
        }
    }

    fun findPriorityScore(): Int {
        return rucksacks.sumOf { it.getErrorPriority() }
    }

    fun findTeamPriorityScore(): Int {
        val teams = getTeams()
        return teams.sumOf { it.findBadge().getPriority() }
    }

    private fun getTeams(): List<Team> {
        return rucksacks
            .chunked(TEAM_SIZE)
            .map { Team(it) }
    }
}