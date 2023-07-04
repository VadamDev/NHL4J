package net.vadamdev.nhl4j.api.entities;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public interface Team {
    String getName();
    long getId();

    default String getLogoURL() {
        return "https://www-league.nhlstatic.com/images/logos/teams-current-primary-light/" + getId() + ".svg";
    }
}
