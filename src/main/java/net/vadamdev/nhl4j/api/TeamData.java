package net.vadamdev.nhl4j.api;

import net.vadamdev.nhl4j.api.entities.Team;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public class TeamData {
    private final Team team;
    private final long score;

    public TeamData(Team team, long score) {
        this.team = team;
        this.score = score;
    }

    public Team getTeam() {
        return team;
    }

    public long getScore() {
        return score;
    }
}
