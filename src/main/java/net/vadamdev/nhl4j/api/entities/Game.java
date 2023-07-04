package net.vadamdev.nhl4j.api.entities;

import net.vadamdev.nhl4j.api.NHLGameState;
import net.vadamdev.nhl4j.api.TeamData;

import java.util.Date;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public interface Game {
    TeamData[] getTeams();

    NHLGameState getState();

    @Deprecated
    Date getDate();
    long getGamePk();
}
