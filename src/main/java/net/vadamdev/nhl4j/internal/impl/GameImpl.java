package net.vadamdev.nhl4j.internal.impl;

import net.vadamdev.nhl4j.api.NHLGameState;
import net.vadamdev.nhl4j.api.TeamData;
import net.vadamdev.nhl4j.api.entities.Game;

import java.util.Date;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public class GameImpl implements Game {
    private final TeamData[] teamData;
    private final NHLGameState gameState;
    private final Date date;
    private final long gamePk;

    public GameImpl(TeamData[] teamData, NHLGameState gameState, Date date, long gamePk) {
        this.teamData = teamData;
        this.gameState = gameState;
        this.date = date;
        this.gamePk = gamePk;
    }

    @Override
    public TeamData[] getTeams() {
        return teamData;
    }

    @Override
    public NHLGameState getState() {
        return gameState;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public long getGamePk() {
        return gamePk;
    }
}
