package net.vadamdev.nhl4j.internal.impl;

import net.vadamdev.nhl4j.api.entities.Team;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public class TeamImpl implements Team {
    private final String name;
    private final long id;

    public TeamImpl(String name, long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getId() {
        return id;
    }
}
