package ch.grassl.day03.impl;

import ch.grassl.day03.Day03;

import java.util.ArrayList;
import java.util.List;

public class RucksackService {

    private final List<Rucksack> rucksacks;

    private RucksackService(List<Rucksack> rucksacks) {
        this.rucksacks = rucksacks;
    }

    public static RucksackService of(List<Rucksack> rucksacks) {
        return new RucksackService(new ArrayList<>(rucksacks));
    }

    public int findPriorityScore() {
        return rucksacks.stream()
                .map(Rucksack::findError)
                .mapToInt(Item::getPriority)
                .sum();
    }

    public int findTeamPriorityScore() {
        List<Team> teams = getTeams();
        return teams.stream()
                .map(Team::findBadge)
                .mapToInt(Item::getPriority)
                .sum();
    }

    private List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < rucksacks.size(); i += Day03.TEAM_SIZE) {
            List<Rucksack> team = new ArrayList<>();
            for (int j = i; j < i + Day03.TEAM_SIZE; j++) {
                team.add(rucksacks.get(j));
            }
            teams.add(new Team(team));
        }
        return teams;
    }
}
