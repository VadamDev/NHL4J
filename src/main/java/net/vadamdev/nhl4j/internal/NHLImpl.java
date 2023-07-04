package net.vadamdev.nhl4j.internal;

import net.vadamdev.nhl4j.api.NHL;
import net.vadamdev.nhl4j.api.NHLRequest;
import net.vadamdev.nhl4j.api.entities.Schedule;
import net.vadamdev.nhl4j.internal.requester.ScheduleRequester;

import java.util.Date;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public class NHLImpl implements NHL {
    @Override
    public NHLRequest<Schedule> getTodaySchedule() {
        return new NHLRequestImpl<>(ScheduleRequester.request(null));
    }

    @Override
    public NHLRequest<Schedule> getSchedule(Date date) {
        return new NHLRequestImpl<>(ScheduleRequester.request(date));
    }
}
