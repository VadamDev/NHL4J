package net.vadamdev.nhl4j.api.entities;

import java.util.Date;
import java.util.List;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public interface Schedule {
    List<Game> getGames();
    int getTotalGames();

    Date getDate();
}
