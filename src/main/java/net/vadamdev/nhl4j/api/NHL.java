package net.vadamdev.nhl4j.api;

import net.vadamdev.nhl4j.api.entities.Schedule;
import net.vadamdev.nhl4j.internal.NHLImpl;

import java.util.Date;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public interface NHL {
    NHLRequest<Schedule> getTodaySchedule();
    NHLRequest<Schedule> getSchedule(Date date);

    static NHL getAPI() {
        return new NHLImpl();
    }
}
