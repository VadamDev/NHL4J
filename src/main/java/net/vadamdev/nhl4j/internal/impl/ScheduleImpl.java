package net.vadamdev.nhl4j.internal.impl;

import net.vadamdev.nhl4j.api.entities.Game;
import net.vadamdev.nhl4j.api.entities.Schedule;

import java.util.Date;
import java.util.List;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public class ScheduleImpl implements Schedule {
    private final List<Game> games;
    private final Date date;

    public ScheduleImpl(List<Game> games, Date date) {
        this.games = games;
        this.date = date;
    }

    @Override
    public List<Game> getGames() {
        return games;
    }

    @Override
    public int getTotalGames() {
        return games.size();
    }

    @Override
    public Date getDate() {
        return date;
    }
}
